package com.example.howard.ruiyipai.pages.lesson;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.base.BaseFragment;
import com.example.howard.ruiyipai.pages.lesson.adapter.ResourceListAdapter;
import com.example.howard.ruiyipai.pages.lesson.adapter.SplideListMainAdapter;

import butterknife.BindView;

/**
 * Created by howard on 2018/1/18.
 * Email zh@longhuapuxin.com
 */

public class ResourceListFragment extends BaseFragment {

    @BindView(R.id.rv_resource_list)
    RecyclerView resourceList;

    ResourceListAdapter mAdapter;

    //TODO: 临时设置屏幕数为9,后期根据程序计算
    private int screenCount = 9;

    @Override
    protected void initPages() {


        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        resourceList.setLayoutManager(layoutManager);

        mAdapter = new ResourceListAdapter(this.getContext());
        mAdapter.setScreenCount(screenCount);
        resourceList.setAdapter(mAdapter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_resource_list;
    }
}
