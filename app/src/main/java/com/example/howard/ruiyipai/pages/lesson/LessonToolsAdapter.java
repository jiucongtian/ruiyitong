package com.example.howard.ruiyipai.pages.lesson;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.howard.ruiyipai.R;
import com.mikepenz.iconics.IconicsDrawable;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by howard on 2018/1/14.
 * Email zh@longhuapuxin.com
 */

public class LessonToolsAdapter extends RecyclerView.Adapter<LessonToolsAdapter.ViewHolder>{

    public enum TOOL_TYPE {
        THUMBNAIL,
        EXAM,
        PENCLE,
        SPLIDE
    }


    public interface ToolsSelectListener {
        void sendQuestions();
        void switchSplideMode();
    }

    private ArrayList<String> mData;
    ToolsSelectListener mToolsSelectListener;
    Context mContext;

    public LessonToolsAdapter(Context context, ToolsSelectListener listener, ArrayList<String> data) {
        this.mData = data;
        mToolsSelectListener = listener;
        mContext = context;
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


        //临时假数据
        if (position == 0) {
            TOOL_TYPE type = TOOL_TYPE.THUMBNAIL;
            holder.itemView.setTag(type);
            IconicsDrawable iCourse = new IconicsDrawable(mContext).icon("fon_810")
                    .color(Color.BLACK);
            holder.toolImg.setImageDrawable(iCourse);
            holder.toolName.setText("缩略图");
        } else if (position == 1) {
            TOOL_TYPE type = TOOL_TYPE.EXAM;
            holder.itemView.setTag(type);
            IconicsDrawable iCourse = new IconicsDrawable(mContext).icon("fon_81d")
                    .color(Color.BLACK);
            holder.toolImg.setImageDrawable(iCourse);
            holder.toolName.setText("发题");
        } else if (position == 2) {
            TOOL_TYPE type = TOOL_TYPE.SPLIDE;
            holder.itemView.setTag(type);
            IconicsDrawable iCourse = new IconicsDrawable(mContext).icon("fon_81d")
                    .color(Color.BLACK);
            holder.toolImg.setImageDrawable(iCourse);
            holder.toolName.setText("分屏");
        }
        //临时假数据 end




        // 绑定点击事件
        View itemView = ((ViewGroup) holder.itemView).getChildAt(0);

        if (mToolsSelectListener != null) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    TOOL_TYPE type = (TOOL_TYPE) holder.itemView.getTag();
                    if (type == TOOL_TYPE.EXAM) {
                        mToolsSelectListener.sendQuestions();
                    } else if (type == TOOL_TYPE.SPLIDE) {
                        mToolsSelectListener.switchSplideMode();
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

        @BindView(R.id.iv_tool_img)
        ImageView toolImg;

        @BindView(R.id.tv_tool_name)
        TextView toolName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

