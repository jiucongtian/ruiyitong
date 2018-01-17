package com.example.howard.ruiyipai.pages.lesson;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.base.BaseActivity;
import com.example.howard.ruiyipai.common.Utils;

import butterknife.BindView;


public class LessonActivity extends BaseActivity {

    static final int ONE_LINE_NUMBER = 10;
    static final int LINE_HEIGHT_DP = 72;

    @BindView(R.id.rlv_tools)
    RecyclerView lessonTools;

    @Override
    public void initPages() {
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

        LessonToolsAdapter adapter = new LessonToolsAdapter(null);
        lessonTools.setAdapter(adapter);

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
