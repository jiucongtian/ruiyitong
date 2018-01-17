package com.example.howard.ruiyipai.common;

import android.content.Context;
import android.os.Build;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by howard on 2018/1/17.
 * Email zh@longhuapuxin.com
 */

public class Utils {
    /**
     * dp2px
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px2dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    public static void setTVStyle(Context context, TextView tv, int resid){
        if (Build.VERSION.SDK_INT < 23) {
            tv.setTextAppearance(context,resid);
        } else {
            tv.setTextAppearance(resid);
        }
    }
    public static void setBTStyle(Context context, Button bt, int resid){
        if (Build.VERSION.SDK_INT < 23) {
            bt.setTextAppearance(context,resid);
        } else {
            bt.setTextAppearance(resid);
        }
    }
}
