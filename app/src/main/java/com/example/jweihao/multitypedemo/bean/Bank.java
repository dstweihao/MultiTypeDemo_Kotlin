package com.example.jweihao.multitypedemo.bean;

/**
 * Created by weihao on 2018/3/28.
 */
public class Bank {
    private int bankImage;
    private String bankName;
    private String bankGrade;

    public Bank(int bankImage, String bankName, String bankGrade) {
        this.bankImage = bankImage;
        this.bankName = bankName;
        this.bankGrade = bankGrade;
    }

    public int getBankImage() {
        return bankImage;
    }

    public void setBankImage(int bankImage) {
        this.bankImage = bankImage;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankGrade() {
        return bankGrade;
    }

    public void setBankGrade(String bankGrade) {
        this.bankGrade = bankGrade;
    }
}
