package com.example.jweihao.multitypedemo.viewbinder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jweihao.multitypedemo.R;
import com.example.jweihao.multitypedemo.bean.Bank;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by weihao on 2018/3/28.
 */
public class BankItemViewBinder extends ItemViewBinder<Bank, BankItemViewBinder.ViewHolder> {

    private Context mContext;

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_bank, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull final Bank item) {
        holder.mImage.setImageResource(item.getBankImage());
        holder.mName.setText(item.getBankName());
        holder.mGrade.setText(item.getBankGrade());
        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext, item.getBankName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mImage;
        private final TextView mName;
        private final TextView mGrade;
        private final View mItemView;

        public ViewHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
            mContext = itemView.getContext();
            mImage = itemView.findViewById(R.id.imageView);
            mName = itemView.findViewById(R.id.nameTextView);
            mGrade = itemView.findViewById(R.id.ratingTextView);
        }
    }
}
