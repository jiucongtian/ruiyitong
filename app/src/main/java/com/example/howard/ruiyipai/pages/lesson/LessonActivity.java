package com.example.howard.ruiyipai.pages.lesson;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.base.BaseActivity;
import com.example.howard.ruiyipai.common.Utils;
import com.mikepenz.iconics.IconicsDrawable;

import butterknife.BindView;
import butterknife.OnClick;


public class LessonActivity extends BaseActivity {

    static final int ONE_LINE_NUMBER = 10;
    static final int LINE_HEIGHT_DP = 72;

    @BindView(R.id.left_drawer)
    DrawerLayout leftDrawer;

    @BindView(R.id.rlv_tools)
    RecyclerView lessonTools;

    @BindView(R.id.rl_lesson_tools_container)
    RelativeLayout lessonToolsContainer;

    @BindView(R.id.iv_unfold)
    ImageView folderBtn;

    boolean isFold = true;

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

    @OnClick({R.id.iv_unfold, R.id.fl_select_file})
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.iv_unfold:

                if (isFold) {
                    isFold = false;
                    ViewGroup.LayoutParams lp = lessonToolsContainer.getLayoutParams();
                    lp.height = LINE_HEIGHT_DP * 2;
                    lessonToolsContainer.setLayoutParams(lp);
                    setImageViewTtf(folderBtn, ContextCompat.getColor(this, R.color.font_dark), "fon_81a");
                } else {
                    isFold = true;
                    ViewGroup.LayoutParams lp = lessonToolsContainer.getLayoutParams();
                    lp.height = LINE_HEIGHT_DP;
                    lessonToolsContainer.setLayoutParams(lp);
                    setImageViewTtf(folderBtn, ContextCompat.getColor(this, R.color.font_dark), "fon_819");

                }
                break;

            case R.id.fl_select_file:
                leftDrawer.openDrawer(Gravity.LEFT);
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_lesson;
    }
}
