package com.example.student.pages.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;

import com.example.baselibrary.base.BaseActivity;
import com.example.baselibrary.common.FloatingButton;
import com.example.student.R;
import com.example.student.pages.answer.AnswerActivity;
import com.example.student.pages.calendar.CalendarActivity;
import com.example.student.pages.home.adapter.CalendarAdapter;
import com.example.student.pages.home.adapter.HomeworkAdapter;
import com.example.student.pages.home.adapter.QaAdapter;
import com.example.student.pages.homework.HomeworkListActivity;
import com.example.student.pages.note.NoteActivity;
import com.example.student.pages.resource.ResourceListActivity;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTouch;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.drawer_layout)
    DrawerLayout dl;

    @BindView(R.id.sv_today_homework)
    RecyclerView mHomeworkList;

    @BindView(R.id.sv_qa)
    RecyclerView mQaRv;

    @BindView(R.id.rv_home_calendar)
    RecyclerView mCalendar;

    @BindView(R.id.fb_floatBtn)
    FloatingButton floatintBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initPages() {
        initFloatingBtn();
        initHomeworkList();
        initQaList();
        initCalendar();
    }

    private void initFloatingBtn() {
        floatintBtn.addMainIcon("fon_80f", R.color.white).
                addBtn("fon_810", R.color.color_475361).
                addBtn("fon_811", R.color.color_475361).
                addBtn("fon_813", R.color.color_475361);
    }

    private void initCalendar() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mCalendar.setLayoutManager(layoutManager);

        CalendarAdapter adapter = new CalendarAdapter();
        mCalendar.setAdapter(adapter);
    }

    private void initQaList() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mQaRv.setLayoutManager(layoutManager);

        QaAdapter adapter = new QaAdapter();
        mQaRv.setAdapter(adapter);
    }

    private void initHomeworkList() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mHomeworkList.setLayoutManager(layoutManager);

        HomeworkAdapter adapter = new HomeworkAdapter();

        mHomeworkList.setAdapter(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @OnClick({R.id.iv_home_menu, R.id.homework_more_tv, R.id.home_note_btn, R.id.time,
            R.id.ll_calendar, R.id.home_resource_btn})
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.iv_home_menu:
                dl.openDrawer(Gravity.LEFT);
                break;
            case R.id.homework_more_tv:
                Intent homeworkListActivity = new Intent(this, HomeworkListActivity.class);
                startActivity(homeworkListActivity);
                break;
            case R.id.home_note_btn:
                Intent noteIntent = new Intent(this, NoteActivity.class);
                startActivity(noteIntent);
                break;
            case R.id.time:
                Intent answerIntent = new Intent(this, AnswerActivity.class);
                startActivity(answerIntent);
                break;
            case R.id.ll_calendar:
                Intent calendarIntent = new Intent(this, CalendarActivity.class);
                startActivity(calendarIntent);
                break;
            case R.id.home_resource_btn:
                Intent resourceIntent = new Intent(this, ResourceListActivity.class);
                startActivity(resourceIntent);
                break;
        }

    }
}
