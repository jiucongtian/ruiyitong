package com.example.howard.ruiyipai.pages.lesson;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.base.BaseActivity;
import com.example.howard.ruiyipai.common.Utils;
import com.example.howard.ruiyipai.recyclerAdapter.ClassAdapter;

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

    @BindView(R.id.fl_main_area)
    FrameLayout mainArea;

    @BindView(R.id.iv_main_page_line)
    ImageView mainPageLine;

    @BindView(R.id.iv_students_seats_line)
    ImageView studentsSeatsLine;

    @BindView(R.id.rv_left_lessons)
    RecyclerView selectLessonsList;

    MainPageFragment mainPageFragment;
    StudentsSeatsFragment studentsSeatsFragment;

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

        //创建左侧选课列表
        createSelectLessonList();

        showMainFragment();
    }

    private void createSelectLessonList() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        selectLessonsList.setLayoutManager(layoutManager);

        SelectLessonsAdapter test = new SelectLessonsAdapter(null);
        selectLessonsList.setAdapter(test);
    }

    private void showMainFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        //第一种方式（add），初始化fragment并添加到事务中，如果为null就new一个
        if(mainPageFragment == null){
            mainPageFragment = new MainPageFragment();
            transaction.add(R.id.fl_main_area, mainPageFragment);
        }
        //隐藏所有fragment
        hideFragment(transaction);
        //显示需要显示的fragment
        transaction.show(mainPageFragment);
        transaction.commit();
        mainPageLine.setVisibility(View.VISIBLE);
    }

    private void showStudentsSeatsFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        //第一种方式（add），初始化fragment并添加到事务中，如果为null就new一个
        if(studentsSeatsFragment == null){
            studentsSeatsFragment = new StudentsSeatsFragment();
            transaction.add(R.id.fl_main_area, studentsSeatsFragment);
        }
        //隐藏所有fragment
        hideFragment(transaction);
        //显示需要显示的fragment
        transaction.show(studentsSeatsFragment);
        transaction.commit();
        studentsSeatsLine.setVisibility(View.VISIBLE);
    }

    //隐藏所有的fragment
    private void hideFragment(FragmentTransaction transaction){

        mainPageLine.setVisibility(View.INVISIBLE);
        studentsSeatsLine.setVisibility(View.INVISIBLE);

        if(mainPageFragment != null){
            transaction.hide(mainPageFragment);
        }
        if(studentsSeatsFragment != null){
            transaction.hide(studentsSeatsFragment);
        }
    }

    @OnClick({R.id.iv_unfold, R.id.fl_select_file, R.id.rl_main_page_tab, R.id.rl_students_seats_tab, R.id.iv_back})
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

            case R.id.rl_main_page_tab:
                showMainFragment();
                break;

            case R.id.rl_students_seats_tab:
                showStudentsSeatsFragment();
                break;

            case R.id.iv_back:
                this.finish();
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_lesson;
    }
}
