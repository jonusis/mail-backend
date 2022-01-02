package com.example.mail.Pojo;

public class Business {
    private int bid;
    private String name;
    private String account;
    private String password;
    private String introduction;

    public Business(int bid, String name, String account, String password, String introduction) {
        this.bid = bid;
        this.name = name;
        this.account = account;
        this.password = password;
        this.introduction = introduction;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

}
