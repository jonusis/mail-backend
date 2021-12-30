package com.example.mail.controller;
import com.example.mail.Mapper.UserMapper;
import com.example.mail.Pojo.User;
import com.sun.net.httpserver.HttpServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/v1")

public class hellocontroller {

    @Autowired
    private UserMapper userMapper;

    @CrossOrigin
    @RequestMapping(value = "/login",method=RequestMethod.POST)

    public String Login(HttpServletRequest req, HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Headers","*");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        if(username.equals("abc") && password.equals("123")){
            return "true";
        }
        return "false";
    }

    @CrossOrigin
    @RequestMapping(value = "/getUser")
    public List<User> GetUser(HttpServletRequest req, HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Headers","*");
        return userMapper.queryUserList();
    }

    @CrossOrigin
    @RequestMapping(value = "/addUser")
    public void addUser(HttpServletRequest req, HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Headers","*");
        String name = req.getParameter("name");
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        int age = Integer.parseInt(req.getParameter("age"));
        int sex = Integer.parseInt(req.getParameter("sex"));
        int uid = userMapper.selectMaxUserId() + 1;
        userMapper.addUser(new User(uid,name,account,password,age,sex));
    }
    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }
}
