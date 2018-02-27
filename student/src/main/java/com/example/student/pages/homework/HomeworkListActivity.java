package com.example.student.pages.homework;

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

public class HomeworkListActivity extends BaseActivity {

    @BindView(R.id.tb_header)
    Toolbar mToolbar;
    
    @BindView(R.id.homework_list_rv)
    RecyclerView mHomeworkList;

    @Override
    public void initPages() {
        initToolBar();
        initHomeworkList();
    }

    private void initHomeworkList() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mHomeworkList.setLayoutManager(layoutManager);

        HomeworkListAdapter adapter = new HomeworkListAdapter();
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
}
