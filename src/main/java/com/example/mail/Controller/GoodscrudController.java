package com.example.mail.Controller;

import com.example.mail.Pojo.Category;
import com.example.mail.Pojo.Goods;
import com.example.mail.ResultSet.PagehelpResult;
import com.example.mail.ResultSet.Result;
import com.example.mail.Service.CategorycrudService;
import com.example.mail.Service.GoodscrudService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "goods增删查改")
@RequestMapping(value = "/v1/goods")
@CrossOrigin(origins = "*")
public class GoodscrudController {
    @Autowired
    private GoodscrudService GoodscrudService;
    @Autowired
    private CategorycrudService categorycrudService;

    @RequestMapping(value = "/searchGoods", method = RequestMethod.GET)
    public PagehelpResult<List<Goods>> searchGoods(@RequestParam(defaultValue = "0")String gid,@RequestParam(defaultValue = "0")String bid, @RequestParam(defaultValue = "0") String type,@RequestParam(defaultValue = "1",required = false) String pageNum, @RequestParam(defaultValue = "8",required = false) String pageSize){
        int pagenum = Integer.parseInt(pageNum);
        int pagesize = Integer.parseInt(pageSize);
        int gidInt = Integer.parseInt(gid);
        int bidInt = Integer.parseInt(bid);
        PageHelper.startPage(pagenum,pagesize);
        List<Goods> goodsList = GoodscrudService.searchGoods(gidInt,bidInt,type);
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsList);
        int pageNumber = pageInfo.getPageNum();
        int PageSize = pageInfo.getPages();
        return PagehelpResult.success(goodsList,pageNumber,PageSize);
    }

    @RequestMapping(value = "/queryCategory", method = RequestMethod.GET)
    public PagehelpResult<List<Category>> queryCategory(@RequestParam(defaultValue = "0")String category, @RequestParam(defaultValue = "0") String type,@RequestParam(defaultValue = "1",required = false) String pageNum, @RequestParam(defaultValue = "8",required = false) String pageSize){
        int pagenum = Integer.parseInt(pageNum);
        int pagesize = Integer.parseInt(pageSize);
        PageHelper.startPage(pagenum,pagesize);
        List<Category> categoryList = categorycrudService.queryCategory(category,type);
        PageInfo<Category> pageInfo = new PageInfo<>(categoryList);
        int pageNumber = pageInfo.getPageNum();
        int PageSize = pageInfo.getPages();
        return PagehelpResult.success(categoryList,pageNumber,PageSize);
    }

    @RequestMapping(value = "/queryGoodsByGid", method = RequestMethod.GET)
    public Result<Goods> queryGoodsByGid(@RequestParam String gid){
        int id = Integer.parseInt(gid);
        return Result.success(GoodscrudService.queryGoodsByGid(id));
    }

    @RequestMapping(value = "/queryGoodsList", method = RequestMethod.GET)
    public PagehelpResult<List<Goods>> queryGoodsList(@RequestParam(defaultValue = "1",required = false) String pageNum, @RequestParam(defaultValue = "8",required = false) String pageSize){
        int pagenum = Integer.parseInt(pageNum);
        int pagesize = Integer.parseInt(pageSize);
        return GoodscrudService.queryGoodsList(pagenum,pagesize);
    }

    @RequestMapping(value = "/queryGoodsByBid", method = RequestMethod.GET)
    public PagehelpResult<List<Goods>> queryGoodsByBid(@RequestParam(required = false,defaultValue = "0") String bid, @RequestParam(defaultValue = "1",required = false) String pageNum, @RequestParam(defaultValue = "8",required = false) String pageSize){
        int pagenum = Integer.parseInt(pageNum);
        int pagesize = Integer.parseInt(pageSize);

        int id = bid != null? Integer.parseInt(bid):null;
        return GoodscrudService.queryGoodsByBid(id,pagenum,pagesize);
    }

    @RequestMapping(value = "/queryGoodsByType", method = RequestMethod.GET)
    public PagehelpResult<List<Goods>> queryGoodsByType(@RequestParam String type, @RequestParam(defaultValue = "1") String pageNum, @RequestParam(defaultValue = "5") String pageSize){
        int pagenum = Integer.parseInt(pageNum);
        int pagesize = Integer.parseInt(pageSize);
        return GoodscrudService.queryGoodsByType(type,pagenum,pagesize);
    }

    @RequestMapping(value = "/addGoods", method = RequestMethod.POST)
    public Result<String> addGoods(@RequestBody Goods goods){
        int bid = goods.getBid();
        String name = goods.getName();
        String type = goods.getType();
        int price = goods.getPrice();
        int count = goods.getCount();
        String introduction = goods.getIntroduction();
        return GoodscrudService.addGoods(bid,name,type,price,count,introduction);
    }

    
    @RequestMapping(value = "/updateGoods", method = RequestMethod.PUT)
    public Result<String> updateGoods(@RequestBody Goods goods){
        int gid = goods.getGid();
        int bid = goods.getBid();
        String name = goods.getName();
        String type = goods.getType();
        int price = goods.getPrice();
        int count = goods.getCount();
        String introduction = goods.getIntroduction();
        return GoodscrudService.updateGoods(gid,bid,name,type,price,count,introduction);
    }

    
    @RequestMapping(value = "/deleteGoods", method = RequestMethod.DELETE)
    public Result<String> deleteGoods(@RequestParam String gid){
        int id = Integer.parseInt(gid);
        return GoodscrudService.deleteGoods(id);
    }
}
