package com.example.mail.Service;

import com.example.mail.Mapper.DeliveryMapper;
import com.example.mail.Pojo.Delivery;
import com.example.mail.Pojo.CodeMsg;
import com.example.mail.Pojo.PagehelpResult;
import com.example.mail.Pojo.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliverycrudService {
    @Autowired
    DeliveryMapper deliveryMapper;

    public PagehelpResult<List<Delivery>> queryDeliveryList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Delivery> users = deliveryMapper.queryDeliveryList();
        PageInfo<Delivery> pageInfo = new PageInfo<>(users);
        List<Delivery> list = pageInfo.getList();
        int pageNumber = pageInfo.getPageNum();
        int PageSize = pageInfo.getPages();
        return PagehelpResult.success(list,pageNumber,PageSize);
    }

    public Result<Delivery> queryDeliveryByDid(int did) {
        Delivery buiness = null;
        try {
            buiness = deliveryMapper.queryDeliveryByDid(did);
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success(buiness);
    }

    public Result<Delivery> queryDeliveryByUid(int uid) {
        Delivery buiness = null;
        try {
            buiness = deliveryMapper.queryDeliveryByUid(uid);
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success(buiness);
    }

    public Result<Delivery> queryDeliveryByOid(int oid) {
        Delivery buiness = null;
        try {
            buiness = deliveryMapper.queryDeliveryByOid(oid);
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success(buiness);
    }

    public Result<String> addDelivery(int uid, int oid, int state){
        try{
            int id = deliveryMapper.selectIdMaxDelivery() + 1;
            deliveryMapper.addDelivery(new Delivery(id,uid,oid,state));
        }catch (Exception e){
            return Result.error(new CodeMsg(0,e.toString()));
        }
        return Result.success("success Register");
    }

    public Result<String> updateDelivery(int did, int uid, int oid, int state) {
        Delivery delivery = null;
        try {
            delivery = deliveryMapper.queryDeliveryByUid(uid);
            deliveryMapper.updateDelivery(new Delivery(did,uid,oid,state));
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success("success updateDelivery");
    }

    public Result<String> deleteDelivery(int did) {
        try {
            deliveryMapper.deleteDelivery(did);
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success("success deleteUser");
    }


}
