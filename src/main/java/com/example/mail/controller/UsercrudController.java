package com.example.mail.controller;
import com.example.mail.Pojo.Result;
import com.example.mail.Pojo.User;
import com.example.mail.Service.UsercrudService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/crud")
@Api(tags = "user增删查改")
public class UsercrudController {

    @Autowired
    private UsercrudService UsercrudService;

    @CrossOrigin
    @RequestMapping(value = "/queryUserList", method = RequestMethod.GET)
    public Result<PageInfo<User>> queryUserList(HttpServletRequest req, HttpServletResponse resp){
        int pageNum = Integer.parseInt(req.getParameter("pageNum"));
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));
        return UsercrudService.queryUserList(pageNum,pageSize);
    }


    @CrossOrigin
    @RequestMapping(value = "/queryUserById", method = RequestMethod.GET)
    public Result<User> queryUserById(HttpServletRequest req, HttpServletResponse resp){
        int uid = Integer.parseInt(req.getParameter("uid"));
        return UsercrudService.queryUserById(uid);
    }

    @CrossOrigin
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public Result<String> addUser(HttpServletRequest req, HttpServletResponse resp){
        String name = req.getParameter("name");
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        int age = Integer.parseInt(req.getParameter("age"));
        int sex = Integer.parseInt(req.getParameter("sex"));
        return UsercrudService.addUser(name,account,password,age,sex);
    }

    @CrossOrigin
    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public Result<String> updateUser(HttpServletRequest req, HttpServletResponse resp){
        int uid = Integer.parseInt(req.getParameter("uid"));
        String name = req.getParameter("name");
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        int age = Integer.parseInt(req.getParameter("age"));
        int sex = Integer.parseInt(req.getParameter("sex"));
        return UsercrudService.updateUser(uid,name,account,password,age,sex);
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
    public Result<String> deleteUser(HttpServletRequest req, HttpServletResponse resp){
        int uid = Integer.parseInt(req.getParameter("uid"));
        return UsercrudService.deleteUser(uid);
    }

    @CrossOrigin
    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public Result<String> Login(HttpServletRequest req, HttpServletResponse resp){
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        return UsercrudService.Login(account,password);
    }
}
