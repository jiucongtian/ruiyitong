package com.example.howard.ruiyipai.pages;

import android.support.v4.content.ContextCompat;

import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.base.BaseActivity;
import com.example.howard.ruiyipai.common.Utils;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by howard on 2018/1/19.
 * Email 158988127@qq.com
 */

public class TestActivity extends BaseActivity {
    @Override
    public void initPages() {
        LineChart mLineChart = (LineChart) findViewById(R.id.lineChart);
        //显示边界
        mLineChart.setDrawBorders(true);
        //设置数据
        List<Entry> entries = new ArrayList<>();

        entries.add(new Entry(0, (float) 0));
        entries.add(new Entry(1, (float) 0));
        entries.add(new Entry(2, (float) 0.3));
        entries.add(new Entry(3, (float) 0.4));

        //一个LineDataSet就是一条线
        LineDataSet lineDataSet = new LineDataSet(entries, "温度");
        lineDataSet.setColor(ContextCompat.getColor(this, R.color.red));
        lineDataSet.setCircleRadius(4);
        lineDataSet.setDrawValues(false);//隐藏折线图每个数据点的值
        lineDataSet.setDrawCircles(true);//图表上的数据点是否用小圆圈表示
        lineDataSet.setDrawFilled(true);//是否填充折线下方
        lineDataSet.setFillColor(ContextCompat.getColor(this, R.color.red));//折线图下方填充颜色设置
        lineDataSet.setCircleColor(ContextCompat.getColor(this, R.color.red));
        //设置线和点结束



        List<Entry> entries2 = new ArrayList<>();

        entries2.add(new Entry(3, (float) 0.4));
        entries2.add(new Entry(4, (float) 0.6));
        entries2.add(new Entry(5, (float) 0.6));
        entries2.add(new Entry(6, (float) 0.8));
        entries2.add(new Entry(7, (float) 0.9));
        entries2.add(new Entry(8, (float) 0.9));
        entries2.add(new Entry(9, (float) 1));
        entries2.add(new Entry(10, (float) 1));
        entries2.add(new Entry(11, (float) 1));
        entries2.add(new Entry(12, (float) 1.2));
        entries2.add(new Entry(13, (float) 1.3));
        entries2.add(new Entry(14, (float) 1.4));
        entries2.add(new Entry(15, (float) 2));
        entries2.add(new Entry(16, (float) 2));
        entries2.add(new Entry(17, (float) 2));
        entries2.add(new Entry(18, (float) 2));
        entries2.add(new Entry(19, (float) 2));
        LineDataSet lineDataSet2 = new LineDataSet(entries2, "温度");
        lineDataSet2.setColor(ContextCompat.getColor(this, R.color.icon_blue_sky));
        lineDataSet2.setCircleRadius(4);
        lineDataSet2.setDrawValues(false);//隐藏折线图每个数据点的值
        lineDataSet2.setDrawCircles(true);//图表上的数据点是否用小圆圈表示
        lineDataSet2.setDrawFilled(true);//是否填充折线下方
        lineDataSet2.setFillColor(ContextCompat.getColor(this, R.color.icon_blue_sky));//折线图下方填充颜色设置
        lineDataSet2.setCircleColor(ContextCompat.getColor(this, R.color.icon_blue_sky));





        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet); // add the datasets
        dataSets.add(lineDataSet2);
        LineData data = new LineData(dataSets);
        mLineChart.setData(data);
        mLineChart.animateX(300);




        XAxis xAxis = mLineChart.getXAxis();
        xAxis.setLabelCount(10);
//        xAxis.setSpaceMin(1);
        xAxis.setDrawAxisLine(true);                        //x坐标轴线
        xAxis.setDrawGridLines(false);                      //x坐标轴竖线
        xAxis.setLabelRotationAngle(-60f);                  //x轴旋转角度
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//设置x坐标轴显示在下边
        xAxis.setLabelCount(100, true);
        xAxis.setTextSize(3);
//        xAxis.setLabelsToSkip(0);                           //设置x轴显示每一个
//        mChart.getAxisLeft().setAxisMinValue(0f);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return "zzz";
            }
        });

//        xAxis.setSpaceBetweenLabels(0);


        YAxis yAxis = mLineChart.getAxisLeft();

        yAxis.setDrawAxisLine(true);     //y坐标轴线
        yAxis.setDrawGridLines(false);   //y坐标轴竖线

        //可以设置一条警戒线，如下：
        LimitLine ll = new LimitLine(1f, "警戒线");
        ll.setLineColor(ContextCompat.getColor(this, R.color.icon_blue_sky));
        ll.setLineWidth(1f);
//        ll.setTextColor(Color.GRAY);
//        ll.setTextSize(12f);
        // .. and more styling options
        yAxis.addLimitLine(ll);



        Legend legend = mLineChart.getLegend();             //左下角比例尺
        legend.setEnabled(false);

        mLineChart.getAxisRight().setEnabled(false);        //右侧坐标轴

        mLineChart.setDrawBorders(false);                   //隐藏最外层方框
        mLineChart.animateX(300);                           //设置动画

        Description desc = new Description();
        desc.setText("");

        mLineChart.setDescription(desc);


//        mLineChart.setDescription("");

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }
}
