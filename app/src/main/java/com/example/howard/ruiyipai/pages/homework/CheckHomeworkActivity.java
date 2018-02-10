package com.example.howard.ruiyipai.pages.homework;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.howard.ruiyipai.R;
import com.example.baselibrary.base.BaseActivity;
import com.example.baselibrary.common.Utils;
import com.example.howard.ruiyipai.pages.homework.adapter.CheckHomeworkClassListAdapter;
import com.example.howard.ruiyipai.pages.homework.adapter.HomeworkAdapter;
import com.example.howard.ruiyipai.pages.homework.adapter.HomeworkSubjectStudentsAdapter;
import com.example.howard.ruiyipai.pages.lesson.adapter.SelectLessonsAdapter;
import com.mikepenz.iconics.IconicsDrawable;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by howard on 2018/1/28.
 * Email 158988127@qq.com
 */

public class CheckHomeworkActivity extends BaseActivity implements HomeworkAdapter.OnItemClickListener {

    @BindView(R.id.tb_header)
    Toolbar mToolbar;

    @BindView(R.id.rv_homework_list)
    RecyclerView mHomeworkList;

    @BindView(R.id.left_drawer)
    DrawerLayout leftDrawer;

    @BindView(R.id.rv_classes)
    RecyclerView mClassList;

    @BindView(R.id.et_homework_search)
    EditText searchView;

    @BindView(R.id.tv_cancel)
    TextView mSearchCancel;

    @Override
    public void initPages() {
        initToolBar();
        initHomeworkList();
        initLeftDrawer();
    }

    private void initLeftDrawer() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mClassList.setLayoutManager(layoutManager);

        CheckHomeworkClassListAdapter adapter = new CheckHomeworkClassListAdapter();
        mClassList.setAdapter(adapter);
    }

    private void initHomeworkList() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mHomeworkList.setLayoutManager(layoutManager);

        HomeworkAdapter adapter = new HomeworkAdapter(this);
        mHomeworkList.setAdapter(adapter);
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

        searchView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    changeToSearchMode(true);
                }
            }
        });
    }

    private void changeToSearchMode(boolean flag) {
        if (flag) {
            mSearchCancel.setVisibility(View.VISIBLE);
            ViewGroup.LayoutParams lp = searchView.getLayoutParams();
            lp.width = Utils.dip2px(this, 400);
            searchView.setLayoutParams(lp);
        } else {
            mSearchCancel.setVisibility(View.GONE);
            ViewGroup.LayoutParams lp = searchView.getLayoutParams();
            lp.width = Utils.dip2px(this, 120);
            searchView.setLayoutParams(lp);

            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            searchView.clearFocus();

        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_check_homework;
    }

    @OnClick({R.id.fl_select_file, R.id.tv_cancel})
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.fl_select_file:
                leftDrawer.openDrawer(Gravity.LEFT);
                break;
            case R.id.tv_cancel:
                changeToSearchMode(false);
                break;
        }
    }

    @Override
    public void itemSelected() {
        Intent intent = new Intent(this, HomeworkDetailActivity.class);
        startActivity(intent);
    }
}
