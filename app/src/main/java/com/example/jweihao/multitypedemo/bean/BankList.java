package com.example.jweihao.multitypedemo.bean;

import java.util.List;

/**
 * Created by weihao on 2018/3/28.
 */
public class BankList {
    private List<Bank> mBankList;

    public BankList(List<Bank> bankList) {
        mBankList = bankList;
    }

    public List<Bank> getBankList() {
        return mBankList;
    }

    public void setBankList(List<Bank> bankList) {
        mBankList = bankList;
    }


}
