package com.example.howard.ruiyipai.pages.lesson.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.common.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by howard on 2018/1/14.
 * Email zh@longhuapuxin.com
 */

public class SplideListMainAdapter extends RecyclerView.Adapter<SplideListMainAdapter.ViewHolder> {

    static final int SELECTED_RESOURCE_HEIGHT = 120;

    List<List<String>> mData;
    Context mContext;

    public SplideListMainAdapter(Context context, List<List<String>> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 实例化展示的view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_splide_main, parent, false);
        // 实例化viewholder
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        List<String> resourceOfScreen = mData.get(position);


        RecyclerView selectedListView = holder.selectedResourceContainer;

        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        selectedListView.setLayoutManager(layoutManager);

        SelectedResourceAdapter adapter = new SelectedResourceAdapter(resourceOfScreen);
        selectedListView.setAdapter(adapter);



        //设置选中资源列表固定高度
        int number = resourceOfScreen.size();
        ViewGroup.LayoutParams lp = selectedListView.getLayoutParams();
        lp.height = Utils.dip2px(mContext, number * SELECTED_RESOURCE_HEIGHT);
        selectedListView.setLayoutParams(lp);
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.rl_selected_resource)
        RecyclerView selectedResourceContainer;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

}

