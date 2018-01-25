package com.example.howard.ruiyipai.pages.stastic;

import android.view.View;

import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.base.BaseActivity;

import butterknife.OnClick;

/**
 * Created by howard on 2018/1/23.
 * Email 158988127@qq.com
 */

public class StasticActivity extends BaseActivity {
    @Override
    public void initPages() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_stastic;
    }

    @OnClick({R.id.iv_back})
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.iv_back:
                this.finish();
                break;
        }
    }
}
