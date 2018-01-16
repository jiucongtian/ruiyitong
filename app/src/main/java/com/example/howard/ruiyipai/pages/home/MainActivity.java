package com.example.howard.ruiyipai.pages.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Gravity;
import android.view.View;
import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.base.BaseActivity;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.howard.ruiyipai.recyclerAdapter.ClassAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {

    @BindView(R.id.rlv_class)
    RecyclerView classLv;

    @BindView(R.id.drawer_layout)
    DrawerLayout dl;

    @BindView(R.id.ll_pop_ground)
    View popLayout;

    boolean openStatus = false;

    @Override
    public void initPages() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        classLv.setLayoutManager(layoutManager);

        ClassAdapter test = new ClassAdapter(null);
        classLv.setAdapter(test);
    }

    @OnClick({R.id.iv_home_menu, R.id.iv_camera})
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.iv_home_menu:
                dl.openDrawer(Gravity.LEFT);
                break;
            case R.id.iv_camera:

                if (openStatus) {
                    Animation anim = AnimationUtils.loadAnimation(this, R.anim.camera_reverse);
                    anim.setFillAfter(true);
                    popLayout.startAnimation(anim);
                    openStatus = false;
                } else {
                    Animation anim = AnimationUtils.loadAnimation(this, R.anim.camera);
                    anim.setFillAfter(true);
                    popLayout.startAnimation(anim);
                    openStatus = true;
                }

                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
