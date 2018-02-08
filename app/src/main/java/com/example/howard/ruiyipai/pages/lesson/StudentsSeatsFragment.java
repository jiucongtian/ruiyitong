package com.example.howard.ruiyipai.pages.lesson;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.howard.ruiyipai.R;
import com.example.baselibrary.base.BaseFragment;
import com.example.howard.ruiyipai.common.Utils;
import com.example.howard.ruiyipai.pages.lesson.adapter.LessonToolsAdapter;
import com.example.howard.ruiyipai.pages.lesson.adapter.SeatsAdapter;

import butterknife.BindView;

/**
 * Created by howard on 2018/1/18.
 * Email 158988127@qq.com
 */

public class StudentsSeatsFragment extends BaseFragment {

    @BindView(R.id.rv_seats)
    RecyclerView seats;

    @Override
    protected void initPages() {

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 7, LinearLayoutManager.VERTICAL, false);
        seats.setLayoutManager(layoutManager);

        SeatsAdapter adapter = new SeatsAdapter(getContext());
        seats.setAdapter(adapter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_students_seats;
    }
}
