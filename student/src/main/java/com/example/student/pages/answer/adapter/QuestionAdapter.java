package com.example.student.pages.answer.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.student.R;

/**
 * Created by howard on 2018/1/14.
 * Email 158988127@qq.com
 */

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {

    private int currentIndex = 0;

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
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Log.e("zzzzzzz", "currentIndex: " + String.valueOf(currentIndex));
        Log.e("zzzzzzz", "position: " + String.valueOf(position));

        holder.questionNo.setText("" + (position + 1) + ".");

        View itemView = ((FrameLayout) holder.itemView).getChildAt(0);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = position;
                QuestionAdapter.this.notifyDataSetChanged();
            }
        });
        if (position == currentIndex) {
            holder.container.setSelected(true);
        } else {
            holder.container.setSelected(false);
        }
    }

    @Override
    public int getItemCount() {
//        return mData == null ? 0 : mData.size();
        return 15;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView questionNo;
        View container;

        public ViewHolder(View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.tab_background);
            questionNo = itemView.findViewById(R.id.item_no);
        }
    }
}

