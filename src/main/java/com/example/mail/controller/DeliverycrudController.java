package com.example.mail.controller;

import com.example.mail.Pojo.Delivery;
import com.example.mail.Pojo.PagehelpResult;
import com.example.mail.Pojo.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "delivery增删查改")
@RequestMapping(value = "/v1/delivery")
@CrossOrigin(origins = "*")
public class DeliverycrudController {
    @Autowired
    private com.example.mail.Service.DeliverycrudService DeliverycrudService;

    @RequestMapping(value = "/queryDeliveryList", method = RequestMethod.GET)
    public PagehelpResult<List<Delivery>> queryDeliveryList(@RequestParam(defaultValue = "1") String pageNum, @RequestParam(defaultValue = "5") String pageSize){
        int pagenum = Integer.parseInt(pageNum);
        int pagesize = Integer.parseInt(pageSize);
        return DeliverycrudService.queryDeliveryList(pagenum,pagesize);
    }

    @RequestMapping(value = "/queryDeliveryByDid", method = RequestMethod.GET)
    public Result<Delivery> queryDeliveryByDid(@RequestParam String did){
        int id = Integer.parseInt(did);
        return DeliverycrudService.queryDeliveryByDid(id);
    }

    @RequestMapping(value = "/queryDeliveryByUid", method = RequestMethod.GET)
    public Result<Delivery> queryDeliveryByUid(@RequestParam String uid){
        int id = Integer.parseInt(uid);
        return DeliverycrudService.queryDeliveryByUid(id);
    }

    @RequestMapping(value = "/queryDeliveryByOid", method = RequestMethod.GET)
    public Result<Delivery> queryDeliveryByOid(@RequestParam String oid){
        int id = Integer.parseInt(oid);
        return DeliverycrudService.queryDeliveryByOid(id);
    }

    @RequestMapping(value = "/addDelivery", method = RequestMethod.POST)
    public Result<String> addDelivery(@RequestBody Delivery delivery){
        int uid = delivery.getUid();
        int oid = delivery.getOid();
        int state = delivery.getState();
        return DeliverycrudService.addDelivery(uid,oid,state);
    }

    @RequestMapping(value = "/updateDelivery", method = RequestMethod.PUT)
    public Result<String> updateDelivery(@RequestBody Delivery delivery){
        int did = delivery.getDid();
        int uid = delivery.getUid();
        int oid = delivery.getOid();
        int state = delivery.getState();
        return DeliverycrudService.updateDelivery(did,uid,oid,state);
    }

    @RequestMapping(value = "/deleteDelivery", method = RequestMethod.DELETE)
    public Result<String> deleteDelivery(@RequestParam String did){
        int id = Integer.parseInt(did);
        return DeliverycrudService.deleteDelivery(id);
    }
}
