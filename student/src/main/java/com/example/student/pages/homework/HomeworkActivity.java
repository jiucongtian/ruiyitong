package com.example.student.pages.homework;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.baselibrary.base.BaseActivity;
import com.example.student.R;
import com.mikepenz.iconics.IconicsDrawable;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by howard on 2018/2/28.
 * Email 158988127@qq.com
 */

public class HomeworkActivity extends BaseActivity {

    @BindView(R.id.tb_header)
    Toolbar mToolbar;

    @BindView(R.id.homework_more_container)
    View mMoreContainer;

    @BindView(R.id.homework_res_container)
    View mResContainer;

    @Override
    public void initPages() {
        initToolBar();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_homework;
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

    @OnClick({R.id.homework_show_res_iv, R.id.homework_show_more})
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.homework_show_res_iv:
                if (View.VISIBLE == mResContainer.getVisibility()) {
                    mResContainer.setVisibility(View.GONE);
                } else {
                    mResContainer.setVisibility(View.VISIBLE);
                }

                break;
            case R.id.homework_show_more:
                if (View.VISIBLE == mMoreContainer.getVisibility()) {
                    mMoreContainer.setVisibility(View.GONE);
                } else {
                    mMoreContainer.setVisibility(View.VISIBLE);
                }
                break;
        }
    }
}
