package com.example.howard.ruiyipai.pages.stastic.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.howard.ruiyipai.R;

import java.util.ArrayList;

/**
 * Created by howard on 2018/1/14.
 * Email 158988127@qq.com
 */

public class AnswerInfoAdapter extends RecyclerView.Adapter<AnswerInfoAdapter.ViewHolder>{


    public AnswerInfoAdapter() {
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 实例化展示的view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_answer_info, parent, false);
        // 实例化viewholder
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // 绑定数据
//        holder.mTv.setText(mData.get(position));
//        holder.mLesson.setText("上午第一节");
//        holder.mComments.setText("高中高一年级1班 外语备课内容");
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}

