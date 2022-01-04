package com.example.mail.Service;

import com.example.mail.Mapper.OrderMapper;
import com.example.mail.Pojo.CodeMsg;
import com.example.mail.Pojo.Order;
import com.example.mail.Pojo.PagehelpResult;
import com.example.mail.Pojo.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdercrudService {
    @Autowired
    OrderMapper orderMapper;

    public PagehelpResult<List<Order>> queryOrderList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Order> order = orderMapper.queryOrderList();
        PageInfo<Order> pageInfo = new PageInfo<>(order);
        List<Order> list = pageInfo.getList();
        int pageNumber = pageInfo.getPageNum();
        int PageSize = pageInfo.getPages();
        return PagehelpResult.success(list,pageNumber,PageSize);
    }

    public Result<Order> queryOrderByOid(int oid) {
        Order order = null;
        try {
            order = orderMapper.queryOrderByOid(oid);
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success(order);
    }

    public PagehelpResult<List<Order>> queryOrderByBid(int bid, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Order> order = orderMapper.queryOrderByBid(bid);
        PageInfo<Order> pageInfo = new PageInfo<>(order);
        List<Order> list = pageInfo.getList();
        int pageNumber = pageInfo.getPageNum();
        int PageSize = pageInfo.getPages();
        return PagehelpResult.success(list,pageNumber,PageSize);
    }

    public PagehelpResult<List<Order>> queryOrderByGid(int gid, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Order> order = orderMapper.queryOrderByGid(gid);
        PageInfo<Order> pageInfo = new PageInfo<>(order);
        List<Order> list = pageInfo.getList();
        int pageNumber = pageInfo.getPageNum();
        int PageSize = pageInfo.getPages();
        return PagehelpResult.success(list,pageNumber,PageSize);
    }

    public Result<String> addOrder(int state, String start_time, String end_time, int total_price, String introduction, int bid, int gid){
        try{
            int id = orderMapper.selectIdMaxOrder() + 1;
            orderMapper.addOrder(new Order(id,state,start_time,end_time,total_price,introduction,bid,gid));
        }catch (Exception e){
            return Result.error(new CodeMsg(0,e.toString()));
        }
        return Result.success("success addOrder");
    }

    public Result<String> updateOrder(int oid, int state, String start_time, String end_time, int total_price, String introduction, int bid, int gid) {
        try {
            orderMapper.updateOrder(new Order(oid,state,start_time,end_time,total_price,introduction,bid,gid));
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success("success updateOrder");
    }

    public Result<String> deleteOrder(int oid) {
        try {
            orderMapper.deleteOrder(oid);
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success("success deleteOrder");
    }
}
