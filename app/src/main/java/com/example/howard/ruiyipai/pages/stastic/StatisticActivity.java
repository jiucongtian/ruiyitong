package com.example.howard.ruiyipai.pages.stastic;

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
import com.example.baselibrary.base.BaseActivity;
import com.example.howard.ruiyipai.common.Utils;
import com.example.howard.ruiyipai.pages.lesson.LessonActivity;
import com.example.howard.ruiyipai.pages.lesson.adapter.LessonToolsAdapter;
import com.example.howard.ruiyipai.pages.stastic.adapter.StatisticFragmentAdapter;
import com.example.howard.ruiyipai.pages.stastic.fragment.AllFragment;
import com.example.howard.ruiyipai.pages.stastic.fragment.ObjectFragment;
import com.example.howard.ruiyipai.pages.stastic.fragment.SubjectFragment;
import com.mikepenz.iconics.IconicsDrawable;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by howard on 2018/1/23.
 * Email 158988127@qq.com
 */

public class StatisticActivity extends BaseActivity implements LessonToolsAdapter.ToolsSelectListener {

    static final int LINE_HEIGHT_DP = 90;

    @BindView(R.id.tb_header)
    Toolbar mToolBar;

    @BindView(R.id.vp_main_area)
    ViewPager mMainArea;

    @BindView(R.id.tl_question_index)
    TabLayout mQuestionIndex;

    @BindView(R.id.rlv_tools)
    RecyclerView toolsContainer;

    List<LessonActivity.TOOL_TYPE> tools = new ArrayList();

    List<Fragment> fragments = new ArrayList<>();

    StatisticFragmentAdapter adapter;

    @Override
    public void initPages() {
        initToolBar();
        initTools();

        initFragments();

    }

    private void initFragments() {

        fragments.add(new AllFragment());
        fragments.add(new ObjectFragment());
        fragments.add(new ObjectFragment());
        fragments.add(new SubjectFragment());
        fragments.add(new SubjectFragment());
        fragments.add(new SubjectFragment());
        fragments.add(new SubjectFragment());
        fragments.add(new SubjectFragment());
        fragments.add(new SubjectFragment());
        fragments.add(new SubjectFragment());
        fragments.add(new SubjectFragment());
        fragments.add(new SubjectFragment());
        fragments.add(new SubjectFragment());
        fragments.add(new SubjectFragment());
        fragments.add(new SubjectFragment());

        adapter = new StatisticFragmentAdapter(getSupportFragmentManager(), fragments);
        mMainArea.setAdapter(adapter);
        mQuestionIndex.setupWithViewPager(mMainArea);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_statistic;
    }

    private void initToolBar() {
        IconicsDrawable iResource = new IconicsDrawable(this).icon("fon_816").sizeDp(30)
                .color(ContextCompat.getColor(this, R.color.icon_blue_sky));

        mToolBar.setNavigationIcon(iResource);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SubjectFragment subjectFragment = null;
                if (adapter.getCurrentFragment() instanceof SubjectFragment) {
                    subjectFragment = (SubjectFragment) adapter.getCurrentFragment();
                }

                if (subjectFragment == null || !subjectFragment.onBackClick()) {
                    finish();
                }

            }
        });
    }

    private void initTools() {
        initToolsData();

        ViewGroup.LayoutParams layoutParams = toolsContainer.getLayoutParams();
        layoutParams.height = Utils.dip2px(this, LINE_HEIGHT_DP) * 2;
        toolsContainer.setLayoutParams(layoutParams);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 10, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        toolsContainer.setLayoutManager(layoutManager);

        LessonToolsAdapter adapter = new LessonToolsAdapter(this, this, tools);
        toolsContainer.setAdapter(adapter);
    }

    private void initToolsData() {
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
