package com.example.howard.ruiyipai.pages.calendar.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.howard.ruiyipai.R;
import com.example.baselibrary.base.BaseFragment;
import com.example.howard.ruiyipai.pages.calendar.adapter.CommentsAdapter;
import com.example.howard.ruiyipai.pages.calendar.adapter.PrepareLessonAdapter;

import butterknife.BindView;

/**
 * Created by howard on 2018/2/2.
 * Email 158988127@qq.com
 */

public class PrepareLessonFragment extends BaseFragment {

    @BindView(R.id.rv_comments)
    RecyclerView comments;

    @Override
    protected void initPages() {


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        comments.setLayoutManager(layoutManager);

        PrepareLessonAdapter adapter = new PrepareLessonAdapter();
        comments.setAdapter(adapter);

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_comments;
    }
}
