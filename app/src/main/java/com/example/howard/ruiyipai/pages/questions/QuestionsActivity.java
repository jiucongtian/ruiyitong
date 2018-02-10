package com.example.howard.ruiyipai.pages.questions;

import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;



import com.example.howard.ruiyipai.R;
import com.example.baselibrary.base.BaseActivity;
import com.example.baselibrary.common.Utils;
import com.example.howard.ruiyipai.pages.questions.bean.StudentSelectionBean;
import com.mikepenz.iconics.IconicsDrawable;
import com.weigan.loopview.LoopView;
import com.weigan.loopview.OnItemSelectedListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.howard.ruiyipai.pages.questions.bean.StudentSelectionBean.SELECTION_TYPE.TYPE_CLASS;
import static com.example.howard.ruiyipai.pages.questions.bean.StudentSelectionBean.SELECTION_TYPE.TYPE_STUDENT;
import static com.example.howard.ruiyipai.pages.questions.bean.StudentSelectionBean.SELECTION_TYPE.TYPE_TEAM;


/**
 * Created by howard on 2018/1/20.
 * Email 158988127@qq.com
 */

public class QuestionsActivity extends BaseActivity {

    @BindView(R.id.lv_single_questions_number)
    LoopView mSingleQuestionNumber;

    @BindView(R.id.lv_single_selection_number)
    LoopView mSingleSelectionNumber;

    @BindView(R.id.lv_multi_questions_number)
    LoopView mMultiQuestionNumber;

    @BindView(R.id.lv_multi_selection_number)
    LoopView mMultiSelectionNumber;

    @BindView(R.id.lv_judge_questions_number)
    LoopView mJudgeNumber;

    @BindView(R.id.lv_subject_questions_number)
    LoopView mSubjectNumber;

    @BindView(R.id.lv_questions_duration)
    LoopView mQuestionDuration;



    @BindView(R.id.rv_student_selector)
    RecyclerView mStudentSelector;

    @BindView(R.id.tb_header)
    Toolbar mToolBar;


//    SoundPool mSoundPool;
//
//    private HashMap<Integer, Integer> soundID = new HashMap<Integer, Integer>();

    @Override
    public void initPages() {
//        try {
//            initSoundPool();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        initToolBar();
        initStudentsList();

        initSingleQuestionsNumber();
        initSingleSelectionNumber();
        initMultiQuestionsNumber();
        initMultiSelectionNumber();
        initJudgeQuestionsNumber();
        initSubjectQuestionsNumber();
        initQuestionDuration();

    }



