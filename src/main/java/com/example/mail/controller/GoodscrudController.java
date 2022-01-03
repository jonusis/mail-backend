package com.example.mail.controller;

import com.example.mail.Pojo.Business;
import com.example.mail.Pojo.Goods;
import com.example.mail.Pojo.PagehelpResult;
import com.example.mail.Pojo.Result;
import com.example.mail.Service.GoodscrudService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "goods增删查改")
@RequestMapping(value = "/v1/goods")
public class GoodscrudController {
    @Autowired
    private GoodscrudService GoodscrudService;

    @CrossOrigin
    @RequestMapping(value = "/queryGoodsList", method = RequestMethod.GET)
    public PagehelpResult<List<Goods>> queryGoodsList(@RequestParam(defaultValue = "1") String pageNum, @RequestParam(defaultValue = "5") String pageSize){
        int pagenum = Integer.parseInt(pageNum);
        int pagesize = Integer.parseInt(pageSize);
        return GoodscrudService.queryGoodsList(pagenum,pagesize);
    }

    @CrossOrigin
    @RequestMapping(value = "/queryGoodsByGid", method = RequestMethod.GET)
    public Result<Goods> queryGoodsByGid(@RequestParam String gid){
        int id = Integer.parseInt(gid);
        return GoodscrudService.queryGoodsByGid(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/queryGoodsByBid", method = RequestMethod.GET)
    public PagehelpResult<List<Goods>> queryGoodsByBid(@RequestParam String bid, @RequestParam(defaultValue = "1") String pageNum, @RequestParam(defaultValue = "5") String pageSize){
        int pagenum = Integer.parseInt(pageNum);
        int pagesize = Integer.parseInt(pageSize);
        int id = Integer.parseInt(bid);
        return GoodscrudService.queryGoodsByBid(id,pagenum,pagesize);
    }

    @CrossOrigin
    @RequestMapping(value = "/queryGoodsByType", method = RequestMethod.GET)
    public PagehelpResult<List<Goods>> queryGoodsByType(@RequestParam String type, @RequestParam(defaultValue = "1") String pageNum, @RequestParam(defaultValue = "5") String pageSize){
        int pagenum = Integer.parseInt(pageNum);
        int pagesize = Integer.parseInt(pageSize);
        return GoodscrudService.queryGoodsByType(type,pagenum,pagesize);
    }

    @CrossOrigin
    @RequestMapping(value = "/addGoods", method = RequestMethod.POST)
    public Result<String> addGoods(@RequestBody Goods goods){
        int bid = goods.getBid();
        String name = goods.getName();
        String type = goods.getType();
        int price = goods.getPrice();
        int count = goods.getCount();
        String introduction = goods.getIntroduction();
        return GoodscrudService.addGoods(bid,name,type,price,count,introduction);
    }

    @CrossOrigin
    @RequestMapping(value = "/updateGoods", method = RequestMethod.PUT)
    public Result<String> updateGoods(@RequestBody Goods goods){
        int gid = goods.getGid();
        int bid = goods.getBid();
        String name = goods.getName();
        String type = goods.getType();
        int price = goods.getPrice();
        int count = goods.getCount();
        String introduction = goods.getIntroduction();
        return GoodscrudService.updateGoods(gid,bid,name,type,price,count,introduction);
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteGoods", method = RequestMethod.DELETE)
    public Result<String> deleteGoods(@RequestParam String gid){
        int id = Integer.parseInt(gid);
        return GoodscrudService.deleteGoods(id);
    }
}
