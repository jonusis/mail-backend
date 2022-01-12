package com.example.mail.Pojo;

public class User {
    private int uid;
    private String name;
    private String account;
    private String password;
    private int age;
    private int sex; // 0为男 1为女
    private String stNum;
    private String headPicture;
    private String tel;
    private String qq;
    private String wechat;

    public User(int uid, String name, String account, String password, int age, int sex, String stNum, String headPicture, String tel, String qq, String wechat) {
        this.uid = uid;
        this.name = name;
        this.account = account;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.stNum = stNum;
        this.headPicture = headPicture;
        this.tel = tel;
        this.qq = qq;
        this.wechat = wechat;
    }

    public String getStNum() {
        return stNum;
    }

    public void setStNum(String stNum) {
        this.stNum = stNum;
    }

    public String getHeadPicture() {
        return headPicture;
    }

    public void setHeadPicture(String headPicture) {
        this.headPicture = headPicture;
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

    public String getName() {
        return name;
    }

    public int getUid() {
        return uid;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public int getSex() {
        return sex;
    }

    public User() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
