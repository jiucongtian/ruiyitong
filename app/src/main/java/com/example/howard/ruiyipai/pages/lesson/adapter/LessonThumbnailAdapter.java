package com.example.howard.ruiyipai.pages.lesson.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.howard.ruiyipai.R;

import java.util.ArrayList;

/**
 * Created by howard on 2018/1/14.
 * Email zh@longhuapuxin.com
 */

public class LessonThumbnailAdapter extends RecyclerView.Adapter{
    public static final int ITEM_TYPE_PPT = 0x01;
    public static final int ITEM_TYPE_WORD = 0x02;

    private ArrayList<String> mData;

    private int viewType;

    public LessonThumbnailAdapter(ArrayList<String> data) {
        this.mData = data;
        viewType = ITEM_TYPE_PPT;
    }

    public void setThumbnailType(int type) {
        viewType = type;
    }

    public void updateData(ArrayList<String> data) {
        this.mData = data;
        notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == ITEM_TYPE_PPT) {
            // 实例化展示的view
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lesson_thumbnail, parent, false);
            // 实例化viewholder
            return new PPtViewHolder(v);
        } else {
            // 实例化展示的view
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lesson_thumbnail_word, parent, false);
            // 实例化viewholder
            return new WordViewHolder(v);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 30;
    }


    @Override
    public int getItemViewType(int position) {
        return viewType;
    }

    public static class PPtViewHolder extends RecyclerView.ViewHolder {

        public PPtViewHolder(View itemView) {
            super(itemView);
        }
    }

    public static class WordViewHolder extends RecyclerView.ViewHolder {

        public WordViewHolder(View itemView) {
            super(itemView);
        }
    }
}

