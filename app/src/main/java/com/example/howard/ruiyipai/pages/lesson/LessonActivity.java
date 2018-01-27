package com.example.howard.ruiyipai.pages.lesson;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.base.BaseActivity;
import com.example.howard.ruiyipai.common.Utils;
import com.example.howard.ruiyipai.pages.lesson.adapter.FragmentAdapter;
import com.example.howard.ruiyipai.pages.lesson.adapter.LessonThumbnailAdapter;
import com.example.howard.ruiyipai.pages.lesson.adapter.LessonToolsAdapter;
import com.example.howard.ruiyipai.pages.lesson.adapter.SelectLessonsAdapter;
import com.example.howard.ruiyipai.pages.questions.QuestionsActivity;
import com.example.howard.ruiyipai.pages.stastic.StatisticActivity;
import com.mikepenz.iconics.IconicsDrawable;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.howard.ruiyipai.pages.lesson.adapter.LessonThumbnailAdapter.ITEM_TYPE_PPT;
import static com.example.howard.ruiyipai.pages.lesson.adapter.LessonThumbnailAdapter.ITEM_TYPE_WORD;


public class LessonActivity extends BaseActivity implements LessonToolsAdapter.ToolsSelectListener {



    public enum THUMBNAIL_TYPE {
        TYPE_PPT,
        ITEM_WORD
    }

    public enum TOOL_TYPE {
        TOOL_THUMBNAIL,
        TOOL_PROJECT,
        TOOL_SPLIDE,
        TOOL_EXAM,
        TOOL_STASTIC,
        TOOL_BROADCAST,
        TOOL_PEN,
        TOOL_LOCK,
        TOOL_ERASER,
        TOOL_RETURN,
        TOOL_ENLARGED,
        TOOL_SHRINK,
        TOOL_CLEAN,
        TOOL_RIGHT,
        TOOL_COLOR,
        TOOL_MUTE,
        TOOL_CLOSE,
        TOOL_REWARD,
        TOOL_COLLECTION,
        TOOL_DESKTOP
    }

    List<TOOL_TYPE> tools = new ArrayList();

    static final int ONE_LINE_NUMBER = 10;
    static final int LINE_HEIGHT_DP = 90;


    @BindView(R.id.left_drawer)
    DrawerLayout leftDrawer;

    @BindView(R.id.rlv_tools)
    RecyclerView lessonTools;

    @BindView(R.id.rv_lesson_thumbnail)
    RecyclerView lessonThumbnail;

    @BindView(R.id.rl_lesson_thumbnail_container)
    RelativeLayout lessonThumbnailContainer;

    @BindView(R.id.rl_lesson_tools_container)
    RelativeLayout lessonToolsContainer;

    @BindView(R.id.iv_unfold)
    ImageView folderBtn;

    @BindView(R.id.rv_left_lessons)
    RecyclerView selectLessonsList;

    @BindView(R.id.ll_lesson_page)
    LinearLayout leftLessonContainer;

    @BindView(R.id.ll_splite_page)
    LinearLayout leftSpliteContainer;

    @BindView(R.id.fl_splide_mode_container)
    FrameLayout splide_mode_container;

    @BindView(R.id.tv_splide_list)
    TextView splideTab;

    @BindView(R.id.tv_resource_list)
    TextView resourceTab;

    @BindView(R.id.tb_header)
    Toolbar mToolbar;

    @BindView(R.id.tl_switch_work_area)
    TabLayout mTabLayout;

    @BindView(R.id.vp_main)
    ViewPager mMain;

    @BindView(R.id.fl_select_file)
    View mLeftBtn;

    @BindView(R.id.iv_show_all_tools)
    View mShowAllBtn;

    SplideListFragment splideListFragment;
    ResourceListFragment resourceListFragment;

    List<Fragment> mFragments = new ArrayList<>();

    boolean isFold = true;

    THUMBNAIL_TYPE thumbnailType = THUMBNAIL_TYPE.TYPE_PPT;


    boolean splideMode = true;
    boolean thumbnail = true;

