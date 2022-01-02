package com.example.mail.Service;

import com.example.mail.Mapper.BusinessMapper;
import com.example.mail.Pojo.Business;
import com.example.mail.Pojo.CodeMsg;
import com.example.mail.Pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinesscrudService {

    @Autowired
    BusinessMapper businessMapper;

    public Result<List<Business>> queryBusinessList(Integer pageNum, Integer pageSize) {
        List<Business> buiness = businessMapper.queryBusinessList();
        return Result.success(buiness);
    }

    public Result<Business> queryBusinessById(int bid) {
        Business buiness = null;
        try {
            buiness = businessMapper.queryBusinessById(bid);
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success(buiness);
    }

    public Result<String> addBusiness(String name, String account, String password, String introduction){
        try{
            int id = businessMapper.selectIdMaxBusiness() + 1;
            businessMapper.addBusiness(new Business(id,name,account,password,introduction));
        }catch (Exception e){
            return Result.error(new CodeMsg(0,e.toString()));
        }
        return Result.success("success Register");
    }

    public Result<String> updateBusiness(int bid, String name, String account, String password, String introduction) {
        try {
            businessMapper.updateBusiness(new Business(bid,name,account,password,introduction));
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success("success updateUser");
    }

    public Result<String> deleteBusiness(int bid) {
        try {
            businessMapper.deleteBusiness(bid);
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success("success deleteUser");
    }

    public Result<String> Login(String account, String password){
        List<Business> res = businessMapper.selectBusinessLogin(account,password);
        if(res.size() == 0){
            return Result.error(new CodeMsg(400,"登陆失败"));
        }else{
            return Result.success("登陆成功");
        }
    }
}