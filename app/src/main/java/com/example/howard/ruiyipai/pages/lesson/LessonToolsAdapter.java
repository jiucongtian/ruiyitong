package com.example.howard.ruiyipai.pages.lesson;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.howard.ruiyipai.R;

import java.util.ArrayList;

/**
 * Created by howard on 2018/1/14.
 * Email zh@longhuapuxin.com
 */

public class LessonToolsAdapter extends RecyclerView.Adapter<LessonToolsAdapter.ViewHolder>{

    public interface ToolsSelectListener {
        void sendQuestions();
    }

    private ArrayList<String> mData;
    ToolsSelectListener mToolsSelectListener;

    public LessonToolsAdapter(ToolsSelectListener listener, ArrayList<String> data) {
        this.mData = data;
        mToolsSelectListener = listener;
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
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // 绑定数据
//        holder.mTv.setText(mData.get(position));
//        holder.mLesson.setText("上午第一节");
//        holder.mComments.setText("高中高一年级1班 外语备课内容");
        View itemView = ((ViewGroup) holder.itemView).getChildAt(0);

        if (mToolsSelectListener != null) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition();

                    if (0 == position) {
                        mToolsSelectListener.sendQuestions();
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
//        return mData == null ? 0 : mData.size();
        return 15;
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

