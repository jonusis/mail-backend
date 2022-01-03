package com.example.mail.Mapper;

import com.example.mail.Pojo.Goods;

import java.util.List;

public interface GoodsMapper {

    List<Goods> queryGoodsList();

    Goods queryGoodsByGid(int gid);

    List<Goods> queryGoodsByBid(int bid);

    List<Goods> queryGoodsByType(String type);

    void addGoods(Goods goods);

    void updateGoods(Goods goods);

    void deleteGoods(int gid);

    int selectIdMaxGoods();
}
