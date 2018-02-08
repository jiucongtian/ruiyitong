package com.example.howard.ruiyipai.pages.setting.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.howard.ruiyipai.R;
import com.example.baselibrary.base.BaseFragment;
import com.example.howard.ruiyipai.common.Utils;
import com.example.howard.ruiyipai.pages.lesson.LessonActivity;
import com.example.howard.ruiyipai.pages.lesson.adapter.LessonToolsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by howard on 2018/2/6.
 * Email 158988127@qq.com
 */

public class ToolsSettingFragment extends BaseFragment implements LessonToolsAdapter.ToolsSelectListener {

    @BindView(R.id.tools_setting_first)
    public View firstPage;

    @BindView(R.id.tools_setting_second)
    public View secondPage;

    @BindView(R.id.rv_all_tools)
    RecyclerView mTools;

    List<LessonActivity.TOOL_TYPE> tools = new ArrayList();

    @Override
    protected void initPages() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_tools_setting;
    }

    @OnClick({R.id.rl_lesson_tools, R.id.rl_big_screen_tools, R.id.iv_back})
    public void onClick(View v) {

        int id = v.getId();
        switch (id) {
            case R.id.rl_lesson_tools:
                firstPage.setVisibility(View.GONE);
                secondPage.setVisibility(View.VISIBLE);
                initLessonTools();
                break;
            case R.id.rl_big_screen_tools:
                firstPage.setVisibility(View.GONE);
                secondPage.setVisibility(View.VISIBLE);
                initLessonTools();
                break;
            case R.id.iv_back:
                firstPage.setVisibility(View.VISIBLE);
                secondPage.setVisibility(View.GONE);
                break;
        }
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

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 6, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        mTools.setLayoutManager(layoutManager);

        LessonToolsAdapter adapter = new LessonToolsAdapter(getContext(), this, tools);
        mTools.setAdapter(adapter);
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