    private void initQuestionDuration() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));
        }

        //设置是否循环播放，加这句为不循环，注释掉为循环
        mQuestionDuration.setNotLoop();
        //设置原始数据
        mQuestionDuration.setItems(list);
        //设置初始位置
        mQuestionDuration.setInitPosition(0);
        //设置字体大小
        mQuestionDuration.setTextSize(20);
        mQuestionDuration.setListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                playSound();
            }
        });
    }

    private void initSubjectQuestionsNumber() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));
        }

        //设置是否循环播放，加这句为不循环，注释掉为循环
        mSubjectNumber.setNotLoop();
        //设置原始数据
        mSubjectNumber.setItems(list);
        //设置初始位置
        mSubjectNumber.setInitPosition(0);
        //设置字体大小
        mSubjectNumber.setTextSize(20);
        mSubjectNumber.setListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                playSound();
            }
        });
    }

    private void initJudgeQuestionsNumber() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));
        }

        //设置是否循环播放，加这句为不循环，注释掉为循环
        mJudgeNumber.setNotLoop();
        //设置原始数据
        mJudgeNumber.setItems(list);
        //设置初始位置
        mJudgeNumber.setInitPosition(0);
        //设置字体大小
        mJudgeNumber.setTextSize(20);
        mJudgeNumber.setListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                playSound();
            }
        });
    }

    private void initMultiSelectionNumber() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }

        //设置是否循环播放，加这句为不循环，注释掉为循环
        mMultiSelectionNumber.setNotLoop();
        //设置原始数据
        mMultiSelectionNumber.setItems(list);
        //设置初始位置
        mMultiSelectionNumber.setInitPosition(4);
        //设置字体大小
        mMultiSelectionNumber.setTextSize(20);
        mMultiSelectionNumber.setListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                playSound();
            }
        });
    }

    private void initStudentsList() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mStudentSelector.setLayoutManager(layoutManager);

        List<StudentSelectionBean> selections = new ArrayList<>();
        selections.add(new StudentSelectionBean("高二年级（1）班", TYPE_CLASS));
        selections.add(new StudentSelectionBean("第一组", TYPE_TEAM));
        selections.add(new StudentSelectionBean("第二组", TYPE_TEAM));
        selections.add(new StudentSelectionBean("张三", TYPE_STUDENT));
        selections.add(new StudentSelectionBean("张四", TYPE_STUDENT));
        selections.add(new StudentSelectionBean("第三组", TYPE_TEAM));
        selections.add(new StudentSelectionBean("李四", TYPE_STUDENT));
        selections.add(new StudentSelectionBean("李五", TYPE_STUDENT));
        selections.add(new StudentSelectionBean("张哈", TYPE_STUDENT));
        selections.add(new StudentSelectionBean("张八", TYPE_STUDENT));

        questionSelectorAdapter adapter = new questionSelectorAdapter(selections);
        mStudentSelector.setAdapter(adapter);

    }

    private void initMultiQuestionsNumber() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));
        }

        //设置是否循环播放，加这句为不循环，注释掉为循环
        mMultiQuestionNumber.setNotLoop();
        //设置原始数据
        mMultiQuestionNumber.setItems(list);
        //设置初始位置
        mMultiQuestionNumber.setInitPosition(0);
        //设置字体大小
        mMultiQuestionNumber.setTextSize(20);

        mMultiSelectionNumber.setListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                playSound();
            }
        });
    }

    private void initSingleSelectionNumber() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }

        //设置是否循环播放，加这句为不循环，注释掉为循环
        mSingleSelectionNumber.setNotLoop();
        //设置原始数据
        mSingleSelectionNumber.setItems(list);
        //设置初始位置
        mSingleSelectionNumber.setInitPosition(4);
        //设置字体大小
        mSingleSelectionNumber.setTextSize(20);
        mSingleSelectionNumber.setListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                playSound();
            }
        });
    }

    private void initSingleQuestionsNumber() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));
        }

        //设置是否循环播放，加这句为不循环，注释掉为循环
        mSingleQuestionNumber.setNotLoop();
        //设置原始数据
        mSingleQuestionNumber.setItems(list);
        //设置初始位置
        mSingleQuestionNumber.setInitPosition(0);
        //设置字体大小
        mSingleQuestionNumber.setTextSize(20);
        mSingleQuestionNumber.setListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                playSound();
            }
        });
    }

    private void initToolBar() {
        IconicsDrawable iResource = new IconicsDrawable(this).icon("fon_816").sizeDp(30)
                .color(Color.WHITE);

        mToolBar.setNavigationIcon(iResource);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_questions;
    }


//    private void initSoundPool() throws IOException {
//        //当前系统的SDK版本大于等于21(Android 5.0)时
//        if (Build.VERSION.SDK_INT >= 21) {
//            SoundPool.Builder builder = new SoundPool.Builder();
//            //传入音频数量
//            builder.setMaxStreams(2);
//            //AudioAttributes是一个封装音频各种属性的方法
//            AudioAttributes.Builder attrBuilder = new AudioAttributes.Builder();
//            //设置音频流的合适的属性
//            attrBuilder.setLegacyStreamType(AudioManager.STREAM_MUSIC);
//            //加载一个AudioAttributes
//            builder.setAudioAttributes(attrBuilder.build());
//            mSoundPool = builder.build();
//        }
//        //当系统的SDK版本小于21时
//        else {//设置最多可容纳2个音频流，音频的品质为5
//            mSoundPool = new SoundPool(2, AudioManager.STREAM_SYSTEM, 5);
//        }
//
////        soundID.put(1, mSoundPool.load(this, R.raw.sound, 1));
//    }

    protected void playSound() {
//        mSoundPool.play(soundID.get(1), 0.5f, 0.5f, 0, 0, 1);
        AudioManager am = (AudioManager)getSystemService(AUDIO_SERVICE);
        am.playSoundEffect(AudioManager.FX_KEYPRESS_STANDARD,1);
    }

}
