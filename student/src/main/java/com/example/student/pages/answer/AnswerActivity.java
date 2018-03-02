package com.example.student.pages.answer;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.baselibrary.base.BaseActivity;
import com.example.student.R;
import com.example.student.pages.answer.adapter.QuestionAdapter;
import com.example.student.pages.note.adapter.NoteAdapter;

import butterknife.BindView;

/**
 * Created by howard on 2018/3/2.
 * Email 158988127@qq.com
 */

public class AnswerActivity extends BaseActivity {

    @BindView(R.id.question_rv)
    RecyclerView mQuestionNo;

    @Override
    public void initPages() {
        initQuestionList();
    }

    private void initQuestionList() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mQuestionNo.setLayoutManager(layoutManager);

        QuestionAdapter adapter = new QuestionAdapter();
        mQuestionNo.setAdapter(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_answer;
    }
}
