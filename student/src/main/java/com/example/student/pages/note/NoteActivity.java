package com.example.student.pages.note;

import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
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

public class NoteActivity extends BaseActivity {

    @BindView(R.id.tb_header)
    Toolbar mToolbar;

    @BindView(R.id.note_switch_container)
    View mSwitchContainer;

    @BindView(R.id.left_drawer)
    DrawerLayout leftDrawer;

    @Override
    public void initPages() {
        initToolBar();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_note;
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

    @OnClick({R.id.note_show_switch, R.id.fl_select_file})
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.note_show_switch:
                if (View.VISIBLE == mSwitchContainer.getVisibility()) {
                    mSwitchContainer.setVisibility(View.GONE);
                } else {
                    mSwitchContainer.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.fl_select_file:
                leftDrawer.openDrawer(Gravity.LEFT);
                break;
        }
    }
}
