package com.example.jweihao.multitypedemo.viewbinder

/*
 * 创建者 韦豪
 * 创建时间 2018/3/27 0027 22:18
 */

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.jweihao.multitypedemo.R
import com.example.jweihao.multitypedemo.bean.Label
import com.example.jweihao.multitypedemo.bean.LabelList

import me.drakeet.multitype.ItemViewBinder
import me.drakeet.multitype.MultiTypeAdapter

class LabelListItemViewBinder : ItemViewBinder<LabelList, LabelListItemViewBinder.ViewHolder>() {

    private var mMultiTypeAdapter: MultiTypeAdapter? = null

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): LabelListItemViewBinder.ViewHolder {
        val view = inflater.inflate(R.layout.item_recyclerview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: LabelListItemViewBinder.ViewHolder, item: LabelList) {
        holder.setItemList(item.labelLists)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            val itemRecyclerView = itemView.findViewById<RecyclerView>(R.id.item_recyclerview)
            val layoutManager = LinearLayoutManager(itemView.context)
            layoutManager.orientation = LinearLayoutManager.HORIZONTAL
            itemRecyclerView.layoutManager = layoutManager

            mMultiTypeAdapter = MultiTypeAdapter()
            mMultiTypeAdapter!!.register(Label::class.java, LabelItemViewBinder())
            itemRecyclerView.adapter = mMultiTypeAdapter
        }

        fun setItemList(labelLists: List<Label>?) {
            mMultiTypeAdapter!!.items = labelLists!!
            mMultiTypeAdapter!!.notifyDataSetChanged()
        }
    }
}
