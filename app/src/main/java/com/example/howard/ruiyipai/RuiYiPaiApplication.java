package com.example.howard.ruiyipai;

import android.app.Application;

import com.example.howard.ruiyipai.common.CustomFont;
import com.mikepenz.iconics.Iconics;

/**
 * Created by howard on 2018/1/13.
 * Email zh@longhuapuxin.com
 */

public class RuiYiPaiApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //only required if you add a custom or generic font on your own
        Iconics.init(getApplicationContext());

        //register custom fonts like this (or also provide a font definition file)
        Iconics.registerFont(new CustomFont());
    }
}
