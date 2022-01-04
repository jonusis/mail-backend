package com.example.mail.controller;
import com.example.mail.Pojo.PagehelpResult;
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
@RequestMapping(value = "/v1/user")
@Api(tags = "user增删查改")
@CrossOrigin(origins = "*")
public class UsercrudController {

    @Autowired
    private UsercrudService UsercrudService;

    @RequestMapping(value = "/queryUserList", method = RequestMethod.GET)
    public PagehelpResult<List<User>> queryUserList(@RequestParam(defaultValue = "1") String pageNum,@RequestParam(defaultValue = "5") String pageSize){
        int pagenum = Integer.parseInt(pageNum);
        int pagesize = Integer.parseInt(pageSize);
        return UsercrudService.queryUserList(pagenum,pagesize);
    }


    @RequestMapping(value = "/queryUserById", method = RequestMethod.GET)
    public Result<User> queryUserById(@RequestParam String uid){
        int id = Integer.parseInt(uid);
        return UsercrudService.queryUserById(id);
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public Result<String> addUser(@RequestBody User user){
        String name = user.getName();
        String account = user.getAccount();
        String password = user.getPassword();
        int age = user.getAge();
        int sex = user.getSex();
        return UsercrudService.addUser(name,account,password,age,sex);
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public Result<String> updateUser(@RequestBody User user){
        int uid = user.getUid();
        String name = user.getName();
        String account = user.getAccount();
        String password = user.getPassword();
        int age = user.getAge();
        int sex = user.getSex();
        return UsercrudService.updateUser(uid,name,account,password,age,sex);
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
    public Result<String> deleteUser(@RequestParam String uid){
        int id = Integer.parseInt(uid);
        return UsercrudService.deleteUser(id);
    }

    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public Result<String> UserLogin(@RequestParam String account,@RequestParam String password){
        return UsercrudService.Login(account,password);
    }
}
