package com.example.mail.Controller;
import com.example.mail.Pojo.Goods;
import com.example.mail.ResultSet.PagehelpResult;
import com.example.mail.ResultSet.Result;
import com.example.mail.Pojo.User;
import com.example.mail.Service.UsercrudService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/user")
@Api(tags = "user增删查改")
@CrossOrigin(origins = "*")
public class UsercrudController {

    @Autowired
    private UsercrudService UsercrudService;

    @RequestMapping(value = "/searchUser", method = RequestMethod.GET)
    public PagehelpResult<List<User>> searchUser(@RequestParam(defaultValue = "0")String name, @RequestParam(defaultValue = "0")String account, @RequestParam(defaultValue = "0") String age, @RequestParam(defaultValue = "2") String sex, @RequestParam(defaultValue = "1",required = false) String pageNum, @RequestParam(defaultValue = "8",required = false) String pageSize){
        int pagenum = Integer.parseInt(pageNum);
        int pagesize = Integer.parseInt(pageSize);
        int ageInt = Integer.parseInt(age);
        int sexInt = Integer.parseInt(sex);
        PageHelper.startPage(pagenum,pagesize);
        List<User> userList = UsercrudService.searchUser(name,account,ageInt,sexInt);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        int pageNumber = pageInfo.getPageNum();
        int PageSize = pageInfo.getPages();
        return PagehelpResult.success(userList,pageNumber,PageSize);
    }

    @RequestMapping(value = "/queryUserList", method = RequestMethod.GET)
    public PagehelpResult<List<User>> queryUserList(@RequestParam(defaultValue = "1") String pageNum,@RequestParam(defaultValue = "5") String pageSize){
        int pagenum = Integer.parseInt(pageNum);
        int pagesize = Integer.parseInt(pageSize);
        return UsercrudService.queryUserList(pagenum,pagesize);
    }

    @RequestMapping(value = "/queryUserByName", method = RequestMethod.GET)
    public PagehelpResult<List<User>> queryUserByName(@RequestParam String name,@RequestParam(defaultValue = "1") String pageNum,@RequestParam(defaultValue = "5") String pageSize){
        int pagenum = Integer.parseInt(pageNum);
        int pagesize = Integer.parseInt(pageSize);
        return UsercrudService.queryUserByName(name,pagenum,pagesize);
    }


    @RequestMapping(value = "/queryUserById", method = RequestMethod.GET)
    public Result<User> queryUserById(@RequestParam String uid){
        int id = Integer.parseInt(uid);
        return Result.success(UsercrudService.queryUserById(id));
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
        int age = user.getAge();
        int sex = user.getSex();
        return UsercrudService.updateUser(uid,name,account,age,sex);
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
    public Result<String> deleteUser(@RequestParam String uid){
        int id = Integer.parseInt(uid);
        return UsercrudService.deleteUser(id);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<String> UserLogin(@RequestParam String account,@RequestParam String password){
        return UsercrudService.Login(account,password);
    }
}
