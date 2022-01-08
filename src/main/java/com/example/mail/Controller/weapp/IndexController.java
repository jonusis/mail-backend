package com.example.mail.Controller.weapp;
import com.example.mail.Pojo.Category;
import com.example.mail.Pojo.Goods;
import com.example.mail.Pojo.RecommendGood;
import com.example.mail.ResultSet.Result;
import io.swagger.annotations.Api;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "小程序首页api")
@RequestMapping(value = "/v1/wx/index")
@CrossOrigin(origins = "*")
public class IndexController {

    @Autowired
    private com.example.mail.Service.CategorycrudService categorycrudService;

    @Autowired
    private com.example.mail.Service.GoodscrudService goodscrudService;

    @RequestMapping(value = "/getCategoryList", method = RequestMethod.GET)
    Result<List<String>> GetCategoryList(){
        List<Category> list = categorycrudService.queryCategory("0","0");
        HashSet<String> set = new HashSet<>();
        for(Category category : list){
            set.add(category.getCategory());
        }
        return Result.success(new ArrayList<String>(set));
    }

    @RequestMapping(value = "/getRecommendList", method = RequestMethod.GET)
    Result<List<RecommendGood>> GetRecommendList(){
        List<Goods> list = goodscrudService.queryGoodsList();
        List<RecommendGood> res = new ArrayList<>();
        if(list.size() <=6){
            for(Goods good : list){
                res.add(new RecommendGood(good));
            }
            return Result.success(res);
        }else{
            while(res.size() <= 6){
                int number = (int) (list.size() * Math.random());
                HashSet<Integer> set = new HashSet<>();
                while(!set.contains(number) && number < list.size() && res.size() <= 6){
                    set.add(number);
                    res.add(new RecommendGood(list.get(number)));
                    number++;
                }
            }
            return Result.success(res);
        }
    }

    @RequestMapping(value = "/getTypeList", method = RequestMethod.GET)
    Result<List<String>> GetTypeList(@RequestParam String Catory){
        List<Category> list = categorycrudService.queryCategory(Catory,"0");
        ArrayList<String> res = new ArrayList<>();
        for(Category category : list){
            res.add(category.getType());
        }
        return Result.success(res);
    }

    @RequestMapping(value = "/getGoodsByTypename", method = RequestMethod.GET)
    Result<List<RecommendGood>> GetGoodsByTypename(@RequestParam String type){
        List<Goods> list = goodscrudService.searchGoods(0,0,type);
        List<RecommendGood> res = new ArrayList<RecommendGood>();
        for(Goods goods : list){
            res.add(new RecommendGood(goods));
        }
        return Result.success(res);
        // {gid,name,price}
    }

    @RequestMapping(value = "/getGoodsByGid", method = RequestMethod.GET)
    Result<List<Goods>> GetGoodsByGid(@RequestParam String id){
        List<Goods> list = goodscrudService.searchGoods(Integer.parseInt(id),0,"0");
        return Result.success(list);
        // class goods
    }
}
