package com.example.howard.ruiyipai.pages.stastic.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.base.BaseFragment;
import com.example.howard.ruiyipai.common.Utils;
import com.example.howard.ruiyipai.pages.lesson.adapter.LessonToolsAdapter;
import com.example.howard.ruiyipai.pages.stastic.adapter.AnswerInfoAdapter;
import com.example.howard.ruiyipai.recyclerAdapter.ClassAdapter;

import butterknife.BindView;

/**
 * Created by howard on 2018/1/18.
 * Email 158988127@qq.com
 */

public class AnswerChartFragment extends BaseFragment {


    static final int LINE_HEIGHT_DP = 50;

    @BindView(R.id.rv_unanswer)
    RecyclerView unanswerRv;

    @BindView(R.id.rv_a)
    RecyclerView aRv;

    @BindView(R.id.rv_b)
    RecyclerView bRv;

    @BindView(R.id.rv_c)
    RecyclerView cRv;

    @BindView(R.id.rv_d)
    RecyclerView dRv;

    @BindView(R.id.rv_e)
    RecyclerView eRv;

    @BindView(R.id.rv_f)
    RecyclerView fRv;

    FragmentManager fm;
    public AnswerChartFragment(FragmentManager fragmentManager ) {
        fm = fragmentManager;
    }

    @Override
    protected void initPages() {


        initRecyclerView(unanswerRv);
        initRecyclerView(aRv);
        initRecyclerView(bRv);
        initRecyclerView(cRv);
        initRecyclerView(dRv);
        initRecyclerView(eRv);
        initRecyclerView(fRv);
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

    @Override
    public int getLayoutId() {
        return R.layout.fragment_answer_chart;
    }
}
