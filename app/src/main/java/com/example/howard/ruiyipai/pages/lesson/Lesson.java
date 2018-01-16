package com.example.howard.ruiyipai.pages.lesson;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.base.BaseActivity;
import com.example.howard.ruiyipai.recyclerAdapter.ClassAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class Lesson extends BaseActivity {

    @Override
    public void initPages() {
    }

//    @OnClick({R.id.iv_home_menu, R.id.iv_camera})
//    public void onClick(View v) {
//        int id = v.getId();
//    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_lesson;
    }
}
