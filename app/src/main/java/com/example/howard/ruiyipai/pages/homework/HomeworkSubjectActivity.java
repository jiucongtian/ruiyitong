package com.example.howard.ruiyipai.pages.homework;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.base.BaseActivity;
import com.example.howard.ruiyipai.common.Utils;
import com.example.howard.ruiyipai.pages.homework.adapter.HomeworkSubjectFragmentAdapter;
import com.example.howard.ruiyipai.pages.homework.adapter.HomeworkSubjectStudentsAdapter;
import com.example.howard.ruiyipai.pages.homework.fragment.HomeworkSubjectFragment;
import com.example.howard.ruiyipai.pages.lesson.LessonActivity;
import com.example.howard.ruiyipai.pages.lesson.adapter.LessonToolsAdapter;
import com.example.howard.ruiyipai.pages.stastic.adapter.StatisticFragmentAdapter;
import com.example.howard.ruiyipai.pages.stastic.fragment.ObjectFragment;
import com.example.howard.ruiyipai.pages.stastic.fragment.SubjectFragment;
import com.mikepenz.iconics.IconicsDrawable;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by howard on 2018/1/29.
 * Email 158988127@qq.com
 */

public class HomeworkSubjectActivity extends BaseActivity implements LessonToolsAdapter.ToolsSelectListener {

    @BindView(R.id.tb_header)
    Toolbar mToolBar;

    @BindView(R.id.vp_main_area)
    ViewPager mMainAreaVp;

    @BindView(R.id.tl_question_index)
    TabLayout mHomeworkIndex;

    @BindView(R.id.rlv_tools)
    RecyclerView lessonTools;

    @BindView(R.id.rv_students)
    RecyclerView mStudents;

    List<Fragment> fragments = new ArrayList<>();

    static final int LINE_HEIGHT_DP = 90;
    List<LessonActivity.TOOL_TYPE> tools = new ArrayList();

    @Override
    public void initPages() {
        initToolBar();
        initFragments();
        initLessonTools();
        initStudents();
    }

    private void initFragments() {
        fragments.add(new HomeworkSubjectFragment());
        fragments.add(new HomeworkSubjectFragment());
        fragments.add(new HomeworkSubjectFragment());
        fragments.add(new HomeworkSubjectFragment());
        fragments.add(new HomeworkSubjectFragment());
        fragments.add(new HomeworkSubjectFragment());
        fragments.add(new HomeworkSubjectFragment());
        fragments.add(new HomeworkSubjectFragment());
        fragments.add(new HomeworkSubjectFragment());
        fragments.add(new HomeworkSubjectFragment());

        HomeworkSubjectFragmentAdapter adapter = new HomeworkSubjectFragmentAdapter(getSupportFragmentManager(), fragments);
        mMainAreaVp.setAdapter(adapter);
        mHomeworkIndex.setupWithViewPager(mMainAreaVp);
    }

    private void initStudents() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mStudents.setLayoutManager(layoutManager);

        HomeworkSubjectStudentsAdapter adapter = new HomeworkSubjectStudentsAdapter();
        mStudents.setAdapter(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_homework_subject;
    }

    private void initToolBar() {
        IconicsDrawable iResource = new IconicsDrawable(this).icon("fon_816").sizeDp(30)
                .color(ContextCompat.getColor(this, R.color.icon_blue_sky));

        mToolBar.setNavigationIcon(iResource);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }

    private void initLessonTools() {
        //TODO: 临时添加工具数据
        tools.add(LessonActivity.TOOL_TYPE.TOOL_THUMBNAIL);
        tools.add(LessonActivity.TOOL_TYPE.TOOL_EXAM);
        tools.add(LessonActivity.TOOL_TYPE.TOOL_SPLIT);
        tools.add(LessonActivity.TOOL_TYPE.TOOL_PROJECT);
        tools.add(LessonActivity.TOOL_TYPE.TOOL_STASTIC);
        tools.add(LessonActivity.TOOL_TYPE.TOOL_BROADCAST);
        tools.add(LessonActivity.TOOL_TYPE.TOOL_PEN);
        tools.add(LessonActivity.TOOL_TYPE.TOOL_LOCK);
        tools.add(LessonActivity.TOOL_TYPE.TOOL_ERASER);
        tools.add(LessonActivity.TOOL_TYPE.TOOL_RETURN);
        tools.add(LessonActivity.TOOL_TYPE.TOOL_ENLARGED);
        tools.add(LessonActivity.TOOL_TYPE.TOOL_SHRINK);
        tools.add(LessonActivity.TOOL_TYPE.TOOL_CLEAN);
        tools.add(LessonActivity.TOOL_TYPE.TOOL_RIGHT);
        tools.add(LessonActivity.TOOL_TYPE.TOOL_COLOR);
        tools.add(LessonActivity.TOOL_TYPE.TOOL_MUTE);
        tools.add(LessonActivity.TOOL_TYPE.TOOL_CLOSE);
        tools.add(LessonActivity.TOOL_TYPE.TOOL_REWARD);
        tools.add(LessonActivity.TOOL_TYPE.TOOL_COLLECTION);
        tools.add(LessonActivity.TOOL_TYPE.TOOL_DESKTOP);
        ViewGroup.LayoutParams layoutParams = lessonTools.getLayoutParams();
        layoutParams.height = Utils.dip2px(this, LINE_HEIGHT_DP) * 2;
        lessonTools.setLayoutParams(layoutParams);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 10, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        lessonTools.setLayoutManager(layoutManager);

        LessonToolsAdapter adapter = new LessonToolsAdapter(this, this, tools);
        lessonTools.setAdapter(adapter);
    }

    @Override
    public void sendQuestions() {

    }

    @Override
    public void switchSplideMode() {

    }

    @Override
    public void stastic() {

    }

    @Override
    public void switchThumbnail() {

    }

    @Override
    public void switchBroadcast() {

    }
}
