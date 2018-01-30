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

public class HomeworkStudentsAdapter extends RecyclerView.Adapter<ViewHolder> implements View.OnClickListener {

    public interface HomeworkOnClickListner {
        void onSubjectClicked();
    }

    private HomeworkOnClickListner mListener;

    public HomeworkStudentsAdapter(HomeworkOnClickListner listener) {
        this.mListener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        MyHolder viewHolder;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_homework, parent, false);
        // 实例化viewholder
        viewHolder = new MyHolder(v);

        viewHolder.subject1.setOnClickListener(this);
        viewHolder.subject2.setOnClickListener(this);
        viewHolder.subject3.setOnClickListener(this);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public void onClick(View v) {
        //主观题点击事件
        mListener.onSubjectClicked();
    }

    public static class MyHolder extends ViewHolder {

        View subject1;
        View subject2;
        View subject3;

        public MyHolder(View itemView) {
            super(itemView);
            subject1 = itemView.findViewById(R.id.tv_subject_1);
            subject2 = itemView.findViewById(R.id.tv_subject_2);
            subject3 = itemView.findViewById(R.id.tv_subject_3);

        }
    }
}

