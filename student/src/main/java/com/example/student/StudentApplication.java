package com.example.student;

import android.app.Application;

import com.example.baselibrary.common.CustomFont;
import com.mikepenz.iconics.Iconics;

//import com.example.howard.ruiyipai.common.CustomFont;

/**
 * Created by howard on 2018/1/13.
 * Email 158988127@qq.com
 */

public class StudentApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //only required if you add a custom or generic font on your own
        Iconics.init(getApplicationContext());

        //register custom fonts like this (or also provide a font definition file)
        Iconics.registerFont(new CustomFont());
    }
}
