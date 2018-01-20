package com.example.howard.ruiyipai.pages.home;

import android.graphics.Color;
import android.os.Build;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;

import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.base.BaseActivity;

import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.howard.ruiyipai.common.Utils;
import com.example.howard.ruiyipai.pages.TestActivity;
import com.example.howard.ruiyipai.pages.lesson.LessonActivity;

import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.howard.ruiyipai.recyclerAdapter.ClassAdapter;
import com.mikepenz.iconics.IconicsDrawable;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity implements ClassAdapter.OnItemClickListener {

    @BindView(R.id.rlv_class)
    RecyclerView classLv;

    @BindView(R.id.drawer_layout)
    DrawerLayout dl;

    @BindView(R.id.ll_pop_ground)
    View popLayout;


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

    @BindView(R.id.iv_online)
    ImageView ivOnline;

    @BindView(R.id.tv_online_cn)
    TextView tvOnlineCN;

    @BindView(R.id.tv_online_en)
    TextView tvOnlineEN;

    @BindView(R.id.iv_resource)
    ImageView ivResource;

    @BindView(R.id.tv_resource_cn)
    TextView tvResourceCN;

    @BindView(R.id.tv_resource_en)
    TextView tvResourceEN;

    @BindView(R.id.iv_course)
    ImageView ivCourse;

    @BindView(R.id.tv_course_cn)
    TextView tvCourseCN;

    @BindView(R.id.tv_course_en)
    TextView tvCourseEN;

    @BindView(R.id.bt_yunping)
    Button btYunping;
    @BindView(R.id.bt_zuoye)
    Button btZuoye;
    @BindView(R.id.bt_xiaoyuan)
    Button btXiaoyuan;
    @BindView(R.id.bt_duofen)
    Button btDuofen;

    boolean openStatus = false;

    ClassAdapter mClassAdapter = null;

    @Override
    public void initPages() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        classLv.setLayoutManager(layoutManager);

        mClassAdapter = new ClassAdapter(null);
        mClassAdapter.setOnItemClickListener(this);

        classLv.setAdapter(mClassAdapter);
    }


    @OnClick({R.id.iv_home_menu, R.id.iv_camera, R.id.ll_course, R.id.ll_online, R.id.ll_resource, R.id.ll_work, R.id.bt_yunping, R.id.bt_zuoye, R.id.bt_xiaoyuan, R.id.bt_duofen})
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.iv_home_menu:
                dl.openDrawer(Gravity.LEFT);
                break;
            case R.id.ll_work:
                llwork.setBackgroundResource(R.mipmap.shadow_blue);
                Utils.setTVStyle(this, tvWorkCN, R.style.txt_22_white);
                Utils.setTVStyle(this, tvWorkEN, R.style.txt_14_white);
                IconicsDrawable tt = new IconicsDrawable(this).icon("fon_807")
                        .color(Color.WHITE);
                ivWork.setImageDrawable(tt);
                break;
            case R.id.ll_online:
                llonline.setBackgroundResource(R.mipmap.shadow_green);
                Utils.setTVStyle(this, tvOnlineCN, R.style.txt_22_white);
                Utils.setTVStyle(this, tvOnlineEN, R.style.txt_14_white);
                IconicsDrawable iOnline = new IconicsDrawable(this).icon("fon_805")
                        .color(Color.WHITE);
                ivOnline.setImageDrawable(iOnline);
                break;
            case R.id.ll_resource:

                //test
                Intent testIntent = new Intent(this, TestActivity.class);
                this.startActivity(testIntent);


                llresource.setBackgroundResource(R.mipmap.shadow_gray);
                Utils.setTVStyle(this, tvResourceCN, R.style.txt_22_white);
                Utils.setTVStyle(this, tvResourceEN, R.style.txt_14_white);
                IconicsDrawable iResource = new IconicsDrawable(this).icon("fon_806")
                        .color(Color.WHITE);
                ivResource.setImageDrawable(iResource);
                break;
            case R.id.ll_course:
                llcourse.setBackgroundResource(R.mipmap.shadow_yellow);
                Utils.setTVStyle(this, tvCourseCN, R.style.txt_22_white);
                Utils.setTVStyle(this, tvCourseEN, R.style.txt_14_white);
                IconicsDrawable iCourse = new IconicsDrawable(this).icon("fon_802")
                        .color(Color.WHITE);
                ivCourse.setImageDrawable(iCourse);
                break;
            case R.id.bt_yunping:
                btYunping.setBackground(getDrawable(R.drawable.home_btn1_click));
                Utils.setBTStyle(this, btYunping, R.style.txt_22_white);
                break;
            case R.id.bt_zuoye:
                btZuoye.setBackground(getDrawable(R.drawable.home_btn3_click));
                Utils.setBTStyle(this, btZuoye, R.style.txt_22_white);
                break;
            case R.id.bt_xiaoyuan:
                btXiaoyuan.setBackground(getDrawable(R.drawable.home_btn2_click));
                Utils.setBTStyle(this, btXiaoyuan, R.style.txt_22_white);
                break;
            case R.id.bt_duofen:
                btDuofen.setBackground(getDrawable(R.drawable.home_btn4_click));
                Utils.setBTStyle(this, btDuofen, R.style.txt_22_white);
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

    @Override
    public void onItemClick(View view, int position) {
        //跳转到上课页面
        Intent intent = new Intent(this, LessonActivity.class);
        this.startActivity(intent);
    }
}
