package com.example.howard.ruiyipai.pages.homework.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.base.BaseFragment;
import com.example.howard.ruiyipai.pages.homework.adapter.CheckHomeworkClassListAdapter;
import com.example.howard.ruiyipai.pages.homework.adapter.HomeworkSubjectStudentsAdapter;

import butterknife.BindView;

/**
 * Created by howard on 2018/1/29.
 * Email 158988127@qq.com
 */

public class HomeworkSubjectFragment extends BaseFragment {

    @Override
    protected void initPages() {
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_homework_subject;
    }
}
