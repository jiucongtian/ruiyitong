package com.example.student.pages.note;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

import com.example.baselibrary.base.BaseActivity;
import com.example.student.R;
import com.mikepenz.iconics.IconicsDrawable;

import butterknife.BindView;
import butterknife.OnClick;

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

    @OnClick({R.id.edit_btn})
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.edit_btn:
                showEditNoteDialog();
                break;
        }

    }

    private void showEditNoteDialog() {
        AlertDialog dlg = new AlertDialog.Builder(this, R.style.AlertDialogStyle).create();
        dlg.show();
        dlg.getWindow().setContentView(R.layout.dialog_edit_note);

        //dlg.getWindow().findViewById(R.id.btn2).setSelected(true);


        dlg.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        dlg.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE |
                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

    }
}
