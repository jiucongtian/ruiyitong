package com.example.student.pages.wrongtopic.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.student.R;

/**
 * Created by howard on 2018/1/14.
 * Email 158988127@qq.com
 */

public class WrongTopicCategoryAdapter extends RecyclerView.Adapter<WrongTopicCategoryAdapter.ViewHolder> {

    public WrongTopicCategoryAdapter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 实例化展示的view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wrong_topic_category, parent, false);
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

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}

