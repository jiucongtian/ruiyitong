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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by howard on 2018/1/14.
 * Email 158988127@qq.com
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
        void switchBroadcast();
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
                IconicsDrawable iCourse = new IconicsDrawable(mContext).icon("fon_82f")
                        .color(Color.BLACK);
                holder.toolImg.setImageDrawable(iCourse);
                holder.toolName.setText("缩略图");
                break;
            }
            case TOOL_PROJECT:{
                IconicsDrawable iCourse = new IconicsDrawable(mContext).icon("fon_833")
                        .color(Color.BLACK);
                holder.toolImg.setImageDrawable(iCourse);
                holder.toolName.setText("投屏");
                break;
            }

            case TOOL_SPLIT: {
                IconicsDrawable iCourse = new IconicsDrawable(mContext).icon("fon_825")
                        .color(Color.BLACK);
                holder.toolImg.setImageDrawable(iCourse);
                holder.toolName.setText("分屏");
                break;
            }
            case TOOL_EXAM: {
                IconicsDrawable iCourse = new IconicsDrawable(mContext).icon("fon_83a")
                        .color(Color.BLACK);
                holder.toolImg.setImageDrawable(iCourse);
                holder.toolName.setText("发题");
                break;
            }
            case TOOL_STASTIC: {
                IconicsDrawable iCourse = new IconicsDrawable(mContext).icon("fon_832")
                        .color(Color.BLACK);
                holder.toolImg.setImageDrawable(iCourse);
                holder.toolName.setText("统计");
                break;
            }
            case TOOL_BROADCAST: {
                IconicsDrawable iCourse = new IconicsDrawable(mContext).icon("fon_827")
                        .color(Color.BLACK);
                holder.toolImg.setImageDrawable(iCourse);
                holder.toolName.setText("广播");
                break;
            }
            case TOOL_PEN: {
                IconicsDrawable iCourse = new IconicsDrawable(mContext).icon("fon_839")
                        .color(Color.BLACK);
                holder.toolImg.setImageDrawable(iCourse);
                holder.toolName.setText("笔");
                break;
            }
            case TOOL_LOCK: {
                IconicsDrawable iCourse = new IconicsDrawable(mContext).icon("fon_830")
                        .color(Color.BLACK);
                holder.toolImg.setImageDrawable(iCourse);
                holder.toolName.setText("锁定");
                break;
            }
            case TOOL_ERASER: {
                IconicsDrawable iCourse = new IconicsDrawable(mContext).icon("fon_834")
                        .color(Color.BLACK);
                holder.toolImg.setImageDrawable(iCourse);
                holder.toolName.setText("橡皮");
                break;
            }
            case TOOL_RETURN: {
                IconicsDrawable iCourse = new IconicsDrawable(mContext).icon("fon_83b")
                        .color(Color.BLACK);
                holder.toolImg.setImageDrawable(iCourse);
                holder.toolName.setText("返回");
                break;
            }
            case TOOL_ENLARGED: {
                IconicsDrawable iCourse = new IconicsDrawable(mContext).icon("fon_83c")
                        .color(Color.BLACK);
                holder.toolImg.setImageDrawable(iCourse);
                holder.toolName.setText("放大");
                break;
            }
            case TOOL_SHRINK: {
                IconicsDrawable iCourse = new IconicsDrawable(mContext).icon("fon_831")
                        .color(Color.BLACK);
                holder.toolImg.setImageDrawable(iCourse);
                holder.toolName.setText("缩小");
                break;
            }
            case TOOL_CLEAN: {
                IconicsDrawable iCourse = new IconicsDrawable(mContext).icon("fon_82b")
                        .color(Color.BLACK);
                holder.toolImg.setImageDrawable(iCourse);
                holder.toolName.setText("清空");
                break;
            }
            case TOOL_RIGHT: {
                IconicsDrawable iCourse = new IconicsDrawable(mContext).icon("fon_82c")
                        .color(Color.BLACK);
                holder.toolImg.setImageDrawable(iCourse);
                holder.toolName.setText("适屏");
                break;
            }
            case TOOL_COLOR: {
                IconicsDrawable iCourse = new IconicsDrawable(mContext).icon("fon_835")
                        .color(Color.BLACK);
                holder.toolImg.setImageDrawable(iCourse);
                holder.toolName.setText("颜色");
                break;
            }
            case TOOL_MUTE: {
                IconicsDrawable iCourse = new IconicsDrawable(mContext).icon("fon_82a")
                        .color(Color.BLACK);
                holder.toolImg.setImageDrawable(iCourse);
                holder.toolName.setText("静音");
                break;
            }
            case TOOL_CLOSE: {
                IconicsDrawable iCourse = new IconicsDrawable(mContext).icon("fon_826")
                        .color(Color.BLACK);
                holder.toolImg.setImageDrawable(iCourse);
                holder.toolName.setText("关闭");
                break;
            }
            case TOOL_REWARD: {
                IconicsDrawable iCourse = new IconicsDrawable(mContext).icon("fon_828")
                        .color(Color.BLACK);
                holder.toolImg.setImageDrawable(iCourse);
                holder.toolName.setText("奖励");
                break;
            }
            case TOOL_COLLECTION: {
                IconicsDrawable iCourse = new IconicsDrawable(mContext).icon("fon_82d")
                        .color(Color.BLACK);
                holder.toolImg.setImageDrawable(iCourse);
                holder.toolName.setText("收藏");
                break;
            }
            case TOOL_DESKTOP: {
                IconicsDrawable iCourse = new IconicsDrawable(mContext).icon("fon_836")
                        .color(Color.BLACK);
                holder.toolImg.setImageDrawable(iCourse);
                holder.toolName.setText("桌面");
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
                        case TOOL_SPLIT:
                            mToolsSelectListener.switchSplideMode();
                            break;
                        case TOOL_STASTIC:
                            mToolsSelectListener.stastic();
                            break;
                        case TOOL_THUMBNAIL:
                            mToolsSelectListener.switchThumbnail();
                            break;
                        case TOOL_BROADCAST:
                            mToolsSelectListener.switchBroadcast();
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

