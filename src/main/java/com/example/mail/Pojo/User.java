package com.example.mail.Pojo;

public class User {
    private String name;
    private int uid;
    private String account;
    private String password;
    private int age;
    private int sex; // 0为男 1为女

    public User(int uid,String name, String account, String password, int age, int sex) {
        this.uid = uid;
        this.name = name;
        this.account = account;
        this.password = password;
        this.age = age;
        this.sex = sex;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
