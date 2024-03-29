package com.example.mail.Controller;

import com.example.mail.Pojo.Pay_goods;
import com.example.mail.ResultSet.PagehelpResult;
import com.example.mail.ResultSet.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "pay_goods增删查改")
@RequestMapping(value = "/v1/pay_goods")
@CrossOrigin(origins = "*")
public class Pay_goodscrudController {
    @Autowired
    private com.example.mail.Service.Pay_goodscrudService Pay_goodscrudService;

    @RequestMapping(value = "/queryPay_goodsList", method = RequestMethod.GET)
    public PagehelpResult<List<Pay_goods>> queryPay_goodsList(@RequestParam(defaultValue = "1") String pageNum, @RequestParam(defaultValue = "5") String pageSize){
        int pagenum = Integer.parseInt(pageNum);
        int pagesize = Integer.parseInt(pageSize);
        return Pay_goodscrudService.queryPay_goodsList(pagenum,pagesize);
    }
    
    @RequestMapping(value = "/queryPay_goodsByPid", method = RequestMethod.GET)
    public Result<Pay_goods> queryPay_goodsByPid(@RequestParam String pid){
        int id = Integer.parseInt(pid);
        return Pay_goodscrudService.queryPay_goodsByPid(id);
    }

    @RequestMapping(value = "/queryPay_goodsByUid", method = RequestMethod.GET)
    public Result<List<Pay_goods>> queryPay_goodsByUid(@RequestParam String uid){
        int id = Integer.parseInt(uid);
        return Pay_goodscrudService.queryPay_goodsByUid(id);
    }

    @RequestMapping(value = "/queryPay_goodsByOid", method = RequestMethod.GET)
    public Result<List<Pay_goods>> queryPay_goodsByOid(@RequestParam String oid){
        int id = Integer.parseInt(oid);
        return Result.success(Pay_goodscrudService.queryPay_goodsByOid(id));
    }

    @RequestMapping(value = "/addPay_goods", method = RequestMethod.POST)
    public Result<String> addPay_goods(@RequestBody Pay_goods pay_goods){
        int uid = pay_goods.getUid();
        int oid = pay_goods.getOid();
        int state = pay_goods.getState();
        int gcount = pay_goods.getGcount();
        int aid = pay_goods.getAid();
        return Pay_goodscrudService.addPay_goods(uid,oid,state,gcount,aid);
    }

    @RequestMapping(value = "/updatePay_goods", method = RequestMethod.PUT)
    public Result<String> updatePay_goods(@RequestBody Pay_goods pay_goods){
        int pid = pay_goods.getPid();
        int uid = pay_goods.getUid();
        int oid = pay_goods.getOid();
        int state = pay_goods.getState();
        int gcount = pay_goods.getGcount();
        int aid = pay_goods.getAid();
        return Pay_goodscrudService.updatePay_goods(pid,uid,oid,state,gcount,aid);
    }

    @RequestMapping(value = "/deletePay_goods", method = RequestMethod.DELETE)
    public Result<String> deletePay_goods(@RequestParam String pid){
        int id = Integer.parseInt(pid);
        return Pay_goodscrudService.deletePay_goods(id);
    }
}
