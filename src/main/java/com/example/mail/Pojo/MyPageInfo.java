package com.example.mail.Pojo;

public class MyPageInfo {
    private int pageNum;
    private int allPageNum;

    public int getPageNum() {
        return pageNum;
    }

    public int getAllPageNum() {
        return allPageNum;
    }

    public MyPageInfo(int pageNum, int allPageNum) {
        this.pageNum = pageNum;
        this.allPageNum = allPageNum;
    }

}
