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
import com.example.jweihao.multitypedemo.bean.Bank

import me.drakeet.multitype.ItemViewBinder

/**
 * Created by weihao on 2018/3/28.
 */
class BankItemViewBinder : ItemViewBinder<Bank, BankItemViewBinder.ViewHolder>() {

    private var mContext: Context? = null

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        val view = inflater.inflate(R.layout.item_bank, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, item: Bank) {
        holder.mImage.setImageResource(item.bankImage)
        holder.mName.text = item.bankName
        holder.mGrade.text = item.bankGrade
        holder.mItemView.setOnClickListener { Toast.makeText(mContext, item.bankName, Toast.LENGTH_SHORT).show() }
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
