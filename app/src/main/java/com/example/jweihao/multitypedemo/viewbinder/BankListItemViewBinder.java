package com.example.jweihao.multitypedemo.viewbinder;
/*
 * 创建者 韦豪
 * 创建时间 2018/3/27 0027 23:31
 */

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jweihao.multitypedemo.R;
import com.example.jweihao.multitypedemo.bean.Bank;
import com.example.jweihao.multitypedemo.bean.BankList;
import com.example.jweihao.multitypedemo.bean.Logo;
import com.example.jweihao.multitypedemo.bean.LogoList;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import java.util.List;

import me.drakeet.multitype.ItemViewBinder;
import me.drakeet.multitype.MultiTypeAdapter;

public class BankListItemViewBinder extends ItemViewBinder<BankList, BankListItemViewBinder.ViewHolder> {

    private MultiTypeAdapter mMultiTypeAdapter;

    @NonNull
    @Override
    protected BankListItemViewBinder.ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull BankListItemViewBinder.ViewHolder holder, @NonNull BankList item) {
        holder.setItemList(item.getBankList());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
            RecyclerView recyclerview = itemView.findViewById(R.id.item_recyclerview);


            GridLayoutManager layoutManager = new GridLayoutManager(itemView.getContext(), 2);
            recyclerview.setLayoutManager(layoutManager);
            mMultiTypeAdapter = new MultiTypeAdapter();
            mMultiTypeAdapter.register(Bank.class, new BankItemViewBinder());
            recyclerview.setAdapter(mMultiTypeAdapter);


        }

        public void setItemList(List<Bank> bankList) {
            mMultiTypeAdapter.setItems(bankList);
            mMultiTypeAdapter.notifyDataSetChanged();
        }
    }
}
