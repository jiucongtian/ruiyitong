package com.example.howard.ruiyipai.pages.stastic.fragment;

import android.support.v4.app.FragmentManager;

import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.base.BaseFragment;

/**
 * Created by howard on 2018/1/18.
 * Email 158988127@qq.com
 */

public class SubjectFragment extends BaseFragment {

    FragmentManager fm;
    public SubjectFragment(FragmentManager fragmentManager ) {
        fm = fragmentManager;
    }

    @Override
    protected void initPages() {

//        List<Fragment> fragmentList = new ArrayList<>();
//        fragmentList.add(new Test2Fragment());
//        fragmentList.add(new Test3Fragment());
//
//        StasticFragmentAdapter adapter = new StasticFragmentAdapter(fm, fragmentList);
//        inner.setAdapter(adapter);

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_subject;
    }
}
