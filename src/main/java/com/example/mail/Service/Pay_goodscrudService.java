package com.example.mail.Service;

import com.example.mail.ResultSet.CodeMsg;
import com.example.mail.ResultSet.PagehelpResult;
import com.example.mail.ResultSet.Result;
import com.example.mail.Mapper.Pay_goodsMapper;
import com.example.mail.Pojo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Pay_goodscrudService {
    @Autowired
    Pay_goodsMapper pay_goodsMapper;

//    public Result<List<User>> queryUsersByOid(int oid) {
//        List<User> users = null;
//        try {
//            users = pay_goodsMapper.queryUsersByOid(oid);
//        } catch (Exception e) {
//            return Result.error(new CodeMsg(0, e.toString()));
//        }
//        return Result.success(users);
//    }

    public PagehelpResult<List<Pay_goods>> queryPay_goodsList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Pay_goods> pay_goods = pay_goodsMapper.queryPay_goodsList();
        PageInfo<Pay_goods> pageInfo = new PageInfo<>(pay_goods);
        List<Pay_goods> list = pageInfo.getList();
        int pageNumber = pageInfo.getPageNum();
        int PageSize = pageInfo.getPages();
        return PagehelpResult.success(list,pageNumber,PageSize);
    }

    public Result<Pay_goods> queryPay_goodsByPid(int pid) {
        Pay_goods pay_goods = null;
        try {
            pay_goods = pay_goodsMapper.queryPay_goodsByPid(pid);
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success(pay_goods);
    }

    public Result<List<Pay_goods>> queryPay_goodsByUid(int uid) {
        List<Pay_goods> pay_goods = null;
        try {
            pay_goods = pay_goodsMapper.queryPay_goodsByUid(uid);
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success(pay_goods);
    }

    public Result<List<Pay_goods>> queryPay_goodsByOid(int oid) {
        List<Pay_goods> pay_goods = null;
        try {
            pay_goods = pay_goodsMapper.queryPay_goodsByOid(oid);
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success(pay_goods);
    }

    public Result<String> addPay_goods(int uid, int oid, int state,int gcount){
        try{
            int id = pay_goodsMapper.selectIdMaxPay_goods() + 1;
            pay_goodsMapper.addPay_goods(new Pay_goods(id,uid,oid,state,gcount));
        }catch (Exception e){
            return Result.error(new CodeMsg(0,e.toString()));
        }
        return Result.success("success Register");
    }

    public Result<String> updatePay_goods(int pid, int uid, int oid, int state,int gcount) {
        Pay_goods pay_goods = null;
        try {
            pay_goods = pay_goodsMapper.queryPay_goodsByPid(pid);
            pay_goodsMapper.updatePay_goods(new Pay_goods(pid,uid,oid,state,gcount));
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success("success updatePay_goods");
    }

    public Result<String> deletePay_goods(int pid) {
        try {
            pay_goodsMapper.deletePay_goods(pid);
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success("success deletepay_goods");
    }
}
