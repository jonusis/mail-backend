package com.example.mail.Controller;

import com.example.mail.Compound.DeliveryPay_goods;
import com.example.mail.Pojo.Delivery;
import com.example.mail.Pojo.Pay_goods;
import com.example.mail.ResultSet.PagehelpResult;
import com.example.mail.ResultSet.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags = "delivery增删查改")
@RequestMapping(value = "/v1/delivery")
@CrossOrigin(origins = "*")
public class DeliverycrudController {
    @Autowired
    private com.example.mail.Service.DeliverycrudService DeliverycrudService;
    @Autowired
    private com.example.mail.Service.Pay_goodscrudService pay_goodscrudService;

    @RequestMapping(value = "/getDeliveryPay_goodsByUid", method = RequestMethod.GET)
    public Result<List<DeliveryPay_goods>> getDeliveryPay_goodsByUid(@RequestParam String uid){
        int id = Integer.parseInt(uid);
        DeliveryPay_goods deliveryPay_goods = null;
        List<DeliveryPay_goods> deliveryPay_goodsList = new ArrayList<>();
        int oid = 0;
        List<Delivery> deliveryList = DeliverycrudService.queryDeliveryByUid(id);
        for(int i = 0; i < deliveryList.size(); i++) {
            oid = deliveryList.get(i).getOid();
            Pay_goods pay_goods = pay_goodscrudService.queryPay_goodsByOidUid(oid,id);
            deliveryPay_goods = new DeliveryPay_goods(deliveryList.get(i),pay_goods);
            deliveryPay_goodsList.add(deliveryPay_goods);
        }
        return Result.success(deliveryPay_goodsList);
    }

    @RequestMapping(value = "/getDeliveryByOid", method = RequestMethod.GET)
    public Result<List<Delivery>> getDeliveryByOid(@RequestParam String oid){
        int id = Integer.parseInt(oid);
        return DeliverycrudService.queryDeliveryByOid(id);
    }

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
    public Result<List<Delivery>> queryDeliveryByUid(@RequestParam String uid){
        int id = Integer.parseInt(uid);
        return Result.success(DeliverycrudService.queryDeliveryByUid(id));
    }

    @RequestMapping(value = "/queryDeliveryByOid", method = RequestMethod.GET)
    public Result<List<Delivery>> queryDeliveryByOid(@RequestParam String oid){
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
