package com.example.student.pages.note;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.baselibrary.base.BaseActivity;
import com.example.student.R;
import com.mikepenz.iconics.IconicsDrawable;

import butterknife.BindView;

/**
 * Created by howard on 2018/3/6.
 * Email 158988127@qq.com
 */

public class EditNoteActivity extends BaseActivity {

    @BindView(R.id.tb_header)
    Toolbar mToolbar;

    @Override
    public void initPages() {
        initToolBar();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_edit_note;
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
