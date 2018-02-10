package com.example.baselibrary.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;


import com.example.baselibrary.R;

/**
 * Created by howard on 2018/2/10.
 * Email 158988127@qq.com
 */

public class FloatingButton extends RelativeLayout implements View.OnClickListener {


//    @BindView(R.id.ll_pop_ground)
    View popLayout;

    Context context;

    boolean openStatus = false;

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
        view.findViewById(R.id.iv_camera).setOnClickListener(this);


//        ButterKnife.bind(this, view);


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.iv_camera) {
            if (openStatus) {
                Animation anim = AnimationUtils.loadAnimation(context, R.anim.camera_reverse);
                anim.setFillAfter(true);
                popLayout.startAnimation(anim);
                openStatus = false;
            } else {
                Animation anim = AnimationUtils.loadAnimation(context, R.anim.camera);
                anim.setFillAfter(true);
                popLayout.startAnimation(anim);
                openStatus = true;
            }
        }
    }

}
