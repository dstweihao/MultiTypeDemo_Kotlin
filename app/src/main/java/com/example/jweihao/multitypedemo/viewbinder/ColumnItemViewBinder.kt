package com.example.jweihao.multitypedemo.viewbinder

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import com.example.jweihao.multitypedemo.R
import com.example.jweihao.multitypedemo.bean.Column

import me.drakeet.multitype.ItemViewBinder

/**
 * Created by weihao on 2018/3/27.
 */

class ColumnItemViewBinder : ItemViewBinder<Column, ColumnItemViewBinder.ViewHolder>() {

    private var mContext: Context? = null

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        val view = inflater.inflate(R.layout.item_column, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, column: Column) {
        holder.mColumn_red.setImageResource(column.colimnImage)
        holder.mColumn_name.text = column.columnName
        holder.mColumn_more.text = column.moreName
        holder.mColumn_right.setImageResource(column.rightImage)
        holder.mItemView.setOnClickListener { Toast.makeText(mContext, column.columnName, Toast.LENGTH_SHORT).show() }

    }

    inner class ViewHolder(val mItemView: View) : RecyclerView.ViewHolder(mItemView) {
        val mColumn_red: ImageView
        val mColumn_name: TextView
        val mColumn_more: TextView
        val mColumn_right: ImageView

        init {
            mContext = mItemView.context
            mColumn_red = mItemView.findViewById(R.id.column_iv_red)
            mColumn_name = mItemView.findViewById(R.id.column_tv_name)
            mColumn_more = mItemView.findViewById(R.id.column_tv_more)
            mColumn_right = mItemView.findViewById(R.id.column_iv_right)
        }
    }
}
