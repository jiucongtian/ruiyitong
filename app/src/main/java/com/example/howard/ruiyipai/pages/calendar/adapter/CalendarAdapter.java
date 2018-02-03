package com.example.howard.ruiyipai.pages.calendar.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.howard.ruiyipai.R;

/**
 * Created by howard on 2018/1/14.
 * Email 158988127@qq.com
 */

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.ViewHolder> implements View.OnClickListener {

    public interface CalendarListener {
        void onClickCalendar(int weekday);
    }

    CalendarListener mListener;

    public CalendarAdapter(CalendarListener listener) {
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 实例化展示的view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_calendar, parent, false);
        // 实例化viewholder
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mMonday.setOnClickListener(this);
        holder.mThursday.setOnClickListener(this);
        holder.mSaturday.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
//        return mData == null ? 0 : mData.size();
        return 10;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.rl_monday:
                mListener.onClickCalendar(1);
                break;
            case R.id.rl_thursday:
                mListener.onClickCalendar(4);
                break;
            case R.id.rl_saturday:
                mListener.onClickCalendar(6);
                break;
        }

    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        View mMonday;
        View mThursday;
        View mSaturday;

        public ViewHolder(View itemView) {
            super(itemView);
            mMonday = itemView.findViewById(R.id.rl_monday);
            mThursday = itemView.findViewById(R.id.rl_thursday);
            mSaturday = itemView.findViewById(R.id.rl_saturday);
        }
    }
}

