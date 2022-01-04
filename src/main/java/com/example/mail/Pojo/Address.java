package com.example.mail.Pojo;

public class Address {
    private int aid;
    private int uid;
    private String province;
    private String city;
    private String detailedAddress;
    private String telephone;
    private String receivierName;

    public Address(int aid, int uid, String province, String city, String detailedAddress, String telephone, String receivierName) {
        this.aid = aid;
        this.uid = uid;
        this.province = province;
        this.city = city;
        this.detailedAddress = detailedAddress;
        this.telephone = telephone;
        this.receivierName = receivierName;
    }

    public Address() {
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getReceivierName() {
        return receivierName;
    }

    public void setReceivierName(String receivierName) {
        this.receivierName = receivierName;
    }
}
