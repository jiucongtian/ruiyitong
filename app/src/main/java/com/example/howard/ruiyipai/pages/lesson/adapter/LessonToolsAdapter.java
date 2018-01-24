package com.example.howard.ruiyipai.pages.lesson.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.pages.lesson.LessonActivity;
import com.mikepenz.iconics.IconicsDrawable;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.howard.ruiyipai.pages.lesson.LessonActivity.TOOL_TYPE.TOOL_EXAM;

/**
 * Created by howard on 2018/1/14.
 * Email zh@longhuapuxin.com
 */

public class LessonToolsAdapter extends RecyclerView.Adapter<LessonToolsAdapter.ViewHolder>{

//    public enum TOOL_TYPE {
//        THUMBNAIL,
//        EXAM,
//        PENCLE,
//        SPLIDE
//    }


    public interface ToolsSelectListener {
        void sendQuestions();
        void switchSplideMode();
        void stastic();
        void switchThumbnail();
    }

    private List<LessonActivity.TOOL_TYPE> mData;
    ToolsSelectListener mToolsSelectListener;
    Context mContext;

    public LessonToolsAdapter(Context context, ToolsSelectListener listener, List<LessonActivity.TOOL_TYPE> data) {
        this.mData = data;
        mToolsSelectListener = listener;
        mContext = context;
    }

    public void updateData(List<LessonActivity.TOOL_TYPE> data) {
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

        LessonActivity.TOOL_TYPE type = mData.get(position);
        holder.itemView.setTag(type);

        switch (type) {
            case TOOL_THUMBNAIL: {
                IconicsDrawable iCourse = new IconicsDrawable(mContext).icon("fon_810")
                        .color(Color.BLACK);
                holder.toolImg.setImageDrawable(iCourse);
                holder.toolName.setText("缩略图");
                break;
            }
            case TOOL_PROJECT:
                break;

            case TOOL_SPLIDE: {
                IconicsDrawable iCourse = new IconicsDrawable(mContext).icon("fon_81d")
                        .color(Color.BLACK);
                holder.toolImg.setImageDrawable(iCourse);
                holder.toolName.setText("分屏");
                break;
            }
            case TOOL_EXAM: {
                IconicsDrawable iCourse = new IconicsDrawable(mContext).icon("fon_81d")
                        .color(Color.BLACK);
                holder.toolImg.setImageDrawable(iCourse);
                holder.toolName.setText("发题");
                break;
            }
            case TOOL_STASTIC: {
                IconicsDrawable iCourse = new IconicsDrawable(mContext).icon("fon_81d")
                        .color(Color.BLACK);
                holder.toolImg.setImageDrawable(iCourse);
                holder.toolName.setText("统计");
                break;
            }
        }

        // 绑定点击事件
        View itemView = ((ViewGroup) holder.itemView).getChildAt(0);

        if (mToolsSelectListener != null) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    LessonActivity.TOOL_TYPE type = (LessonActivity.TOOL_TYPE) holder.itemView.getTag();

                    switch (type) {
                        case TOOL_EXAM:
                            mToolsSelectListener.sendQuestions();
                            break;
                        case TOOL_SPLIDE:
                            mToolsSelectListener.switchSplideMode();
                            break;
                        case TOOL_STASTIC:
                            mToolsSelectListener.stastic();
                            break;
                        case TOOL_THUMBNAIL:
                            mToolsSelectListener.switchThumbnail();
                            break;
                    }

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
//        return 15;
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

