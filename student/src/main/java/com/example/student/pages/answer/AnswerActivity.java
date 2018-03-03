package com.example.student.pages.answer;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.baselibrary.base.BaseActivity;
import com.example.student.R;
import com.example.student.pages.answer.adapter.QuestionAdapter;
import com.example.student.pages.note.adapter.NoteAdapter;

import butterknife.BindView;

/**
 * Created by howard on 2018/3/2.
 * Email 158988127@qq.com
 */

public class AnswerActivity extends BaseActivity implements QuestionAdapter.QuestionCallback {

    @BindView(R.id.question_rv)
    RecyclerView mQuestionNo;

    @BindView(R.id.single_select_container)
    View mSingleSelectContainer;
    @BindView(R.id.multi_select_container)
    View mMultiSelectContainer;
    @BindView(R.id.judge_container)
    View mJudgeContainer;
    @BindView(R.id.subject_container)
    View mSubjectContainer;



    @Override
    public void initPages() {
        initQuestionList();
    }

    private void initQuestionList() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mQuestionNo.setLayoutManager(layoutManager);

        QuestionAdapter adapter = new QuestionAdapter(this);
        mQuestionNo.setAdapter(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_answer;
    }

    @Override
    public void ChangeQuestionType(QuestionAdapter.QuestionType type) {
        mSingleSelectContainer.setVisibility(View.GONE);
        mMultiSelectContainer.setVisibility(View.GONE);
        mJudgeContainer.setVisibility(View.GONE);
        mSubjectContainer.setVisibility(View.GONE);
        switch (type) {
            case SINGLE_SELECT:
                mSingleSelectContainer.setVisibility(View.VISIBLE);
                break;
            case MULTI_SELECT:
                mMultiSelectContainer.setVisibility(View.VISIBLE);
                break;
            case JUDGE:
                mJudgeContainer.setVisibility(View.VISIBLE);
                break;
            case SUBJECT:
                mSubjectContainer.setVisibility(View.VISIBLE);
                break;
        }
    }
}
