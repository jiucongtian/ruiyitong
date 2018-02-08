package com.example.howard.ruiyipai.pages.resource;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;

import com.example.howard.ruiyipai.R;
import com.example.baselibrary.base.BaseActivity;
import com.example.howard.ruiyipai.pages.resource.adapter.MyResourceListAdapter;
import com.mikepenz.iconics.IconicsDrawable;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by howard on 2018/1/31.
 * Email 158988127@qq.com
 */

public class ResourceListActivity extends BaseActivity {

    @BindView(R.id.tb_header)
    Toolbar mToolbar;

    @BindView(R.id.fl_select_file)
    View mLeftBtn;

    @BindView(R.id.left_drawer)
    DrawerLayout leftDrawer;

    @BindView(R.id.rv_my_resource_list)
    RecyclerView mResourceList;

    @Override
    public void initPages() {
        initToolBar();
        initResourceList();
    }

    private void initResourceList() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mResourceList.setLayoutManager(layoutManager);

        MyResourceListAdapter adapter = new MyResourceListAdapter();
        mResourceList.setAdapter(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_resource_list;
    }

    @OnClick({R.id.fl_select_file})
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.fl_select_file:
                leftDrawer.openDrawer(Gravity.LEFT);
                break;
        }
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
