package com.example.student.pages.wrongtopic;

import android.graphics.drawable.BitmapDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.baselibrary.base.BaseActivity;
import com.example.student.R;
import com.mikepenz.iconics.IconicsDrawable;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by howard on 2018/3/6.
 * Email 158988127@qq.com
 */

public class EditWrongTopicActivity extends BaseActivity {

    @BindView(R.id.tb_header)
    Toolbar mToolbar;

    @Override
    public void initPages() {
        initToolBar();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_edit_wrong_topic;
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
        dlg.getWindow().setContentView(R.layout.dialog_edit_wrong_topic);

        final TextView informationTv = dlg.getWindow().findViewById(R.id.inform_tv);

        informationTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View contentView = LayoutInflater.from(EditWrongTopicActivity.this).inflate(R.layout.spinner_notification, null, false);
                PopupWindow window = new PopupWindow(contentView, informationTv.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT, true);
                window.setOutsideTouchable(true);
                window.setBackgroundDrawable(new BitmapDrawable());
                window.showAsDropDown(informationTv);
            }
        });







        dlg.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        dlg.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE |
                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

//        dlg.getWindow().

    }
}
