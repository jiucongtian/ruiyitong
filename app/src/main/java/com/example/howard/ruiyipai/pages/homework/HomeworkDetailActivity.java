package com.example.howard.ruiyipai.pages.homework;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.base.BaseActivity;
import com.example.howard.ruiyipai.pages.homework.adapter.CheckHomeworkClassListAdapter;
import com.example.howard.ruiyipai.pages.homework.adapter.HomeworkStudentsAdapter;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.mikepenz.iconics.IconicsDrawable;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by howard on 2018/1/28.
 * Email 158988127@qq.com
 */

public class HomeworkDetailActivity extends BaseActivity implements HomeworkStudentsAdapter.HomeworkOnClickListner {

    @BindView(R.id.tb_header)
    Toolbar mToolbar;

    @BindView(R.id.rv_student_list)
    RecyclerView mStudentListRv;

    @BindView(R.id.bc_homework_statistics)
    BarChart mHomeworkStatistics;

    @Override
    public void initPages() {
        initToolBar();

        initStudentsAnswer();

        initBarChart();

    }

    private void initStudentsAnswer() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mStudentListRv.setLayoutManager(layoutManager);

        HomeworkStudentsAdapter adapter = new HomeworkStudentsAdapter(this);
        mStudentListRv.setAdapter(adapter);
    }

    private void initToolBar() {
        IconicsDrawable iResource = new IconicsDrawable(this).icon("fon_816").sizeDp(30)
                .colorRes(R.color.light_blue_deep);

        mToolbar.setNavigationIcon(iResource);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_homework_detail;
    }

    @Override
    public void onSubjectClicked() {
        Intent intent = new Intent(this, HomeworkSubjectActivity.class);
        startActivity(intent);
    }


    private void initBarChart() {

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(1, 2));
        entries.add(new BarEntry(2, 20));
        entries.add(new BarEntry(3, 10));
        entries.add(new BarEntry(4, 5));
        entries.add(new BarEntry(5, 40));
        entries.add(new BarEntry(6, 4));
        entries.add(new BarEntry(7, 9));
        // 每一个BarDataSet代表一类柱状图
        BarDataSet barDataSet = new BarDataSet(entries, "");

        barDataSet.setValueTextSize(9f);
        barDataSet.setFormLineWidth(1f);
        barDataSet.setFormSize(15.f);

        barDataSet.setValueFormatter(new IValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                return String.valueOf((int)value);
            }
        });






        ArrayList<BarEntry> entries2 = new ArrayList<>();
        entries2.add(new BarEntry(1, 2));
        entries2.add(new BarEntry(2, 20));
        entries2.add(new BarEntry(3, 10));
        entries2.add(new BarEntry(4, 5));
        entries2.add(new BarEntry(5, 40));
        entries2.add(new BarEntry(6, 4));
        entries2.add(new BarEntry(7, 9));






        // 每一个BarDataSet代表一类柱状图
        BarDataSet barDataSet2 = new BarDataSet(entries2, "");

        barDataSet2.setValueTextSize(9f);
        barDataSet2.setFormLineWidth(1f);
        barDataSet2.setFormSize(15.f);

        barDataSet2.setValueFormatter(new IValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                return String.valueOf((int)value);
            }
        });



//        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
//        dataSets.add(barDataSet);
        BarData data = new BarData();

        data.addDataSet(barDataSet);
        data.addDataSet(barDataSet2);

















        //设置X轴的刻度数
        mHomeworkStatistics.setData(data);


        //获取x轴
        XAxis xAxis = mHomeworkStatistics.getXAxis();
        xAxis.setDrawGridLines(false);

        xAxis.setAxisMaximum(10);
        xAxis.setAxisMinimum(0);
        xAxis.setLabelCount(9, false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
//        xAxis.setDrawLabels(false);


        //获取y轴
        YAxis yAxis = mHomeworkStatistics.getAxisLeft();
        yAxis.setDrawGridLines(false);
        yAxis.setLabelCount(5, true);
        yAxis.setAxisMinimum(0);
        yAxis.setAxisMaximum(40);
        yAxis.setSpaceTop(20f);


        Legend legend = mHomeworkStatistics.getLegend();             //左下角比例尺
        legend.setEnabled(false);
        mHomeworkStatistics.getAxisRight().setEnabled(false);        //右侧坐标轴
        mHomeworkStatistics.setDrawBorders(false);                   //隐藏最外层方框
        mHomeworkStatistics.setTouchEnabled(false);
        mHomeworkStatistics.setDrawValueAboveBar(true);
        mHomeworkStatistics.animateY(1000, Easing.EasingOption.Linear);


        Description desc = new Description();
        desc.setText("");

        mHomeworkStatistics.setDescription(desc);



//        Matrix matrix = new Matrix();
//        matrix.postScale(1.5f, 1f);
//        answerBarChart.getViewPortHandler().refresh(matrix, answerBarChart, false);




    }

}
