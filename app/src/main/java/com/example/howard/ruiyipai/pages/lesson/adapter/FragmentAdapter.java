package com.example.howard.ruiyipai.pages.lesson.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by howard on 2018/1/25.
 * Email 158988127@qq.com
 */

public class FragmentAdapter extends FragmentPagerAdapter {

//    private String [] title = {"one","two","three","four"};
    private List<Fragment> fragmentList;
    public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
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
}