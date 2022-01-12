package com.example.mail.Pojo;

import java.util.Date;

public class Ordercar {
    private int id;
    private Date datetime;
    private String time;
    private String tel;
    private String qq;
    private String wechat;
    private int numNeed;
    private int numExist;
    private String heading;
    private String content;
    private String postID;
    private int full;
    private String placeA;
    private String placeB;

    public Ordercar() {
    }

    public Ordercar(int id, String time, String tel, String qq, String wechat, int numNeed, int numExist, String heading, String content, String postID, int full, String placeA, String placeB) {
        this.id = id;
        this.datetime = new Date();
        this.time = time;
        this.tel = tel;
        this.qq = qq;
        this.wechat = wechat;
        this.numNeed = numNeed;
        this.numExist = numExist;
        this.heading = heading;
        this.content = content;
        this.postID = postID;
        this.full = full;
        this.placeA = placeA;
        this.placeB = placeB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public int getNumNeed() {
        return numNeed;
    }

    public void setNumNeed(int numNeed) {
        this.numNeed = numNeed;
    }

    public int getNumExist() {
        return numExist;
    }

    public void setNumExist(int numExist) {
        this.numExist = numExist;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public int getFull() {
        return full;
    }

    public void setFull(int full) {
        this.full = full;
    }

    public String getPlaceA() {
        return placeA;
    }

    public void setPlaceA(String placeA) {
        this.placeA = placeA;
    }

    public String getPlaceB() {
        return placeB;
    }

    public void setPlaceB(String placeB) {
        this.placeB = placeB;
    }
}