    @Override
    public void initPages() {
        //TODO: 临时添加工具数据
        tools.add(TOOL_TYPE.TOOL_THUMBNAIL);
        tools.add(TOOL_TYPE.TOOL_EXAM);
        tools.add(TOOL_TYPE.TOOL_SPLIDE);
        tools.add(TOOL_TYPE.TOOL_PROJECT);
        tools.add(TOOL_TYPE.TOOL_STASTIC);
        tools.add(TOOL_TYPE.TOOL_BROADCAST);
        tools.add(TOOL_TYPE.TOOL_PEN);
        tools.add(TOOL_TYPE.TOOL_LOCK);
        tools.add(TOOL_TYPE.TOOL_ERASER);
        tools.add(TOOL_TYPE.TOOL_RETURN);
        tools.add(TOOL_TYPE.TOOL_ENLARGED);
        tools.add(TOOL_TYPE.TOOL_SHRINK);
        tools.add(TOOL_TYPE.TOOL_CLEAN);
        tools.add(TOOL_TYPE.TOOL_RIGHT);
        tools.add(TOOL_TYPE.TOOL_COLOR);
        tools.add(TOOL_TYPE.TOOL_MUTE);
        tools.add(TOOL_TYPE.TOOL_CLOSE);
        tools.add(TOOL_TYPE.TOOL_REWARD);
        tools.add(TOOL_TYPE.TOOL_COLLECTION);
        tools.add(TOOL_TYPE.TOOL_DESKTOP);

        initToolBar();

        initViewPages();

        initLessonTools();

        initLessonThumbnail();

        //创建左侧选课列表
        createSelectLessonList();

        //必须放在最后
        setThumbnailType(THUMBNAIL_TYPE.TYPE_PPT);
//        setThumbnailType(THUMBNAIL_TYPE.ITEM_WORD);
    }

