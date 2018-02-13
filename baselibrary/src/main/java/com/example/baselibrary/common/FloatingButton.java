package com.example.baselibrary.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;


import com.example.baselibrary.R;

/**
 * Created by howard on 2018/2/10.
 * Email 158988127@qq.com
 */

public class FloatingButton extends RelativeLayout implements View.OnClickListener {

    final static int BASE_WIDTH = 60;
    final static int WIDTH_OF_ITEM = 60;

    ViewGroup popLayout;

    Context context;

    boolean openStatus = false;

    private int mChindCount = 0;

    private int width = 0;

    public FloatingButton(Context context) {
        this(context, null);
    }

    public FloatingButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FloatingButton(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public FloatingButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        initView(context);
    }

    private void initView(Context context) {
        this.context = context;
        View view = View.inflate(context, R.layout.widget_floating_button, this);

        popLayout = view.findViewById(R.id.ll_pop_ground);
        mChindCount = popLayout.getChildCount();
        width = Utils.dip2px(context, BASE_WIDTH + mChindCount * WIDTH_OF_ITEM);
        RelativeLayout.LayoutParams lp = (LayoutParams) popLayout.getLayoutParams();
        lp.width = width;
        lp.rightMargin = -1 * width + 1; //add 1 to avoid dismiss
        popLayout.setLayoutParams(lp);

        view.findViewById(R.id.iv_camera).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.iv_camera) {
            if (openStatus) {
//                Animation anim = AnimationUtils.loadAnimation(context, R.anim.camera_reverse);

                Animation anim = new TranslateAnimation(Utils.dip2px(context, -1 * Utils.dip2px(context, width)), 0, 0,0);
                anim.setDuration(500);


                anim.setFillAfter(true);
                popLayout.startAnimation(anim);
                openStatus = false;
            } else {
//                Animation anim = AnimationUtils.loadAnimation(context, R.anim.camera);
                Animation anim = new TranslateAnimation(0, Utils.dip2px(context, -1 * Utils.dip2px(context, width)), 0,0);
                anim.setDuration(500);

                anim.setFillAfter(true);
                popLayout.startAnimation(anim);
                openStatus = true;
            }
        }
    }

}
