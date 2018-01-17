package com.example.howard.ruiyipai.base;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.context.IconicsLayoutInflater2;

import butterknife.ButterKnife;

/**
 * Created by howard on 2018/1/13.
 * Email zh@longhuapuxin.com
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        LayoutInflaterCompat.setFactory2(getLayoutInflater(), new IconicsLayoutInflater2(getDelegate()));
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initPages();
    }

    public abstract void initPages();
    protected abstract int getLayoutId();

    protected void setImageViewTtf(ImageView view, int color, String ttfName) {
        IconicsDrawable tt =new IconicsDrawable(this).icon(ttfName)
                .color(color);
        view.setImageDrawable(tt);
    }

}
