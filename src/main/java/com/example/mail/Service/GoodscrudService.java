package com.example.mail.Service;

import com.example.mail.ResultSet.CodeMsg;
import com.example.mail.ResultSet.PagehelpResult;
import com.example.mail.ResultSet.Result;
import com.example.mail.Mapper.GoodsMapper;
import com.example.mail.Pojo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodscrudService {

    @Autowired
    GoodsMapper goodsMapper;

    public PagehelpResult<List<Goods>> queryGoodsList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Goods> goods = goodsMapper.queryGoodsList();
        PageInfo<Goods> pageInfo = new PageInfo<>(goods);
        List<Goods> list = pageInfo.getList();
        int pageNumber = pageInfo.getPageNum();
        int PageSize = pageInfo.getPages();
        return PagehelpResult.success(list,pageNumber,PageSize);
    }

    public Result<Goods> queryGoodsByGid(int gid) {
        Goods goods = null;
        try {
            goods = goodsMapper.queryGoodsByGid(gid);
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success(goods);
    }

    public PagehelpResult<List<Goods>> queryGoodsByBid(int bid, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Goods> goods = goodsMapper.queryGoodsByBid(bid);
        PageInfo<Goods> pageInfo = new PageInfo<>(goods);
        List<Goods> list = pageInfo.getList();
        int pageNumber = pageInfo.getPageNum();
        int PageSize = pageInfo.getPages();
        return PagehelpResult.success(list,pageNumber,PageSize);
    }

    public PagehelpResult<List<Goods>> queryGoodsByType(String type, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Goods> goods = goodsMapper.queryGoodsByType(type);
        PageInfo<Goods> pageInfo = new PageInfo<>(goods);
        List<Goods> list = pageInfo.getList();
        int pageNumber = pageInfo.getPageNum();
        int PageSize = pageInfo.getPages();
        return PagehelpResult.success(list,pageNumber,PageSize);
    }

    public Result<String> addGoods(int bid, String name, String type, int price, int count, String introduction){
        try{
            int id = goodsMapper.selectIdMaxGoods() + 1;
            goodsMapper.addGoods(new Goods(id,bid,name,type,price,count,introduction));
        }catch (Exception e){
            return Result.error(new CodeMsg(0,e.toString()));
        }
        return Result.success("success addGoods");
    }

    public Result<String> updateGoods(int gid, int bid, String name, String type, int price, int count, String introduction) {
        try {
            goodsMapper.updateGoods(new Goods(gid,bid,name,type,price,count,introduction));
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success("success updateGoods");
    }

    public Result<String> deleteGoods(int gid) {
        try {
            goodsMapper.deleteGoods(gid);
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success("success deleteGoods");
    }
}
