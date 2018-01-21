package com.example.howard.ruiyipai.pages.questions;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.base.BaseActivity;
import com.example.howard.ruiyipai.bean.StudentSelectionBean;
import com.example.howard.ruiyipai.bean.StudentsGroupNode;
import com.example.howard.ruiyipai.bean.StudentsNode;
import com.weigan.loopview.LoopView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.example.howard.ruiyipai.bean.StudentSelectionBean.SELECTION_TYPE.TYPE_CLASS;
import static com.example.howard.ruiyipai.bean.StudentSelectionBean.SELECTION_TYPE.TYPE_STUDENT;
import static com.example.howard.ruiyipai.bean.StudentSelectionBean.SELECTION_TYPE.TYPE_TEAM;

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

    @Override
    public void initPages() {
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
        for (int i = 0; i < 10; i++) {
            list.add("item " + i);
        }

        //设置是否循环播放，加这句为不循环，注释掉为循环
        mQuestionDuration.setNotLoop();
        //设置原始数据
        mQuestionDuration.setItems(list);
        //设置初始位置
        mQuestionDuration.setInitPosition(5);
        //设置字体大小
        mQuestionDuration.setTextSize(20);
    }

    private void initSubjectQuestionsNumber() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("item " + i);
        }

        //设置是否循环播放，加这句为不循环，注释掉为循环
        mSubjectNumber.setNotLoop();
        //设置原始数据
        mSubjectNumber.setItems(list);
        //设置初始位置
        mSubjectNumber.setInitPosition(5);
        //设置字体大小
        mSubjectNumber.setTextSize(20);
    }

    private void initJudgeQuestionsNumber() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("item " + i);
        }

        //设置是否循环播放，加这句为不循环，注释掉为循环
        mJudgeNumber.setNotLoop();
        //设置原始数据
        mJudgeNumber.setItems(list);
        //设置初始位置
        mJudgeNumber.setInitPosition(5);
        //设置字体大小
        mJudgeNumber.setTextSize(20);
    }

    private void initMultiSelectionNumber() {
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

    private void initStudentsList() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mStudentSelector.setLayoutManager(layoutManager);

        List<StudentSelectionBean> selections = new ArrayList<>();
        selections.add(new StudentSelectionBean("高二年级（1）班", TYPE_CLASS));
        selections.add(new StudentSelectionBean("第一组", TYPE_TEAM));
        selections.add(new StudentSelectionBean("第二组", TYPE_TEAM));
        selections.add(new StudentSelectionBean("张三", TYPE_STUDENT));
        selections.add(new StudentSelectionBean("张三", TYPE_STUDENT));
        selections.add(new StudentSelectionBean("第一组", TYPE_TEAM));
        selections.add(new StudentSelectionBean("张三", TYPE_STUDENT));
        selections.add(new StudentSelectionBean("张三", TYPE_STUDENT));
        selections.add(new StudentSelectionBean("张三", TYPE_STUDENT));
        selections.add(new StudentSelectionBean("张三", TYPE_STUDENT));

        questionSelectorAdapter adapter = new questionSelectorAdapter(selections);
        mStudentSelector.setAdapter(adapter);

    }

    private void initMultiQuestionsNumber() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("item " + i);
        }

        //设置是否循环播放，加这句为不循环，注释掉为循环
        mMultiQuestionNumber.setNotLoop();
        //设置原始数据
        mMultiQuestionNumber.setItems(list);
        //设置初始位置
        mMultiQuestionNumber.setInitPosition(5);
        //设置字体大小
        mMultiQuestionNumber.setTextSize(20);
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
