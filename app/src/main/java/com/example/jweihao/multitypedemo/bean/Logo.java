package com.example.jweihao.multitypedemo.bean;

/**
 * Created by weihao on 2018/3/28.
 */
public class Logo {
    private int logoImage;
    private String logoName;
    private String logoGrade;

    public Logo(int logoImage, String logoName, String logoGrade) {
        this.logoImage = logoImage;
        this.logoName = logoName;
        this.logoGrade = logoGrade;
    }

    public int getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(int logoImage) {
        this.logoImage = logoImage;
    }

    public String getLogoName() {
        return logoName;
    }

    public void setLogoName(String logoName) {
        this.logoName = logoName;
    }

    public String getLogoGrade() {
        return logoGrade;
    }

    public void setLogoGrade(String logoGrade) {
        this.logoGrade = logoGrade;
    }
}
