package com.example.howard.ruiyipai.pages.setting;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.base.BaseActivity;
import com.example.howard.ruiyipai.pages.setting.fragment.HomeworkSettingFragment;
import com.example.howard.ruiyipai.pages.setting.fragment.LoginSettingFragment;
import com.mikepenz.iconics.IconicsDrawable;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by howard on 2018/2/6.
 * Email 158988127@qq.com
 */

public class SettingActivity extends BaseActivity {

    @BindView(R.id.tb_header)
    Toolbar mToolbar;

    @BindView(R.id.fl_content)
    FrameLayout mContent;


    LoginSettingFragment loginSetting;
    HomeworkSettingFragment homeworkSetting;

    Fragment currentFragment = null;

    @BindView(R.id.ll_login_setting)
    View mLogin;

    @BindView(R.id.ll_homework_setting)
    View mHomework;

    @Override
    public void initPages() {
        initToolBar();
        showLoginSetting();
        clickBtn(mLogin);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }


    @OnClick({R.id.ll_login_setting, R.id.ll_homework_setting})
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ll_login_setting:
                showLoginSetting();
                clickBtn(mLogin);
                break;
            case R.id.ll_homework_setting:
                showHomeworkSetting();
                clickBtn(mHomework);
                break;
        }
    }

    private void clickBtn(View v) {
        mLogin.setSelected(false);
        mHomework.setSelected(false);
        v.setSelected(true);
    }


    private void initToolBar() {

        IconicsDrawable iResource = new IconicsDrawable(this).icon("fon_816").sizeDp(30)
                .colorRes(R.color.white);

        mToolbar.setNavigationIcon(iResource);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void showLoginSetting() {
        if (loginSetting == null) {
            loginSetting = new LoginSettingFragment();
        }
        changeFragment(loginSetting);
    }

    private void showHomeworkSetting() {
        if (homeworkSetting == null) {
            homeworkSetting = new HomeworkSettingFragment();
        }
        changeFragment(homeworkSetting);
    }

    private void changeFragment(Fragment toFragment) {

        if (currentFragment != toFragment) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();

            if (currentFragment != null) {
                ft.hide(currentFragment);
            }

            if (toFragment.isAdded() == false) {
                ft.add(R.id.fl_content, toFragment).commit();
            } else {
                ft.show(toFragment).commit();
            }

            currentFragment = toFragment;
        }


    }
}