package com.example.howard.ruiyipai.pages.calendar.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by howard on 2018/1/25.
 * Email 158988127@qq.com
 */

public class PopupCalendarFragmentAdapter extends FragmentPagerAdapter {

    //private String [] title = {"第1题","第2题","第3题","第4题","第5题","第6题","第7题","第8题","第9题","第10题","第11题","第12题","第13题","第14题","第15题"};
    private List<Fragment> fragmentList;

    private Fragment mCurrentFragment;

    public PopupCalendarFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }
    @Override
    public int getCount() {
        return fragmentList.size();
    }
//    @Override
//    public CharSequence getPageTitle(int position) {
//        return title[position];
//    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        mCurrentFragment = (Fragment) object;
        super.setPrimaryItem(container, position, object);
    }

    public Fragment getCurrentFragment() {
        return mCurrentFragment;
    }
}