package com.example.howard.ruiyipai.pages.questions;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.pages.questions.bean.StudentSelectionBean;
import com.example.howard.ruiyipai.bean.StudentsGroupNode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by howard on 2018/1/14.
 * Email 158988127@qq.com
 */

public class questionSelectorAdapter extends RecyclerView.Adapter{

    public static final int TYPE_CLASS = 0;
    public static final int TYPE_TEAM = 1;
    public static final int TYPE_STUDENT = 2;


    private List<StudentSelectionBean> mData;

    private StudentsGroupNode mClassData;

    public questionSelectorAdapter(List<StudentSelectionBean> data) {
        this.mData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_CLASS) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_class_selector, parent, false);
            // 实例化viewholder
            return new ClassViewHolder(v);
        } else if (viewType == TYPE_TEAM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team_selector, parent, false);
            // 实例化viewholder
            return new TeamViewHolder(v);
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_selector, parent, false);
            // 实例化viewholder
            return new StudentViewHolder(v);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ClassViewHolder) {
            ClassViewHolder classHolder = (ClassViewHolder) holder;
            StudentSelectionBean selection = mData.get(position);
            classHolder.nameTv.setText(selection.name);
        } else if (holder instanceof TeamViewHolder) {
            TeamViewHolder classHolder = (TeamViewHolder) holder;
            StudentSelectionBean selection = mData.get(position);
            classHolder.nameTv.setText(selection.name);
        } else if (holder instanceof StudentViewHolder) {
            StudentViewHolder classHolder = (StudentViewHolder) holder;
            StudentSelectionBean selection = mData.get(position);
            classHolder.nameTv.setText(selection.name);
        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    @Override
    public int getItemViewType(int position) {
        int type = TYPE_CLASS;

        if (StudentSelectionBean.SELECTION_TYPE.TYPE_CLASS == mData.get(position).type) {
            type = TYPE_CLASS;
        } else if (StudentSelectionBean.SELECTION_TYPE.TYPE_TEAM == mData.get(position).type) {
            type = TYPE_TEAM;
        } else if (StudentSelectionBean.SELECTION_TYPE.TYPE_STUDENT == mData.get(position).type) {
            type = TYPE_STUDENT;
        }

        return type;
    }

    public static class ClassViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_mark)
        ImageView markIv;

        @BindView(R.id.tv_name)
        TextView nameTv;

        public ClassViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static class TeamViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_mark)
        ImageView markIv;

        @BindView(R.id.tv_name)
        TextView nameTv;
        public TeamViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_mark)
        ImageView markIv;

        @BindView(R.id.tv_name)
        TextView nameTv;
        public StudentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}

