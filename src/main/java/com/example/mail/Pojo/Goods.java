package com.example.mail.Pojo;

public class Goods {
    private int gid;
    private int bid;
    private String name;
    private String type;
    private int price;
    private int count;
    private String introduction;

    public Goods(int gid, int bid, String name, String type, int price, int count, String introduction) {
        this.gid = gid;
        this.bid = bid;
        this.name = name;
        this.type = type;
        this.price = price;
        this.count = count;
        this.introduction = introduction;
    }

    public Goods() {
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

}
