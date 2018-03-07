package com.example.student.pages.resource;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.baselibrary.base.BaseActivity;
import com.example.student.R;
import com.example.student.pages.resource.adapter.MyResourceListAdapter;
import com.example.student.pages.resource.adapter.RecordsAdapter;
import com.mikepenz.iconics.IconicsDrawable;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by howard on 2018/1/31.
 * Email 158988127@qq.com
 */

public class ResourceListActivity extends BaseActivity {

    @BindView(R.id.tb_header)
    Toolbar mToolbar;

    @BindView(R.id.fl_select_file)
    View mLeftBtn;

    @BindView(R.id.left_drawer)
    DrawerLayout leftDrawer;

    @BindView(R.id.rv_my_resource_list)
    RecyclerView mResourceList;

    @BindView(R.id.resource_list_container)
    View mResourceListContainer;

    @BindView(R.id.class_record_container)
    View mClassRecordContainer;

    @BindView(R.id.class_record_rv)
    RecyclerView mRecordRv;

    @BindView(R.id.all_subject_spinner)
    TextView mAllSubjectTv;

    @BindView(R.id.duration_spinner)
    TextView mDurationTv;

    @BindView(R.id.teachers_spinner)
    TextView mTeachersTv;

    private boolean isShowRecord = false;

    @Override
    public void initPages() {
        initToolBar();
        initResourceList();
        initClassRecord();
    }

    private void initClassRecord() {

        GridLayoutManager mgr = new GridLayoutManager(this, 4);
        mRecordRv.setLayoutManager(mgr);

        RecordsAdapter adapter = new RecordsAdapter();
        mRecordRv.setAdapter(adapter);

    }

    private void initResourceList() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mResourceList.setLayoutManager(layoutManager);

        MyResourceListAdapter adapter = new MyResourceListAdapter();
        mResourceList.setAdapter(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_resource_list;
    }

    @OnClick({R.id.fl_select_file, R.id.class_record, R.id.all_subject_spinner, R.id.duration_spinner, R.id.teachers_spinner})
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.fl_select_file:
                leftDrawer.openDrawer(Gravity.LEFT);
                break;
            case R.id.class_record:
                if (!isShowRecord) {
                    isShowRecord = true;
                    mResourceListContainer.setVisibility(View.GONE);
                    mClassRecordContainer.setVisibility(View.VISIBLE);

                }
                break;
            case R.id.all_subject_spinner:
                onSpinnerClicked();
                break;
            case R.id.duration_spinner:
                onDurationClicked();
//                onSpinnerClicked();
                break;
            case R.id.teachers_spinner:
                onTeachersClicked();
//                onSpinnerClicked();
                break;
        }
    }

    private void onDurationClicked() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.spinner_duration, null, false);
        PopupWindow window = new PopupWindow(contentView, mDurationTv.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT, true);
        window.setOutsideTouchable(true);
        window.setBackgroundDrawable(new BitmapDrawable());
        window.showAsDropDown(mDurationTv);
    }

    private void onTeachersClicked() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.spinner_teachers, null, false);
        PopupWindow window = new PopupWindow(contentView, mTeachersTv.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT, true);
        window.setOutsideTouchable(true);
        window.setBackgroundDrawable(new BitmapDrawable());
        window.showAsDropDown(mTeachersTv);
    }

    private void onSpinnerClicked() {

        View contentView = LayoutInflater.from(this).inflate(R.layout.spinner_all_subject, null, false);
        PopupWindow window = new PopupWindow(contentView, mAllSubjectTv.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT, true);
        window.setOutsideTouchable(true);
        window.setBackgroundDrawable(new BitmapDrawable());
        window.showAsDropDown(mAllSubjectTv);

    }

    private void initToolBar() {
        IconicsDrawable iResource = new IconicsDrawable(this).icon("fon_816").sizeDp(30)
                .color(ContextCompat.getColor(this, R.color.icon_blue_sky));

        mToolbar.setNavigationIcon(iResource);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
