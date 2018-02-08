package com.example.howard.ruiyipai.pages.stastic.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.howard.ruiyipai.R;
import com.example.baselibrary.base.BaseFragment;
import com.example.howard.ruiyipai.common.Utils;
import com.example.howard.ruiyipai.pages.stastic.adapter.AnswerInfoAdapter;
import com.example.howard.ruiyipai.pages.stastic.adapter.SubjectAdapter;

import butterknife.BindView;

/**
 * Created by howard on 2018/1/18.
 * Email 158988127@qq.com
 */

public class SubjectFragment extends BaseFragment implements SubjectAdapter.SubjectListener {

    public enum MODE {
        MODE_GRID,
        MODE_DETAIL
    }

    @BindView(R.id.ll_all_answer)
    View allAnswerView;

    @BindView(R.id.ll_answer_detail)
    View answerDetailView;

    @BindView(R.id.rv_answer_list)
    RecyclerView answerList;

    private MODE mode;


    public SubjectFragment() {
        mode = MODE.MODE_GRID;
    }

    @Override
    protected void initPages() {

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 3, LinearLayoutManager.VERTICAL, false);

        answerList.setLayoutManager(layoutManager);
        SubjectAdapter adapter = new SubjectAdapter(this);
        answerList.setAdapter(adapter);
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_subject;
    }

    @Override
    public void showAnswerDetail() {
        mode = MODE.MODE_DETAIL;
        allAnswerView.setVisibility(View.GONE);
        answerDetailView.setVisibility(View.VISIBLE);
    }


    public boolean onBackClick() {
        if (mode == MODE.MODE_DETAIL) {
            mode = MODE.MODE_GRID;
            allAnswerView.setVisibility(View.VISIBLE);
            answerDetailView.setVisibility(View.GONE);
            return true;
        } else {
            return false;
        }
    }
}
