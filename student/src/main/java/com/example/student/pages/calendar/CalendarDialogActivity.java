package com.example.student.pages.calendar;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.example.baselibrary.base.BaseActivity;
import com.example.student.R;
import com.example.student.pages.calendar.adapter.PopupCalendarFragmentAdapter;
import com.example.student.pages.calendar.fragment.CommentsFragment;
import com.example.student.pages.calendar.fragment.PrepareLessonFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by howard on 2018/2/3.
 * Email 158988127@qq.com
 */

public class CalendarDialogActivity extends BaseActivity {

    @BindView(R.id.tl_header)
    TabLayout header;

    @BindView(R.id.vp_calendar_container)
    ViewPager viewPager;

    @Override
    public void initPages() {
        initCalendarRv();

    }

    private void initCalendarRv() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new CommentsFragment());
        //备课
        fragments.add(new PrepareLessonFragment());
        //实录
        fragments.add(new PrepareLessonFragment());

        PopupCalendarFragmentAdapter adapter = new PopupCalendarFragmentAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        header.setupWithViewPager(viewPager);



        for (int i = 0; i < adapter.getCount(); i++) {
            TabLayout.Tab tab = header.getTabAt(i);//获得每一个tab
            tab.setCustomView(R.layout.item_calendar_popup_tab);//给每一个tab设置view


            if (i == 0) {
                // 设置第一个tab的TextView是被选择的样式
//                tab.getCustomView().findViewById(R.id.container).setSelected(true);
                tab.getCustomView().findViewById(R.id.iv_flag).setBackgroundResource(R.drawable.flag_yellow);
                TextView title = tab.getCustomView().findViewById(R.id.tv_title);
                title.setText("批注");
            } else if (i == 1) {
                tab.getCustomView().findViewById(R.id.iv_flag).setBackgroundResource(R.drawable.flag_red);
                TextView title = tab.getCustomView().findViewById(R.id.tv_title);
                title.setText("备课");
            } else if (i == 2) {
                tab.getCustomView().findViewById(R.id.iv_flag).setBackgroundResource(R.drawable.flag_blue);
                TextView title = tab.getCustomView().findViewById(R.id.tv_title);
                title.setText("实录");
            }

        }






    }

    @Override
    protected int getLayoutId() {
        return R.layout.popup_calendar;
    }

    @OnClick({R.id.iv_close})
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.iv_close:
                finish();
                break;
        }

    }

}
