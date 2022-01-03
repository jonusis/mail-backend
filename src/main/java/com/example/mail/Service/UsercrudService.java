package com.example.mail.Service;

import com.example.mail.Mapper.UserMapper;
import com.example.mail.Pojo.CodeMsg;
import com.example.mail.Pojo.Result;
import com.example.mail.Pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsercrudService {

    @Autowired
    UserMapper userMapper;

    public Result<PageInfo<User>> queryUserList(Integer pageNum,Integer pageSize) {

        PageHelper.startPage(1,3);
        List<User> users = userMapper.queryUserList();
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        return Result.success(pageInfo);//Result<PageInfo<User>>

//        List<User> users = userMapper.queryUserList();
//        return Result.success(users);
    }

    public Result<User> queryUserById(int uid) {
        User user = null;
        try {
            user = userMapper.queryUserById(uid);
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success(user);
    }

    public Result<String> addUser(String name, String account, String password, int age, int sex){
        try{
            int id = userMapper.selectIdMaxUser() + 1;
            userMapper.addUser(new User(id,name,account,password,age,sex));
        }catch (Exception e){
            return Result.error(new CodeMsg(0,e.toString()));
        }
        return Result.success("success Register");
    }

    public Result<String> updateUser(int uid, String name, String account, String password, int age, int sex) {
        try {
            userMapper.updateUser(new User(uid,name,account,password,age,sex));
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success("success updateUser");
    }

    public Result<String> deleteUser(int uid) {
        try {
            userMapper.deleteUser(uid);
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success("success deleteUser");
    }

    public Result<String> Login(String account, String password){
        List<User> res = userMapper.selectUserLogin(account,password);
        if(res.size() == 0){
            return Result.error(new CodeMsg(400,"登陆失败"));
        }else{
            return Result.success("登陆成功");
        }
    }

}
