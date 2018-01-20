package com.example.howard.ruiyipai.pages.Questions;

import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.base.BaseActivity;
import com.weigan.loopview.LoopView;

import java.util.ArrayList;

import butterknife.BindView;

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
    LoopView mMultiSelectionNumber;

    @Override
    public void initPages() {

        initSingleQuestionsNumber();
        initSingleSelectionNumber();
        initMultiQuestionsNumber();

    }

    private void initMultiQuestionsNumber() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("item " + i);
        }

        //设置是否循环播放，加这句为不循环，注释掉为循环
        mMultiSelectionNumber.setNotLoop();
        //设置原始数据
        mMultiSelectionNumber.setItems(list);
        //设置初始位置
        mMultiSelectionNumber.setInitPosition(5);
        //设置字体大小
        mMultiSelectionNumber.setTextSize(20);
    }

    private void initSingleSelectionNumber() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("item " + i);
        }

        //设置是否循环播放，加这句为不循环，注释掉为循环
        mSingleSelectionNumber.setNotLoop();
        //设置原始数据
        mSingleSelectionNumber.setItems(list);
        //设置初始位置
        mSingleSelectionNumber.setInitPosition(5);
        //设置字体大小
        mSingleSelectionNumber.setTextSize(20);
    }

    private void initSingleQuestionsNumber() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("item " + i);
        }

        //设置是否循环播放，加这句为不循环，注释掉为循环
        mSingleQuestionNumber.setNotLoop();
        //设置原始数据
        mSingleQuestionNumber.setItems(list);
        //设置初始位置
        mSingleQuestionNumber.setInitPosition(5);
        //设置字体大小
        mSingleQuestionNumber.setTextSize(20);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_questions;
    }
}
