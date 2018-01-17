package com.example.howard.ruiyipai.pages.home;

import android.graphics.Color;
import android.os.Build;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Gravity;
import android.view.View;
import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.base.BaseActivity;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.howard.ruiyipai.pages.lesson.Lesson;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.howard.ruiyipai.recyclerAdapter.ClassAdapter;
import com.mikepenz.iconics.IconicsDrawable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {

    @BindView(R.id.rlv_class)
    RecyclerView classLv;

    @BindView(R.id.drawer_layout)
    DrawerLayout dl;

    @BindView(R.id.ll_pop_ground)
    View popLayout;

    boolean openStatus = false;

    @Override
    public void initPages() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        classLv.setLayoutManager(layoutManager);

        ClassAdapter test = new ClassAdapter(null);
        classLv.setAdapter(test);
    }

    @BindView(R.id.ll_work)
    LinearLayout llwork;

    @BindView(R.id.ll_online)
    LinearLayout llonline;

    @BindView(R.id.ll_resource)
    LinearLayout llresource;

    @BindView(R.id.ll_course)
    LinearLayout llcourse;

    @BindView(R.id.iv_work)
    ImageView ivWork;

    @BindView(R.id.tv_work_cn)
    TextView tvWorkCN;

    @BindView(R.id.tv_work_en)
    TextView tvWorkEN;


    @OnClick({R.id.iv_home_menu, R.id.iv_camera,R.id.ll_course,R.id.ll_online,R.id.ll_resource,R.id.ll_work})
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.iv_home_menu:
                dl.openDrawer(Gravity.LEFT);
                break;
            case R.id.ll_work:
                llwork.setBackgroundResource(R.mipmap.shadow_blue);

                //ivWork.setColorFilter(R.color.white);
                if (Build.VERSION.SDK_INT < 23) {
                    tvWorkCN.setTextAppearance(this,R.style.txt_22_white);
                    tvWorkEN.setTextAppearance(this,R.style.txt_14_white);
                } else {
                    tvWorkCN.setTextAppearance(R.style.txt_22_white);
                    tvWorkEN.setTextAppearance(R.style.txt_14_white);
                }

                //ivWork.setBackgroundColor(R.color.white);

                IconicsDrawable tt =new IconicsDrawable(this).icon("fon_807")
                        .color(Color.WHITE);

                ivWork.setImageDrawable(tt);
                //setTheme(R.style.txt_22_white);


                //test
                Intent intent = new Intent(this, Lesson.class);
                this.startActivity(intent);
                //test end
                break;
            case R.id.ll_online:
                llonline.setBackgroundResource(R.mipmap.shadow_green);
                break;
            case R.id.ll_resource:
                llresource.setBackgroundResource(R.mipmap.shadow_gray);
                break;
            case R.id.ll_course:
                llcourse.setBackgroundResource(R.mipmap.shadow_yellow);
                break;
            case R.id.iv_camera:

                if (openStatus) {
                    Animation anim = AnimationUtils.loadAnimation(this, R.anim.camera_reverse);
                    anim.setFillAfter(true);
                    popLayout.startAnimation(anim);
                    openStatus = false;
                } else {
                    Animation anim = AnimationUtils.loadAnimation(this, R.anim.camera);
                    anim.setFillAfter(true);
                    popLayout.startAnimation(anim);
                    openStatus = true;
                }

                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
