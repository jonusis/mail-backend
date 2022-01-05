package com.example.mail.Service;

import com.example.mail.ResultSet.CodeMsg;
import com.example.mail.ResultSet.PagehelpResult;
import com.example.mail.ResultSet.Result;
import com.example.mail.Mapper.UserMapper;
import com.example.mail.Pojo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsercrudService {

    @Autowired
    UserMapper userMapper;

    public List<User> searchUser(String name, String account, int age, int sex) {
        List<User> userList = userMapper.searchUser(name,account,age,sex);
        return userList;
    }

    public PagehelpResult<List<User>> queryUserList(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        List<User> users = userMapper.queryUserList();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        List<User> list = pageInfo.getList();
        int pageNumber = pageInfo.getPageNum();
        int PageSize = pageInfo.getPages();
        return PagehelpResult.success(list,pageNumber,PageSize);
    }

    public User queryUserById(int uid) {
        User user = null;
        try {
            user = userMapper.queryUserById(uid);
        } catch (Exception e) {
            return null;
        }
        return user;
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

    public Result<String> updateUser(int uid, String name, String account, int age, int sex) {
        try {
            User user1 = userMapper.queryUserById(uid);
            userMapper.updateUser(new User(uid,name,account,user1.getPassword(),age,sex));
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

    public PagehelpResult<List<User>> queryUserByName(String name, int pagenum, int pagesize) {
        PageHelper.startPage(pagenum,pagesize);
        List<User> users = userMapper.queryUserByName(name);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        List<User> list = pageInfo.getList();
        int pageNumber = pageInfo.getPageNum();
        int PageSize = pageInfo.getPages();
        return PagehelpResult.success(list,pageNumber,PageSize);
    }
}
