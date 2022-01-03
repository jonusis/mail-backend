package com.example.mail.Service;

import com.example.mail.Mapper.GoodsMapper;
import com.example.mail.Pojo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    public Result<List<Goods>> queryGoodsByBid(int bid) {
        List<Goods> goods = null;
        try {
            goods = goodsMapper.queryGoodsByBid(bid);
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success(goods);
    }

    public Result<List<Goods>> queryGoodsByType(String type) {
        List<Goods> goods = null;
        try {
            goods = goodsMapper.queryGoodsByType(type);
        } catch (Exception e) {
            return Result.error(new CodeMsg(0, e.toString()));
        }
        return Result.success(goods);
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
}
