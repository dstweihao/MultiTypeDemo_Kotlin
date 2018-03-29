package com.example.jweihao.multitypedemo.viewbinder

/*
 * 创建者 韦豪
 * 创建时间 2018/3/27 0027 23:31
 */

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SnapHelper
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.jweihao.multitypedemo.R
import com.example.jweihao.multitypedemo.bean.Bank
import com.example.jweihao.multitypedemo.bean.BankList
import com.example.jweihao.multitypedemo.bean.Logo
import com.example.jweihao.multitypedemo.bean.LogoList
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper

import me.drakeet.multitype.ItemViewBinder
import me.drakeet.multitype.MultiTypeAdapter

class BankListItemViewBinder : ItemViewBinder<BankList, BankListItemViewBinder.ViewHolder>() {

    private var mMultiTypeAdapter: MultiTypeAdapter? = null

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): BankListItemViewBinder.ViewHolder {
        val view = inflater.inflate(R.layout.item_recyclerview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: BankListItemViewBinder.ViewHolder, item: BankList) {
        holder.setItemList(item.bankList)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            val recyclerview = itemView.findViewById<RecyclerView>(R.id.item_recyclerview)


            val layoutManager = GridLayoutManager(itemView.context, 2)
            recyclerview.layoutManager = layoutManager
            mMultiTypeAdapter = MultiTypeAdapter()
            mMultiTypeAdapter!!.register(Bank::class.java, BankItemViewBinder())
            recyclerview.adapter = mMultiTypeAdapter


        }

        fun setItemList(bankList: List<Bank>?) {
            mMultiTypeAdapter!!.items = bankList!!
            mMultiTypeAdapter!!.notifyDataSetChanged()
        }
    }
}
