package com.example.mail.Controller.wdnmd;

import com.example.mail.Pojo.User;
import com.example.mail.ResultSet.Result;
import com.example.mail.Service.UsercrudService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/user")
@Api(tags = "拼拼user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private com.example.mail.Service.UsercrudService usercrudService;

    @RequestMapping(value = "/info", method = RequestMethod.PUT)
    public Result<User> updateUserInfo(@RequestBody User user){
        int uid = user.getUid();    //from body
        User userGet = usercrudService.queryUserById(user.getUid());
        String name = userGet.getName();
        String account = user.getAccount(); //from body(username)
        int age = userGet.getAge();
        int sex = userGet.getSex();
        String stNum = userGet.getStNum();
        String headPicture = user.getHeadPicture(); //from body
        String tel = user.getTel(); //from body
        if(tel == null){
            tel = userGet.getTel();
        }
        String qq = user.getQq();   //from body
        if(qq == null){
            qq = userGet.getQq();
        }
        String wechat = user.getWechat();   //from body
        if(wechat == null){
            wechat = userGet.getWechat();
        }
        return usercrudService.updateUser(uid,name,account,age,sex,stNum,headPicture,tel,qq,wechat);

    }
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public Result<User> getUserInfo(@RequestParam int uid){
        return Result.success(usercrudService.queryUserById(uid));
    }
}
