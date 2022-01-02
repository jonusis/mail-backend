package com.example.mail.controller;

import com.example.mail.Pojo.Business;
import com.example.mail.Pojo.Result;
import com.example.mail.Pojo.User;
import com.example.mail.Service.UsercrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/crud")

public class BusinesscrudController {
    @Autowired
    private com.example.mail.Service.BusinesscrudService BusinesscrudService;

    @CrossOrigin
    @RequestMapping(value = "/queryBusinessList", method = RequestMethod.GET)
    public Result<List<Business>> queryBusinessList(HttpServletRequest req, HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Headers","*");
        int pageNum = Integer.parseInt(req.getParameter("pageNum"));
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));
        return BusinesscrudService.queryBusinessList(pageNum,pageSize);
    }


    @CrossOrigin
    @RequestMapping(value = "/queryBusinessById", method = RequestMethod.GET)
    public Result<Business> queryBusinessById(HttpServletRequest req, HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Headers","*");
        int bid = Integer.parseInt(req.getParameter("bid"));
        return BusinesscrudService.queryBusinessById(bid);
    }

    @CrossOrigin
    @RequestMapping(value = "/addBusiness", method = RequestMethod.POST)
    public Result<String> addBusiness(HttpServletRequest req, HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Headers","*");
        String name = req.getParameter("name");
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String introduction = req.getParameter("introduction");
        return BusinesscrudService.addBusiness(name,account,password,introduction);
    }

    @CrossOrigin
    @RequestMapping(value = "/updateBusiness", method = RequestMethod.PUT)
    public Result<String> updateBusiness(HttpServletRequest req, HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Headers","*");
        int bid = Integer.parseInt(req.getParameter("bid"));
        String name = req.getParameter("name");
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String introduction = req.getParameter("introduction");
        return BusinesscrudService.updateBusiness(bid,name,account,password,introduction);
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteBusiness", method = RequestMethod.DELETE)
    public Result<String> deleteBusiness(HttpServletRequest req, HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Headers","*");
        int bid = Integer.parseInt(req.getParameter("bid"));
        return BusinesscrudService.deleteBusiness(bid);
    }

    @CrossOrigin
    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public Result<String> Login(HttpServletRequest req, HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Headers","*");
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        return BusinesscrudService.Login(account,password);
    }
}
