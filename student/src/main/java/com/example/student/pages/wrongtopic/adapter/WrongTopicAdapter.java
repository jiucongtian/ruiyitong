package com.example.student.pages.wrongtopic.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.student.R;

/**
 * Created by howard on 2018/1/14.
 * Email 158988127@qq.com
 */

public class WrongTopicAdapter extends RecyclerView.Adapter<WrongTopicAdapter.ViewHolder> {

    public interface NoteClickListener {
        public void onNoteClicked();
    }

    private NoteClickListener mListener;

    public WrongTopicAdapter(NoteClickListener listener) {
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 实例化展示的view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wrong_topic, parent, false);

        // 实例化viewholder
        ViewHolder viewHolder = new ViewHolder(v);

        View itemView = ((RelativeLayout) viewHolder.itemView).getChildAt(0);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onNoteClicked();
            }
        });
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
//        return mData == null ? 0 : mData.size();
        return 15;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}

