package com.example.student.pages.homework.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.student.R;

/**
 * Created by howard on 2018/1/14.
 * Email 158988127@qq.com
 */

public class HomeworkListAdapter extends RecyclerView.Adapter<HomeworkListAdapter.ViewHolder> {

    static final int ITEM_TYPE_DATE = 0x1;
    static final int ITEM_TYPE_ITEM = 0x2;


    public HomeworkListAdapter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        int resourceId;
        if (viewType == ITEM_TYPE_DATE) {
            resourceId = R.layout.item_homework_date;
        } else {
            resourceId = R.layout.item_homework;

        }

        // 实例化展示的view
        View v = LayoutInflater.from(parent.getContext()).inflate(resourceId, parent, false);
        // 实例化viewholder
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
//        return mData == null ? 0 : mData.size();
        return 15;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 || position == 5) {
            return ITEM_TYPE_DATE;
        } else {
            return ITEM_TYPE_ITEM;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}

