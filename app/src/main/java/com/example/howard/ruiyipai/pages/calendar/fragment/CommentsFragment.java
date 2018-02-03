package com.example.howard.ruiyipai.pages.calendar.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.base.BaseFragment;
import com.example.howard.ruiyipai.pages.calendar.adapter.CalendarAdapter;
import com.example.howard.ruiyipai.pages.calendar.adapter.CommentsAdapter;

import butterknife.BindView;

/**
 * Created by howard on 2018/2/2.
 * Email 158988127@qq.com
 */

public class CommentsFragment extends BaseFragment {

    @BindView(R.id.rv_comments)
    RecyclerView comments;

    @Override
    protected void initPages() {


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        comments.setLayoutManager(layoutManager);

        CommentsAdapter adapter = new CommentsAdapter();
        comments.setAdapter(adapter);

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_comments;
    }
}
