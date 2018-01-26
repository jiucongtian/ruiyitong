package com.example.howard.ruiyipai.pages.stastic.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.base.BaseFragment;
import com.example.howard.ruiyipai.common.Utils;
import com.example.howard.ruiyipai.pages.stastic.adapter.AnswerInfoAdapter;

import butterknife.BindView;

/**
 * Created by howard on 2018/1/18.
 * Email 158988127@qq.com
 */

public class AnswerDurationFragment extends BaseFragment {

    static final int LINE_HEIGHT_DP = 50;

    @BindView(R.id.rv_unanswer)
    RecyclerView unanswerRv;

    @BindView(R.id.rv_first_3)
    RecyclerView first3Rv;

    @BindView(R.id.rv_above_average)
    RecyclerView aboveAverageRv;

    @BindView(R.id.rv_below_average)
    RecyclerView belowAverageRv;



    FragmentManager fm;
    public AnswerDurationFragment(FragmentManager fragmentManager ) {
        fm = fragmentManager;
    }

    @Override
    protected void initPages() {

    initRecyclerView(unanswerRv);
    initRecyclerView(first3Rv);
    initRecyclerView(aboveAverageRv);
    initRecyclerView(belowAverageRv);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_answer_duration;
    }

    private void initRecyclerView(RecyclerView view) {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 14, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = Utils.dip2px(getContext(), LINE_HEIGHT_DP);
        view.setLayoutParams(layoutParams);

        view.setLayoutManager(layoutManager);
        AnswerInfoAdapter adapter = new AnswerInfoAdapter();
        view.setAdapter(adapter);
    }
}
