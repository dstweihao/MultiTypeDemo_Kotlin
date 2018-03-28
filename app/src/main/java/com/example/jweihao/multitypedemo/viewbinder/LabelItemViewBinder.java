package com.example.jweihao.multitypedemo.viewbinder;
/*
 * 创建者 韦豪
 * 创建时间 2018/3/27 0027 22:23
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jweihao.multitypedemo.R;
import com.example.jweihao.multitypedemo.bean.Label;

import org.w3c.dom.Text;

import me.drakeet.multitype.ItemViewBinder;

public class LabelItemViewBinder extends ItemViewBinder<Label, LabelItemViewBinder.ViewHolder> {

    private Context mContext;

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_label, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull final Label item) {
        holder.mTv_label.setText(item.getLabel());
        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, item.getLabel(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTv_label;
        private final View mItemView;

        public ViewHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
            mContext = itemView.getContext();
            mTv_label = itemView.findViewById(R.id.item_tv_label);
        }
    }
}