    private void initViewPages() {

        mFragments.add(new MainPageFragment());
        mFragments.add(new StudentsSeatsFragment());

        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(),mFragments);
        mMain.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mMain);


        for (int i = 0; i < adapter.getCount(); i++) {

            TabLayout.Tab tab = mTabLayout.getTabAt(i);//获得每一个tab
            tab.setCustomView(R.layout.tab_item_lesson);//给每一个tab设置view
            TextView textView = tab.getCustomView().findViewById(R.id.tv_tab_name);
            textView.setText("大屏幕");//设置tab上的文字

            ImageView imageView = tab.getCustomView().findViewById(R.id.iv_tab_img);
            IconicsDrawable iResource = new IconicsDrawable(this).icon("fon_806")
                    .color(Color.WHITE);
            imageView.setImageDrawable(iResource);
        }

    }

    private void initToolBar() {
        IconicsDrawable iResource = new IconicsDrawable(this).icon("fon_816").sizeDp(30)
                .color(Color.WHITE);

        mToolbar.setNavigationIcon(iResource);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initLessonThumbnail() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        lessonThumbnail.setLayoutManager(layoutManager);

        LessonThumbnailAdapter adapter = new LessonThumbnailAdapter(null);
        lessonThumbnail.setAdapter(adapter);
    }

    private void setThumbnailType(THUMBNAIL_TYPE type) {
        thumbnailType = type;

        if (thumbnailType == THUMBNAIL_TYPE.TYPE_PPT) {
            ViewGroup.LayoutParams lp = lessonThumbnailContainer.getLayoutParams();
            lp.height = Utils.dip2px(this, 128);
            lessonThumbnailContainer.setLayoutParams(lp);

            ((LessonThumbnailAdapter)lessonThumbnail.getAdapter()).setThumbnailType(ITEM_TYPE_PPT);
        } else if (thumbnailType == THUMBNAIL_TYPE.ITEM_WORD) {
            ViewGroup.LayoutParams lp = lessonThumbnailContainer.getLayoutParams();
            lp.height = Utils.dip2px(this, 176);
            lessonThumbnailContainer.setLayoutParams(lp);
            ((LessonThumbnailAdapter)lessonThumbnail.getAdapter()).setThumbnailType(ITEM_TYPE_WORD);
        }

    }

    private void initLessonTools() {
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

    private void createSelectLessonList() {

        leftLessonContainer.setVisibility(View.VISIBLE);
        leftSpliteContainer.setVisibility(View.GONE);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        selectLessonsList.setLayoutManager(layoutManager);

        SelectLessonsAdapter test = new SelectLessonsAdapter(null);
        selectLessonsList.setAdapter(test);
        updateDrawerLayoutMode();

    }

    private void showSplideListFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        //第一种方式（add），初始化fragment并添加到事务中，如果为null就new一个
        if(splideListFragment == null){
            splideListFragment = new SplideListFragment();
            transaction.add(R.id.fl_splide_mode_container, splideListFragment);
        }
        //隐藏资源fragment
        if(resourceListFragment != null){
            transaction.hide(resourceListFragment);
        }
        //显示需要显示的fragment
        transaction.show(splideListFragment);
        transaction.commit();
    }

    private void showResourceListFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        //第一种方式（add），初始化fragment并添加到事务中，如果为null就new一个
        if(resourceListFragment == null){
            resourceListFragment = new ResourceListFragment();
            transaction.add(R.id.fl_splide_mode_container, resourceListFragment);
        }
        //隐藏资源fragment
        if(splideListFragment != null){
            transaction.hide(splideListFragment);
        }
        //显示需要显示的fragment
        transaction.show(resourceListFragment);
        transaction.commit();
    }


    @OnClick({R.id.iv_unfold, R.id.fl_select_file, R.id.iv_full_screen, R.id.tv_splide_list,
            R.id.tv_resource_list, R.id.iv_show_all_tools})
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.iv_unfold:

                if (isFold) {
                    isFold = false;
                    ViewGroup.LayoutParams lp = lessonToolsContainer.getLayoutParams();
                    lp.height = LINE_HEIGHT_DP * 2 + 16;
                    lessonToolsContainer.setLayoutParams(lp);
                    setImageViewTtf(folderBtn, ContextCompat.getColor(this, R.color.font_white), "fon_81a");
                } else {
                    isFold = true;
                    ViewGroup.LayoutParams lp = lessonToolsContainer.getLayoutParams();
                    lp.height = LINE_HEIGHT_DP + 16;
                    lessonToolsContainer.setLayoutParams(lp);
                    setImageViewTtf(folderBtn, ContextCompat.getColor(this, R.color.font_white), "fon_819");

                }
                break;

            case R.id.fl_select_file:
                leftDrawer.openDrawer(Gravity.LEFT);
                break;

            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_splide_list:
                Utils.setTVStyle(this, splideTab, R.style.txt_16_black_tab);
                splideTab.setBackgroundResource(R.color.color_bdfbfa);
                Utils.setTVStyle(this, resourceTab, R.style.txt_16_white_tab);
                resourceTab.setBackgroundResource(R.color.light_blue_deep);
                showSplideListFragment();
                break;
            case R.id.tv_resource_list:
                Utils.setTVStyle(this, splideTab, R.style.txt_16_white_tab);
                splideTab.setBackgroundResource(R.color.light_blue_deep);
                Utils.setTVStyle(this, resourceTab, R.style.txt_16_black_tab);
                resourceTab.setBackgroundResource(R.color.color_bdfbfa);
                showResourceListFragment();
                break;
            case R.id.iv_full_screen:
                hidenTools(true);
                break;
            case R.id.iv_show_all_tools:
                hidenTools(false);
                break;
        }
    }

    private void hidenTools(boolean hiden) {
        if (hiden) {
            mToolbar.setVisibility(View.GONE);
            mLeftBtn.setVisibility(View.GONE);
            lessonThumbnailContainer.setVisibility(View.GONE);
            lessonToolsContainer.setVisibility(View.GONE);
            mShowAllBtn.setVisibility(View.VISIBLE);
        } else {
            mToolbar.setVisibility(View.VISIBLE);
            mLeftBtn.setVisibility(View.VISIBLE);
            updatethumbnail();
            lessonToolsContainer.setVisibility(View.VISIBLE);
            mShowAllBtn.setVisibility(View.GONE);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_lesson;
    }

    @Override
    public void sendQuestions() {

        Intent intent = new Intent(this, QuestionsActivity.class);
        startActivity(intent);
    }

    @Override
    public void switchSplideMode() {

//        //背景变暗
//        WindowManager.LayoutParams lp = getWindow().getAttributes();
//        lp.alpha = 0.6f;
//        getWindow().setAttributes(lp);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

//        //恢复背景
//        WindowManager.LayoutParams lp = getWindow().getAttributes();
//        lp.alpha = 1.0f;
//        getWindow().setAttributes(lp);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);


        splideMode = !splideMode;
        updateDrawerLayoutMode();
    }

    @Override
    public void stastic() {
        Intent intent = new Intent(this, StatisticActivity.class);
        startActivity(intent);
    }

    @Override
    public void switchThumbnail() {
        thumbnail = !thumbnail;
        updatethumbnail();
    }

    private void updatethumbnail(){
        if(thumbnail)
            lessonThumbnailContainer.setVisibility(View.VISIBLE);
        else
            lessonThumbnailContainer.setVisibility(View.GONE);
    }
    private void updateDrawerLayoutMode() {
        if (splideMode) {
            showSplideListFragment();
            leftLessonContainer.setVisibility(View.GONE);
            leftSpliteContainer.setVisibility(View.VISIBLE);
        } else {
            leftLessonContainer.setVisibility(View.VISIBLE);
            leftSpliteContainer.setVisibility(View.GONE);
        }
    }

}
