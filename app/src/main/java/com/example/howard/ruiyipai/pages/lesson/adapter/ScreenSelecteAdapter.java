package com.example.howard.ruiyipai.pages.lesson.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.common.Utils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by howard on 2018/1/14.
 * Email zh@longhuapuxin.com
 */

public class ScreenSelecteAdapter extends RecyclerView.Adapter<ScreenSelecteAdapter.ViewHolder> {

    private int mCount;

    public ScreenSelecteAdapter(int count) {
        mCount = count;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 实例化展示的view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_screen_number, parent, false);
        // 实例化viewholder
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mScreenNo.setText(String.valueOf(position+1));
    }

    @Override
    public int getItemCount() {
        return mCount;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_screen_no)
        TextView mScreenNo;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

}

