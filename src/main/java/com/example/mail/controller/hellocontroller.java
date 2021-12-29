package com.example.mail.controller;
import com.sun.net.httpserver.HttpServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/v1")

public class hellocontroller {

    @RequestMapping(value = "/login",method=RequestMethod.POST)
    public String Login(HttpServletRequest req, HttpServletResponse resp){
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        if(username.equals("abc") && password.equals("111")){
            return "12334";
        }
        return "false";
    }

    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }
}
