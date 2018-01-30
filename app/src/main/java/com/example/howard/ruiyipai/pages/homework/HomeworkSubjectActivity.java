package com.example.howard.ruiyipai.pages.homework;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.base.BaseActivity;
import com.example.howard.ruiyipai.pages.homework.adapter.HomeworkSubjectFragmentAdapter;
import com.example.howard.ruiyipai.pages.homework.fragment.HomeworkSubjectFragment;
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

public class HomeworkSubjectActivity extends BaseActivity {

    @BindView(R.id.tb_header)
    Toolbar mToolBar;

    @BindView(R.id.vp_main_area)
    ViewPager mMainAreaVp;

    @BindView(R.id.tl_question_index)
    TabLayout mHomeworkIndex;

    List<Fragment> fragments = new ArrayList<>();

    @Override
    public void initPages() {
        initToolBar();
        initFragments();
    }

    private void initFragments() {
        fragments.add(new HomeworkSubjectFragment());
        fragments.add(new HomeworkSubjectFragment());
        fragments.add(new HomeworkSubjectFragment());
        fragments.add(new HomeworkSubjectFragment());
        fragments.add(new HomeworkSubjectFragment());

        HomeworkSubjectFragmentAdapter adapter = new HomeworkSubjectFragmentAdapter(getSupportFragmentManager(), fragments);
        mMainAreaVp.setAdapter(adapter);
        mHomeworkIndex.setupWithViewPager(mMainAreaVp);
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
}
