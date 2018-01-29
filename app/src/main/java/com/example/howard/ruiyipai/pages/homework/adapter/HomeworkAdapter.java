package com.example.howard.ruiyipai.pages.homework.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.howard.ruiyipai.R;

import butterknife.ButterKnife;

/**
 * Created by howard on 2018/1/14.
 * Email 158988127@qq.com
 */

public class HomeworkAdapter extends RecyclerView.Adapter<ViewHolder> {

    static final int TYPE_DATE = 0x00;
    static final int TYPE_HOMEWORK = 0x01;

    public interface OnItemClickListener {
        void itemSelected();
    }

    private OnItemClickListener mListener;

    public HomeworkAdapter(OnItemClickListener listener) {
        this.mListener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ViewHolder viewHolder;
        switch (viewType) {
            case TYPE_DATE: {
                // 实例化展示的view
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_homework_date, parent, false);
                // 实例化viewholder
                viewHolder = new DateHolder(v);
                break;
            }
            case TYPE_HOMEWORK: {
                // 实例化展示的view
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_homework, parent, false);
                // 实例化viewholder
                viewHolder = new HomeworkHolder(v);
                break;
            }

            default: {
                // 实例化展示的view
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_homework, parent, false);
                // 实例化viewholder
                viewHolder = new HomeworkHolder(v);
                break;
            }
        }
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        if (position == 0) {
            DateHolder dateHolder = (DateHolder) holder;
            dateHolder.mHomeworkDateTv.setText("今天");
            dateHolder.mSstatusContainer.setVisibility(View.VISIBLE);
        }

        if (holder instanceof HomeworkHolder) {
            ((HomeworkHolder) holder).mRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.itemSelected();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 || position == 6 || position == 14) {
            return TYPE_DATE;
        } else {
            return TYPE_HOMEWORK;
        }
    }

    public static class DateHolder extends RecyclerView.ViewHolder {

        TextView mHomeworkDateTv;
        View mSstatusContainer;

        public DateHolder(View itemView) {
            super(itemView);
            mHomeworkDateTv = itemView.findViewById(R.id.tv_homework_date);
            mSstatusContainer = itemView.findViewById(R.id.ll_homework_status);
        }
    }
    public static class HomeworkHolder extends RecyclerView.ViewHolder {

        View mRoot;

        public HomeworkHolder(View itemView) {
            super(itemView);
            mRoot = itemView.findViewById(R.id.rl_root_container);
        }
    }
}

