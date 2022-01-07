package com.example.mail.Mapper;

import com.example.mail.Pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodsMapper {
    List<Goods> searchGoods(int gid,int bid,String type);

    List<Goods> queryGoodsList();

    Goods queryGoodsByGid(int gid);

    List<Goods> queryGoodsByBid(int bid);

    List<Goods> queryGoodsByType(String type);

    void addGoods(Goods goods);

    void updateGoods(Goods goods);

    void deleteGoods(int gid);

    int selectIdMaxGoods();
}
