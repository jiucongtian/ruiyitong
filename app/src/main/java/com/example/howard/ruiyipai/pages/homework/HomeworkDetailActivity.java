package com.example.howard.ruiyipai.pages.homework;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.base.BaseActivity;
import com.example.howard.ruiyipai.pages.homework.adapter.CheckHomeworkClassListAdapter;
import com.example.howard.ruiyipai.pages.homework.adapter.HomeworkStudentsAdapter;
import com.mikepenz.iconics.IconicsDrawable;

import butterknife.BindView;

/**
 * Created by howard on 2018/1/28.
 * Email 158988127@qq.com
 */

public class HomeworkDetailActivity extends BaseActivity {

    @BindView(R.id.tb_header)
    Toolbar mToolbar;

    @BindView(R.id.rv_student_list)
    RecyclerView mStudentListRv;

    @Override
    public void initPages() {
        initToolBar();

        initStudentsAnswer();

    }

    private void initStudentsAnswer() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mStudentListRv.setLayoutManager(layoutManager);

        HomeworkStudentsAdapter adapter = new HomeworkStudentsAdapter();
        mStudentListRv.setAdapter(adapter);
    }

    private void initToolBar() {
        IconicsDrawable iResource = new IconicsDrawable(this).icon("fon_816").sizeDp(30)
                .colorRes(R.color.light_blue_deep);

        mToolbar.setNavigationIcon(iResource);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_homework_detail;
    }
}
