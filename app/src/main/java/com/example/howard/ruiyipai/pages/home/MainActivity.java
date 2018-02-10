package com.example.howard.ruiyipai.pages.home;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;

import com.example.baselibrary.base.BaseActivity;
import com.example.howard.ruiyipai.R;

import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;

//import com.example.baselibrary.common.Utils;
import com.example.baselibrary.common.Utils;
import com.example.howard.ruiyipai.pages.calendar.CalendarActivity;
import com.example.howard.ruiyipai.pages.homework.CheckHomeworkActivity;
import com.example.howard.ruiyipai.pages.lesson.LessonActivity;

import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.howard.ruiyipai.pages.resource.ResourceListActivity;
import com.example.howard.ruiyipai.pages.setting.SettingActivity;
import com.example.howard.ruiyipai.recyclerAdapter.ClassAdapter;
import com.mikepenz.iconics.IconicsDrawable;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity implements ClassAdapter.OnItemClickListener, View.OnTouchListener {

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

        initBtn();
    }

    private void initBtn() {
        llwork.setOnTouchListener(this);
        llonline.setOnTouchListener(this);
        llresource.setOnTouchListener(this);
        llcourse.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (v.equals(llwork)) {
                btnClicked(true, llwork, ivWork, "fon_807", tvWorkCN, tvWorkEN, R.mipmap.shadow_blue, R.color.icon_blue);
            } else if (v.equals(llonline)) {
                btnClicked(true, llonline, ivOnline, "fon_805", tvOnlineCN, tvOnlineEN, R.mipmap.shadow_green, R.color.icon_green);

            } else if (v.equals(llresource)) {
                btnClicked(true, llresource, ivResource, "fon_806", tvResourceCN, tvResourceEN, R.mipmap.shadow_gray, R.color.icon_blue_dark);
            } else if (v.equals(llcourse)) {
                btnClicked(true, llcourse, ivCourse, "fon_802", tvCourseCN, tvCourseEN, R.mipmap.shadow_yellow, R.color.icon_yellow);
            }
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            if (v.equals(llwork)) {
                btnClicked(false, llwork, ivWork, "fon_807", tvWorkCN, tvWorkEN, R.mipmap.shadow_blue, R.color.icon_blue);
            } else if (v.equals(llonline)) {
                btnClicked(false, llonline, ivOnline, "fon_805", tvOnlineCN, tvOnlineEN, R.mipmap.shadow_green, R.color.icon_green);
            } else if (v.equals(llresource)) {
                btnClicked(false, llresource, ivResource, "fon_806", tvResourceCN, tvResourceEN, R.mipmap.shadow_gray, R.color.icon_blue_dark);
            } else if (v.equals(llcourse)) {
                btnClicked(false, llcourse, ivCourse, "fon_802", tvCourseCN, tvCourseEN, R.mipmap.shadow_yellow, R.color.icon_yellow);
            }
        }

        return false;
    }

    private void btnClicked(boolean clicked, View container, ImageView icon, String iconName, TextView text1, TextView text2,
                            int bgRes, int intColorRes) {
        IconicsDrawable iconicsDrawable = new IconicsDrawable(this).icon(iconName);
        if (clicked) {
            container.setBackgroundResource(bgRes);
            Utils.setTVStyle(this, text1, R.style.txt_22_white);
            Utils.setTVStyle(this, text2, R.style.txt_14_white);
            iconicsDrawable.colorRes(R.color.white);
        } else {
            container.setBackgroundResource(R.mipmap.shadow_white);
            iconicsDrawable.colorRes(intColorRes);
            Utils.setTVStyle(this, text1, R.style.txt_22_dark);
            Utils.setTVStyle(this, text2, R.style.txt_14_dark);
        }

        icon.setImageDrawable(iconicsDrawable);
    }



    @OnClick({R.id.iv_home_menu, /*R.id.iv_camera, */R.id.ll_course, R.id.ll_online, R.id.ll_resource,
            R.id.ll_work, R.id.bt_yunping, R.id.bt_zuoye, R.id.bt_xiaoyuan, R.id.bt_duofen, 
            R.id.tv_check_version, R.id.ll_settings})
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.iv_home_menu:
                dl.openDrawer(Gravity.LEFT);
                break;
            case R.id.ll_work:
                Intent intent = new Intent(this, CheckHomeworkActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_online:
                break;
            case R.id.ll_resource:

                //test
//                Intent testIntent = new Intent(this, TestActivity.class);
//                this.startActivity(testIntent);
                Intent resourceIntent = new Intent(this, ResourceListActivity.class);
                startActivity(resourceIntent);
                break;
            case R.id.ll_course:
                Intent calendarIntent = new Intent(this, CalendarActivity.class);
                startActivity(calendarIntent);
                break;
            case R.id.bt_yunping:
                showNoDataDialog();
                btYunping.setBackground(getDrawable(R.drawable.home_btn1_click));
                Utils.setBTStyle(this, btYunping, R.style.txt_22_white);
                break;
            case R.id.bt_zuoye:
                showSwitchDialog();
                btZuoye.setBackground(getDrawable(R.drawable.home_btn3_click));
                Utils.setBTStyle(this, btZuoye, R.style.txt_22_white);
                break;
            case R.id.bt_xiaoyuan:
                showCreateFolderDialog();
                btXiaoyuan.setBackground(getDrawable(R.drawable.home_btn2_click));
                Utils.setBTStyle(this, btXiaoyuan, R.style.txt_22_white);
                break;
            case R.id.bt_duofen:
                btDuofen.setBackground(getDrawable(R.drawable.home_btn4_click));
                Utils.setBTStyle(this, btDuofen, R.style.txt_22_white);
                break;
            case R.id.iv_camera:

//                if (openStatus) {
//                    Animation anim = AnimationUtils.loadAnimation(this, R.anim.camera_reverse);
//                    anim.setFillAfter(true);
//                    popLayout.startAnimation(anim);
//                    openStatus = false;
//                } else {
//                    Animation anim = AnimationUtils.loadAnimation(this, R.anim.camera);
//                    anim.setFillAfter(true);
//                    popLayout.startAnimation(anim);
//                    openStatus = true;
//                }

                break;
            case R.id.tv_check_version:
                showVersionDialog();
                break;
            case R.id.ll_settings:
                Intent settingIntent = new Intent(this, SettingActivity.class);
                startActivity(settingIntent);
                break;
        }
    }

    private void showVersionDialog() {

        AlertDialog dlg = new AlertDialog.Builder(this, R.style.AlertDialogStyle).create();
        dlg.show();
        dlg.getWindow().setContentView(R.layout.dialog_check_version);
        dlg.getWindow().findViewById(R.id.btn2).setSelected(true);
    }

    private void showNoDataDialog() {
        AlertDialog dlg = new AlertDialog.Builder(this, R.style.AlertDialogStyle).create();
        dlg.show();
        dlg.getWindow().setContentView(R.layout.dialog_no_data);
    }

    private void showCreateFolderDialog() {
        AlertDialog dlg = new AlertDialog.Builder(this, R.style.AlertDialogStyle).create();
        dlg.show();
        dlg.getWindow().setContentView(R.layout.dialog_create_folder);

        dlg.getWindow().findViewById(R.id.btn2).setSelected(true);


        dlg.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        dlg.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE |
                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

    }

    private void showSwitchDialog() {
        AlertDialog dlg = new AlertDialog.Builder(this, R.style.AlertDialogStyle).create();
        dlg.show();
        dlg.getWindow().setContentView(R.layout.dialog_switch);
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
