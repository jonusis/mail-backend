package com.example.mail.Pojo;

public class RecommendGood {
    private int gid;
    private String name;
    private int price;

    public RecommendGood() {
    }

    public RecommendGood(Goods goods) {
        this.gid = goods.getGid();
        this.name = goods.getName();
        this.price = goods.getPrice();
    }

    public RecommendGood(int gid, String name, int price) {
        this.gid = gid;
        this.name = name;
        this.price = price;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getGid() {
        return gid;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
