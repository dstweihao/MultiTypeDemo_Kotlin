package com.example.jweihao.multitypedemo.viewbinder

/*
 * 创建者 韦豪
 * 创建时间 2018/3/27 0027 23:34
 */

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import com.example.jweihao.multitypedemo.R
import com.example.jweihao.multitypedemo.bean.App

import me.drakeet.multitype.ItemViewBinder

class AppItemViewBinder : ItemViewBinder<App, AppItemViewBinder.ViewHolder>() {

    private var mContext: Context? = null

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        val view = inflater.inflate(R.layout.item_app, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, item: App) {
        holder.mImage.setImageResource(item.appImage)
        holder.mName.text = item.appName
        holder.mGrade.text = item.appGrade
        holder.mItemView.setOnClickListener { Toast.makeText(mContext, item.appName, Toast.LENGTH_SHORT).show() }

    }

    inner class ViewHolder(val mItemView: View) : RecyclerView.ViewHolder(mItemView) {

        val mImage: ImageView
        val mName: TextView
        val mGrade: TextView

        init {
            mContext = mItemView.context
            mImage = mItemView.findViewById(R.id.imageView)
            mName = mItemView.findViewById(R.id.nameTextView)
            mGrade = mItemView.findViewById(R.id.ratingTextView)

        }
    }
}
