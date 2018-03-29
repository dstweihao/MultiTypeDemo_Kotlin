package com.example.jweihao.multitypedemo.viewbinder

/*
 * 创建者 韦豪
 * 创建时间 2018/3/27 0027 22:23
 */

import android.content.Context
import android.support.v7.view.menu.MenuView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

import com.example.jweihao.multitypedemo.R
import com.example.jweihao.multitypedemo.bean.Label

import org.w3c.dom.Text

import me.drakeet.multitype.ItemViewBinder

class LabelItemViewBinder : ItemViewBinder<Label, LabelItemViewBinder.ViewHolder>() {

    private var mContext: Context? = null

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        val view = inflater.inflate(R.layout.item_label, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, item: Label) {
        holder.mTv_label.text = item.label
        holder.mItemView.setOnClickListener { Toast.makeText(mContext, item.label, Toast.LENGTH_SHORT).show() }
    }

    inner class ViewHolder(val mItemView: View) : RecyclerView.ViewHolder(mItemView) {

        val mTv_label: TextView

        init {
            mContext = mItemView.context
            mTv_label = mItemView.findViewById(R.id.item_tv_label)
        }
    }
}
