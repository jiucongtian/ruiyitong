package com.example.howard.ruiyipai.pages.homework.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.howard.ruiyipai.R;

/**
 * Created by howard on 2018/1/14.
 * Email 158988127@qq.com
 */

public class HomeworkSubjectStudentsAdapter extends RecyclerView.Adapter<ViewHolder> {

    public HomeworkSubjectStudentsAdapter() {
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        MyHolder viewHolder;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_homework_subject_student, parent, false);
        // 实例化viewholder
        viewHolder = new MyHolder(v);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public static class MyHolder extends ViewHolder {

        public MyHolder(View itemView) {
            super(itemView);
        }
    }
}

