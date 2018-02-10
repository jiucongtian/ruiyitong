package com.example.howard.ruiyipai.pages.lesson.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.howard.ruiyipai.R;
import com.example.baselibrary.common.Utils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by howard on 2018/1/14.
 * Email 158988127@qq.com
 */

public class ResourceListAdapter extends RecyclerView.Adapter<ResourceListAdapter.ViewHolder> {

    static final int HEIGHT_OF_NUMBER = 44;
    static final int COUNT_IN_LINE = 6;
    private int screenCount;

    private Context mContext;

    public ResourceListAdapter(Context context) {
        this.mContext = context;
        screenCount = 3;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 实例化展示的view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_resource, parent, false);
        // 实例化viewholder
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        RecyclerView snContainer = holder.screenNumberRv;

        //设置分屏选择框高度
        ViewGroup.LayoutParams layoutParams = snContainer.getLayoutParams();

        if (screenCount <= COUNT_IN_LINE) {
            layoutParams.height = Utils.dip2px(mContext, HEIGHT_OF_NUMBER);
        } else {
            layoutParams.height = Utils.dip2px(mContext, HEIGHT_OF_NUMBER) * 2;
        }
        snContainer.setLayoutParams(layoutParams);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(mContext, COUNT_IN_LINE, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        snContainer.setLayoutManager(layoutManager);

        ScreenSelecteAdapter adapter = new ScreenSelecteAdapter(screenCount);
        snContainer.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
//        return mData == null ? 0 : mData.size();

        //TODO: 临时写死个数，需要根据程序计算
        return 10;
    }

    public void setScreenCount(int count) {
        this.screenCount = count;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.rv_screen_number)
        RecyclerView screenNumberRv;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

}

