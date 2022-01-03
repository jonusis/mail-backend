package com.example.mail.controller;
import com.example.mail.Mapper.UserMapper;
import com.example.mail.Pojo.CodeMsg;
import com.example.mail.Pojo.Result;
import com.example.mail.Pojo.User;
import com.example.mail.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/v1")

public class hellocontroller {

    @Autowired
    private UserService UserService;

    @CrossOrigin
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public Result<String> addUser(HttpServletRequest req, HttpServletResponse resp){
        String name = req.getParameter("name");
        String account = req.getParameter("username");
        String password = req.getParameter("password");
        int age = Integer.parseInt(req.getParameter("age"));
        int sex = Integer.parseInt(req.getParameter("sex"));
        return UserService.addUser(name,account,password,age,sex);
    }

    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<String> Login(HttpServletRequest req, HttpServletResponse resp){
        String account = req.getParameter("username");
        String password = req.getParameter("password");
        return UserService.Login(account,password);
    }

    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }
}
