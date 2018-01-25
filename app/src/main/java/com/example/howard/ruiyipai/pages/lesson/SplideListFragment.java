package com.example.howard.ruiyipai.pages.lesson;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.base.BaseFragment;
import com.example.howard.ruiyipai.pages.lesson.adapter.LessonThumbnailAdapter;
import com.example.howard.ruiyipai.pages.lesson.adapter.SplideListMainAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by howard on 2018/1/18.
 * Email 158988127@qq.com
 */

public class SplideListFragment extends BaseFragment {

    @BindView(R.id.rv_splide_list)
    RecyclerView splideListRv;

    List<List<String>> spliteList = new ArrayList<>();

    @Override
    protected void initPages() {

        List screen1 = new ArrayList();
        screen1.add("量子物理");
        screen1.add("高中化学");
        List screen2 = new ArrayList();
        screen2.add("高中生物");
        List screen3 = new ArrayList();
        screen3.add("高中生物");
        screen3.add("高中微积分");
        screen3.add("高等数学");
        screen3.add("玄学");
        spliteList.add(screen1);
        spliteList.add(screen2);
        spliteList.add(screen3);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        splideListRv.setLayoutManager(layoutManager);

        SplideListMainAdapter adapter = new SplideListMainAdapter(this.getContext(), spliteList);
        splideListRv.setAdapter(adapter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_splide_list;
    }
}
