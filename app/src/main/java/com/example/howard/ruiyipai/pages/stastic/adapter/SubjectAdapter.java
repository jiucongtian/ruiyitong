package com.example.howard.ruiyipai.pages.stastic.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.howard.ruiyipai.R;

/**
 * Created by howard on 2018/1/14.
 * Email 158988127@qq.com
 */

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.ViewHolder>{

    public interface SubjectListener {
        void showAnswerDetail();
    }

    SubjectListener listener;

    public SubjectAdapter(SubjectListener listener) {
        this.listener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 实例化展示的view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_subject_answer, parent, false);
        // 实例化viewholder
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.showAnswerDetail();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        View container;

        public ViewHolder(View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.rl_container);
        }
    }
}

