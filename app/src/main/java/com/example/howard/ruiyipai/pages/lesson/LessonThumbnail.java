package com.example.howard.ruiyipai.pages.lesson;

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

public class LessonThumbnail extends RecyclerView.Adapter<LessonThumbnail.ViewHolder>{

    private ArrayList<String> mData;

    public LessonThumbnail(ArrayList<String> data) {
        this.mData = data;
    }

    public void updateData(ArrayList<String> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 实例化展示的view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lesson_grid, parent, false);
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
//        return mData == null ? 0 : mData.size();
        return 30;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

//        TextView mLesson;
//        TextView mComments;

        public ViewHolder(View itemView) {
            super(itemView);
//            mLesson = (TextView) itemView.findViewById(R.id.tv_home_lesson);
//            mComments = (TextView) itemView.findViewById(R.id.tv_home_lesson_comments);
        }
    }
}

