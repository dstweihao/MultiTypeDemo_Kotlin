package com.example.jweihao.multitypedemo.viewbinder

/*
 * 创建者 韦豪
 * 创建时间 2018/3/27 0027 23:31
 */

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.jweihao.multitypedemo.R
import com.example.jweihao.multitypedemo.bean.App
import com.example.jweihao.multitypedemo.bean.AppList
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper

import me.drakeet.multitype.ItemViewBinder
import me.drakeet.multitype.MultiTypeAdapter


class AppListItemViewBinder : ItemViewBinder<AppList, AppListItemViewBinder.ViewHolder>() {

    private var mMultiTypeAdapter: MultiTypeAdapter? = null

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): AppListItemViewBinder.ViewHolder {
        val view = inflater.inflate(R.layout.item_recyclerview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AppListItemViewBinder.ViewHolder, item: AppList) {
        holder.setItemList(item.appLists)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            val recyclerview = itemView.findViewById<RecyclerView>(R.id.item_recyclerview)

            //            SnapHelper snapHelper = new LinearSnapHelper();
            //            snapHelper.attachToRecyclerView(recyclerview);
            //回收效果设置
            recyclerview.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            val snapHelperStart = GravitySnapHelper(Gravity.START)
            snapHelperStart.attachToRecyclerView(recyclerview)

            mMultiTypeAdapter = MultiTypeAdapter()
            mMultiTypeAdapter!!.register(App::class.java, AppItemViewBinder())
            recyclerview.adapter = mMultiTypeAdapter

        }

        fun setItemList(appLists: List<App>?) {
            mMultiTypeAdapter!!.items = appLists!!
            mMultiTypeAdapter!!.notifyDataSetChanged()
        }
    }
}
