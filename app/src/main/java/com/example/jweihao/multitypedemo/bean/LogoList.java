package com.example.jweihao.multitypedemo.bean;

import java.util.List;

/**
 * Created by weihao on 2018/3/28.
 */
public class LogoList {
    private List<Logo> mLogoList;

    public LogoList(List<Logo> logoList) {
        mLogoList = logoList;
    }

    public List<Logo> getLogoList() {
        return mLogoList;
    }

    public void setLogoList(List<Logo> logoList) {
        mLogoList = logoList;
    }
}
