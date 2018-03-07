package com.example.student.pages.reword;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.baselibrary.base.BaseActivity;
import com.example.student.R;
import com.example.student.pages.note.adapter.CategoryAdapter;
import com.example.student.pages.note.adapter.NoteAdapter;
import com.example.student.pages.reword.adapter.RewordAdapter;
import com.mikepenz.iconics.IconicsDrawable;

import butterknife.BindView;

/**
 * Created by howard on 2018/3/7.
 * Email 158988127@qq.com
 */

public class RewordsActivity extends BaseActivity {

    @BindView(R.id.tb_header)
    Toolbar mToolbar;

    @BindView(R.id.rewords_rv)
    RecyclerView mRewords;

    @Override
    public void initPages() {
        initToolBar();
        initRewordsList();
    }

    private void initRewordsList() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRewords.setLayoutManager(layoutManager);

        RewordAdapter adapter = new RewordAdapter();
        mRewords.setAdapter(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_rewords;
    }

    private void initToolBar() {
        IconicsDrawable iResource = new IconicsDrawable(this).icon("fon_816").sizeDp(30)
                .color(ContextCompat.getColor(this, R.color.white));

        mToolbar.setNavigationIcon(iResource);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
