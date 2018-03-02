package com.example.student.pages.answer.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.student.R;

/**
 * Created by howard on 2018/1/14.
 * Email 158988127@qq.com
 */

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {

    public QuestionAdapter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 实例化展示的view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_answer_no, parent, false);
        // 实例化viewholder
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if (position == 3) {
            holder.tabBg.setBackgroundResource(R.drawable.answer_tab_bg);
            holder.itemBg.setBackground(null);
        }
    }

    @Override
    public int getItemCount() {
//        return mData == null ? 0 : mData.size();
        return 15;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        View tabBg;
        View itemBg;

        public ViewHolder(View itemView) {
            super(itemView);

            tabBg = itemView.findViewById(R.id.tab_background);
            itemBg = itemView.findViewById(R.id.item_bg);
        }
    }
}

