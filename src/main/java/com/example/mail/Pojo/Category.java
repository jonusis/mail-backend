package com.example.mail.Pojo;

public class Category {
    private int cid;
    private String category;
    private String type;

    public Category(int cid, String category, String type) {
        this.cid = cid;
        this.category = category;
        this.type = type;
    }

    public Category() {
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
