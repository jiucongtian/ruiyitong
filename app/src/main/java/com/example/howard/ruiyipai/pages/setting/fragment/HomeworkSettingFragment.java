package com.example.howard.ruiyipai.pages.setting.fragment;

import android.widget.SeekBar;

import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by howard on 2018/2/6.
 * Email 158988127@qq.com
 */

public class HomeworkSettingFragment extends BaseFragment {

    @BindView(R.id.seekBar)
    SeekBar mSeekBar;

    @Override
    protected void initPages() {
        initSeekBar();

    }

    private void initSeekBar() {
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int seekProgress = seekBar.getProgress();
                if (seekProgress < 5.6) {
                    seekBar.setProgress(0);
                } else if (5.6 <= seekProgress && seekProgress < 16.7) {
                    seekBar.setProgress(11);
                } else if (16.7 <= seekProgress && seekProgress < 27.8) {
                    seekBar.setProgress(22);
                } else if (27.8 <= seekProgress && seekProgress < 38.9) {
                    seekBar.setProgress(33);
                } else if (38.9 <= seekProgress && seekProgress < 50) {
                    seekBar.setProgress(44);
                } else if (50 <= seekProgress && seekProgress < 61.1) {
                    seekBar.setProgress(56);
                } else if (61.1 <= seekProgress && seekProgress < 72.2) {
                    seekBar.setProgress(67);
                } else if (72.2 <= seekProgress && seekProgress < 83.3) {
                    seekBar.setProgress(78);
                } else if (83.3 <= seekProgress && seekProgress < 94.4) {
                    seekBar.setProgress(89);
                } else {
                    seekBar.setProgress(100);
                }
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_homework_setting;
    }
}
