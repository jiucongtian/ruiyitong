package com.example.howard.ruiyipai.pages.stastic;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.baselibrary.base.BaseActivity;
import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.pages.questions.bean.StudentSelectionBean;
import com.example.howard.ruiyipai.pages.questions.questionSelectorAdapter;
import com.example.howard.ruiyipai.pages.stastic.adapter.RewordAdapter;
import com.mikepenz.iconics.IconicsDrawable;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.example.howard.ruiyipai.pages.questions.bean.StudentSelectionBean.SELECTION_TYPE.TYPE_CLASS;
import static com.example.howard.ruiyipai.pages.questions.bean.StudentSelectionBean.SELECTION_TYPE.TYPE_STUDENT;
import static com.example.howard.ruiyipai.pages.questions.bean.StudentSelectionBean.SELECTION_TYPE.TYPE_TEAM;

/**
 * Created by howard on 2018/3/7.
 * Email 158988127@qq.com
 */

public class RewordsPopupActivity extends BaseActivity {

    @BindView(R.id.tb_header)
    Toolbar mToolbar;

    @BindView(R.id.name_rv)
    RecyclerView mNameRv;

    @BindView(R.id.rewords_rv)
    RecyclerView mRewordsRv;

    @Override
    public void initPages() {
        initToolBar();
        initStudentsList();
        initRewordsList();
    }

    private void initRewordsList() {

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 4);
        mRewordsRv.setLayoutManager(layoutManager);

        RewordAdapter adapter = new RewordAdapter();
        mRewordsRv.setAdapter(adapter);
    }


    private void initStudentsList() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mNameRv.setLayoutManager(layoutManager);

        List<StudentSelectionBean> selections = new ArrayList<>();
        selections.add(new StudentSelectionBean("高二年级（1）班", TYPE_CLASS));
        selections.add(new StudentSelectionBean("第一组", TYPE_TEAM));
        selections.add(new StudentSelectionBean("第二组", TYPE_TEAM));
        selections.add(new StudentSelectionBean("张三", TYPE_STUDENT));
        selections.add(new StudentSelectionBean("张四", TYPE_STUDENT));
        selections.add(new StudentSelectionBean("第三组", TYPE_TEAM));
        selections.add(new StudentSelectionBean("李四", TYPE_STUDENT));
        selections.add(new StudentSelectionBean("李五", TYPE_STUDENT));
        selections.add(new StudentSelectionBean("张哈", TYPE_STUDENT));
        selections.add(new StudentSelectionBean("张八", TYPE_STUDENT));

        questionSelectorAdapter adapter = new questionSelectorAdapter(selections);
        mNameRv.setAdapter(adapter);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.popup_rewords;
    }

    private void initToolBar() {
        IconicsDrawable iResource = new IconicsDrawable(this).icon("fon_828").sizeDp(30)
                .color(ContextCompat.getColor(this, R.color.white));

        mToolbar.setNavigationIcon(iResource);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
