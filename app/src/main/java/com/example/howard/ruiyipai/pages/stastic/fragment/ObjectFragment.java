package com.example.howard.ruiyipai.pages.stastic.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.howard.ruiyipai.R;
import com.example.baselibrary.base.BaseFragment;
import com.example.howard.ruiyipai.pages.stastic.adapter.StatisticFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by howard on 2018/1/18.
 * Email 158988127@qq.com
 */

public class ObjectFragment extends BaseFragment {

    @BindView(R.id.vp_object_container)
    ViewPager mContainer;

    public ObjectFragment() {
    }

    @Override
    protected void initPages() {

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new AnswerChartFragment(getChildFragmentManager()));
        fragmentList.add(new AnswerDurationFragment(getChildFragmentManager()));

        StatisticFragmentAdapter adapter = new StatisticFragmentAdapter(getChildFragmentManager(), fragmentList);
        mContainer.setAdapter(adapter);

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_object;
    }
}
