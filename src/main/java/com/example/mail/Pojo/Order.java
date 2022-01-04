package com.example.mail.Pojo;

public class Order {
    private int oid;
    private int state;
    private String start_time;
    private String end_time;
    private int total_price;
    private String introduction;
    private int bid;
    private int gid;

    public Order(int oid, int state, String start_time, String end_time, int total_price, String introduction, int bid, int gid) {
        this.oid = oid;
        this.state = state;
        this.start_time = start_time;
        this.end_time = end_time;
        this.total_price = total_price;
        this.introduction = introduction;
        this.bid = bid;
        this.gid = gid;
    }

    public Order() {
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }
}
