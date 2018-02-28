package com.example.student.pages.homework;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.baselibrary.base.BaseActivity;
import com.example.student.R;
import com.example.student.pages.home.adapter.QaAdapter;
import com.example.student.pages.homework.adapter.HomeworkListAdapter;
import com.mikepenz.iconics.IconicsDrawable;

import butterknife.BindView;

/**
 * Created by howard on 2018/2/27.
 * Email 158988127@qq.com
 */

public class HomeworkListActivity extends BaseActivity implements HomeworkListAdapter.HomeworkCallback {

    @BindView(R.id.tb_header)
    Toolbar mToolbar;
    
    @BindView(R.id.homework_list_rv)
    RecyclerView mHomeworkList;

    @BindView(R.id.tl_question_index)
    TabLayout mSubjectTabLayout;

    @Override
    public void initPages() {
        initToolBar();
        initTabLayout();
        initHomeworkList();
    }

    private void initTabLayout() {
        mSubjectTabLayout.addTab(mSubjectTabLayout.newTab());
        mSubjectTabLayout.addTab(mSubjectTabLayout.newTab());
        mSubjectTabLayout.addTab(mSubjectTabLayout.newTab());
        mSubjectTabLayout.addTab(mSubjectTabLayout.newTab());
        mSubjectTabLayout.addTab(mSubjectTabLayout.newTab());
        mSubjectTabLayout.addTab(mSubjectTabLayout.newTab());
        mSubjectTabLayout.addTab(mSubjectTabLayout.newTab());
        mSubjectTabLayout.addTab(mSubjectTabLayout.newTab());
        mSubjectTabLayout.addTab(mSubjectTabLayout.newTab());
        mSubjectTabLayout.addTab(mSubjectTabLayout.newTab());

        int count = mSubjectTabLayout.getTabCount();


        for (int i = 0; i < count; i++) {
            TabLayout.Tab tab = mSubjectTabLayout.getTabAt(i);//获得每一个tab
            tab.setCustomView(R.layout.item_homework_tab);//给每一个tab设置view
//            if (i == 0) {
//                // 设置第一个tab的TextView是被选择的样式
//                tab.getCustomView().findViewById(R.id.tab_text).setSelected(true);//第一个tab被选中
//            }
//            TextView textView = (TextView) tab.getCustomView().findViewById(R.id.tab_text);
//            textView.setText(titles[i]);//设置tab上的文字
        }

    }

    private void initHomeworkList() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mHomeworkList.setLayoutManager(layoutManager);

        HomeworkListAdapter adapter = new HomeworkListAdapter(this);
        mHomeworkList.setAdapter(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_homework_list;
    }

    private void initToolBar() {
        IconicsDrawable iResource = new IconicsDrawable(this).icon("fon_816").sizeDp(30)
                .color(ContextCompat.getColor(this, R.color.icon_blue_sky));

        mToolbar.setNavigationIcon(iResource);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onHomeworkClicked() {
        Intent intent = new Intent(this, HomeworkActivity.class);
        startActivity(intent);
    }
}
