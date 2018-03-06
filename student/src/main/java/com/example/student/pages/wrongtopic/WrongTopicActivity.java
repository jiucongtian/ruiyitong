package com.example.student.pages.wrongtopic;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.baselibrary.base.BaseActivity;
import com.example.student.R;
import com.example.student.pages.note.EditNoteActivity;
import com.example.student.pages.note.adapter.CategoryAdapter;
import com.example.student.pages.note.adapter.NoteAdapter;
import com.example.student.pages.wrongtopic.adapter.WrongTopicAdapter;
import com.example.student.pages.wrongtopic.adapter.WrongTopicCategoryAdapter;
import com.mikepenz.iconics.IconicsDrawable;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by howard on 2018/2/28.
 * Email 158988127@qq.com
 */

public class WrongTopicActivity extends BaseActivity implements WrongTopicAdapter.NoteClickListener {

    @BindView(R.id.tb_header)
    Toolbar mToolbar;

    @BindView(R.id.left_drawer)
    DrawerLayout leftDrawer;

    @BindView(R.id.rv_homework_list)
    RecyclerView mNoteList;

    @BindView(R.id.rv_category)
    RecyclerView mCategory;

    @Override
    public void initPages() {
        initToolBar();
        initNoteList();
        initCategory();
    }

    private void initCategory() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mCategory.setLayoutManager(layoutManager);

        WrongTopicCategoryAdapter adapter = new WrongTopicCategoryAdapter();
        mCategory.setAdapter(adapter);
    }

    private void initNoteList() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mNoteList.setLayoutManager(layoutManager);

        WrongTopicAdapter adapter = new WrongTopicAdapter(this);
        mNoteList.setAdapter(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_wrong_topic;
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

    @OnClick({R.id.fl_select_file, R.id.note_label_filter_container})
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.fl_select_file:
                leftDrawer.openDrawer(Gravity.LEFT);
                break;
            case R.id.note_label_filter_container:
                showVersionDialog();
                break;
        }
    }


    private void showVersionDialog() {

        AlertDialog dlg = new AlertDialog.Builder(this, R.style.AlertDialogStyle).create();
        dlg.show();
        dlg.getWindow().setContentView(R.layout.dialog_wrong_topic_filter);
        dlg.getWindow().findViewById(R.id.btn2).setSelected(true);
    }

    @Override
    public void onNoteClicked() {
        Intent intent = new Intent(this, EditWrongTopicActivity.class);
        startActivity(intent);
    }
}
