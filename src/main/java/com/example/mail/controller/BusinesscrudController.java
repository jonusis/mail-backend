package com.example.mail.controller;

import com.example.mail.Pojo.Business;
import com.example.mail.Pojo.PagehelpResult;
import com.example.mail.Pojo.Result;
import com.example.mail.Service.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "business增删查改")
@RequestMapping(value = "/v1/business")

public class BusinesscrudController {
    @Autowired
    private BusinesscrudService BusinesscrudService;

    @CrossOrigin
    @RequestMapping(value = "/queryBusinessList", method = RequestMethod.GET)
    public PagehelpResult<List<Business>> queryBusinessList(@RequestParam(defaultValue = "1") String pageNum, @RequestParam(defaultValue = "5") String pageSize){
        int pagenum = Integer.parseInt(pageNum);
        int pagesize = Integer.parseInt(pageSize);
        return BusinesscrudService.queryBusinessList(pagenum,pagesize);
    }


    @CrossOrigin
    @RequestMapping(value = "/queryBusinessById", method = RequestMethod.GET)
    public Result<Business> queryBusinessById(@RequestParam String bid){
        int id = Integer.parseInt(bid);
        return BusinesscrudService.queryBusinessById(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/addBusiness", method = RequestMethod.POST)
    public Result<String> addBusiness(@RequestBody Business business){
        String name = business.getName();
        String account = business.getAccount();
        String password = business.getPassword();
        String introduction = business.getIntroduction();
        return BusinesscrudService.addBusiness(name,account,password,introduction);
    }

    @CrossOrigin
    @RequestMapping(value = "/updateBusiness", method = RequestMethod.PUT)
    public Result<String> updateBusiness(@RequestBody Business business){
        int bid = business.getBid();
        String name = business.getName();
        String account = business.getAccount();
        String introduction = business.getIntroduction();
        return BusinesscrudService.updateBusiness(bid,name,account,introduction);
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteBusiness", method = RequestMethod.DELETE)
    public Result<String> deleteBusiness(@RequestParam String bid){
        int id = Integer.parseInt(bid);
        return BusinesscrudService.deleteBusiness(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/BusinessLogin", method = RequestMethod.GET)
    public Result<String> UserLogin(@RequestParam String account,@RequestParam String password){
        return BusinesscrudService.Login(account,password);
    }
}
