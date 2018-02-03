package com.example.howard.ruiyipai.pages.calendar;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;

import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.base.BaseActivity;
import com.example.howard.ruiyipai.pages.calendar.adapter.CalendarAdapter;
import com.example.howard.ruiyipai.pages.calendar.adapter.EventAdapter;
import com.example.howard.ruiyipai.pages.calendar.adapter.PopupCalendarFragmentAdapter;
import com.example.howard.ruiyipai.pages.calendar.fragment.CommentsFragment;
import com.example.howard.ruiyipai.pages.lesson.adapter.SelectLessonsAdapter;
import com.example.howard.ruiyipai.pages.stastic.adapter.StatisticFragmentAdapter;
import com.mikepenz.iconics.IconicsDrawable;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by howard on 2018/2/1.
 * Email 158988127@qq.com
 */

public class CalendarActivity extends BaseActivity implements CalendarAdapter.CalendarListener {

    @BindView(R.id.tb_header)
    Toolbar mToolbar;

    @BindView(R.id.rv_calendar)
    RecyclerView calendarRv;

    @BindView(R.id.rv_event)
    RecyclerView eventRv;

    @Override
    public void initPages() {
        initToolBar();
        initCalendarRv();
        initEventRv();
    }

    private void initEventRv() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        eventRv.setLayoutManager(layoutManager);

        EventAdapter adapter = new EventAdapter();
        eventRv.setAdapter(adapter);
    }

    private void initCalendarRv() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        calendarRv.setLayoutManager(layoutManager);

        CalendarAdapter adapter = new CalendarAdapter(this);
        calendarRv.setAdapter(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_calendar;
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
    public void onClickCalendar(int weekday) {
        popupCalendarDialog();
    }

    private void popupCalendarDialog() {

        Intent intent = new Intent(this, CalendarDialogActivity.class);
        startActivity(intent);

    }
}
