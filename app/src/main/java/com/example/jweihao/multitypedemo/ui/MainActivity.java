package com.example.jweihao.multitypedemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jweihao.multitypedemo.R;
import com.example.jweihao.multitypedemo.bean.Column;
import com.example.jweihao.multitypedemo.viewbinder.ColumnItemViewBinder;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class MainActivity extends AppCompatActivity {

    private MultiTypeAdapter mMultiTypeAdapter;
    private Items mItems = new Items();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        mMultiTypeAdapter = new MultiTypeAdapter();
        //注册类型和View的对应关系
        mMultiTypeAdapter.register(Column.class, new ColumnItemViewBinder());
        recyclerView.setAdapter(mMultiTypeAdapter);

        //初始化数据
        //添加栏目
        mItems.add(new Column(
                R.drawable.shape_red_rectangles,
                "电影频道",
                "查看更多",
                R.mipmap.tv_right
        ));

        mMultiTypeAdapter.setItems(mItems);
        mMultiTypeAdapter.notifyDataSetChanged();
    }
}
