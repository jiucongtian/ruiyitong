package com.example.howard.ruiyipai.pages.stastic.fragment;

import android.annotation.SuppressLint;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.howard.ruiyipai.R;
import com.example.baselibrary.base.BaseFragment;
import com.example.baselibrary.common.Utils;
import com.example.howard.ruiyipai.pages.stastic.adapter.AnswerInfoAdapter;
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

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by howard on 2018/1/18.
 * Email 158988127@qq.com
 */

@SuppressLint("ValidFragment")
public class AnswerDurationFragment extends BaseFragment {

    static final int LINE_HEIGHT_DP = 50;

    @BindView(R.id.rv_unanswer)
    RecyclerView unanswerRv;

    @BindView(R.id.rv_first_3)
    RecyclerView first3Rv;

    @BindView(R.id.rv_above_average)
    RecyclerView aboveAverageRv;

    @BindView(R.id.rv_below_average)
    RecyclerView belowAverageRv;

    @BindView(R.id.lineChart)
    LineChart mAnswerDuration;

    FragmentManager fm;
    public AnswerDurationFragment(FragmentManager fragmentManager ) {
        fm = fragmentManager;
    }

    @Override
    protected void initPages() {

        initLineChart();
        initRecyclerView(unanswerRv);
        initRecyclerView(first3Rv);
        initRecyclerView(aboveAverageRv);
        initRecyclerView(belowAverageRv);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_answer_duration;
    }

    private void initRecyclerView(RecyclerView view) {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 14, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = Utils.dip2px(getContext(), LINE_HEIGHT_DP);
        view.setLayoutParams(layoutParams);

        view.setLayoutManager(layoutManager);
        AnswerInfoAdapter adapter = new AnswerInfoAdapter();
        view.setAdapter(adapter);
    }

    private void initLineChart() {
        //1part
        //设置数据
        List<Entry> entries = new ArrayList<>();

        entries.add(new Entry(0, (float) 0));
        entries.add(new Entry(1, (float) 0));
        entries.add(new Entry(2, (float) 0));
        entries.add(new Entry(3, (float) 200));

        //一个LineDataSet就是一条线
        LineDataSet lineDataSet = new LineDataSet(entries, "温度");
        lineDataSet.setColor(ContextCompat.getColor(getContext(), R.color.line_chart_point_red));
        lineDataSet.setCircleColor(ContextCompat.getColor(getContext(), R.color.line_chart_point_red));
        lineDataSet.setCircleRadius(4);
        lineDataSet.setDrawValues(false);//隐藏折线图每个数据点的值
        lineDataSet.setDrawCircles(true);//图表上的数据点是否用小圆圈表示
        lineDataSet.setDrawFilled(true);//是否填充折线下方
        lineDataSet.setFillColor(ContextCompat.getColor(getContext(), R.color.line_chart_fill_red));//折线图下方填充颜色设置
        //设置线和点结束

        //2part
        List<Entry> entries2 = new ArrayList<>();
        entries2.add(new Entry(3, (float) 200));
        entries2.add(new Entry(4, (float) 500));
        entries2.add(new Entry(5, (float) 600));
        entries2.add(new Entry(6, (float) 600));
        entries2.add(new Entry(7, (float) 750));
        entries2.add(new Entry(8, (float) 900));
        entries2.add(new Entry(9, (float) 900));
        entries2.add(new Entry(10, (float) 930));
        entries2.add(new Entry(11, (float) 950));
        entries2.add(new Entry(12, (float) 1000));
        LineDataSet lineDataSet2 = new LineDataSet(entries2, "温度");
        lineDataSet2.setColor(ContextCompat.getColor(getContext(), R.color.line_chart_point_blue));
        lineDataSet2.setCircleColor(ContextCompat.getColor(getContext(), R.color.line_chart_point_blue));
        lineDataSet2.setCircleRadius(4);
        lineDataSet2.setDrawValues(false);//隐藏折线图每个数据点的值
        lineDataSet2.setDrawCircles(true);//图表上的数据点是否用小圆圈表示
        lineDataSet2.setDrawFilled(true);//是否填充折线下方
        lineDataSet2.setFillColor(ContextCompat.getColor(getContext(), R.color.line_chart_fill_blue));//折线图下方填充颜色设置

        //3part
        List<Entry> entries3 = new ArrayList<>();
        entries3.add(new Entry(12, (float) 1000));
        entries3.add(new Entry(13, (float) 1100));
        entries3.add(new Entry(14, (float) 1150));
        entries3.add(new Entry(15, (float) 1600));
        entries3.add(new Entry(16, (float) 1700));
        entries3.add(new Entry(17, (float) 1750));
        entries3.add(new Entry(18, (float) 1800));
        entries3.add(new Entry(19, (float) 1900));
        LineDataSet lineDataSet3 = new LineDataSet(entries3, "温度");
        lineDataSet3.setColor(ContextCompat.getColor(getContext(), R.color.line_chart_point_yellow));
        lineDataSet3.setCircleColor(ContextCompat.getColor(getContext(), R.color.line_chart_point_yellow));
        lineDataSet3.setCircleRadius(4);
        lineDataSet3.setDrawValues(false);//隐藏折线图每个数据点的值
        lineDataSet3.setDrawCircles(true);//图表上的数据点是否用小圆圈表示
        lineDataSet3.setDrawFilled(true);//是否填充折线下方
        lineDataSet3.setFillColor(ContextCompat.getColor(getContext(), R.color.line_chart_fill_yellow));//折线图下方填充颜色设置

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet); // add the datasets
        dataSets.add(lineDataSet2);
        dataSets.add(lineDataSet3);
        LineData data = new LineData(dataSets);
        mAnswerDuration.setData(data);

        XAxis xAxis = mAnswerDuration.getXAxis();
        xAxis.setDrawAxisLine(true);                        //x坐标轴线
        xAxis.setDrawGridLines(true);                      //x坐标轴竖线
        xAxis.setGridColor(R.color.line_chart_grid_line);
        xAxis.setLabelRotationAngle(-60f);                  //x轴旋转角度
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//设置x坐标轴显示在下边
        xAxis.setTextSize(10);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return "学生" + String.valueOf((int)value);
            }
        });

        //设置x轴个数
        Class<? extends AxisBase > clazz = AxisBase.class;

        try {
            Field nameField = clazz.getDeclaredField("mLabelCount");
            nameField.setAccessible(true);// 设置操作权限为true
            nameField.set(xAxis, 20);
        } catch (Exception e) {
            e.printStackTrace();
        }

        YAxis yAxis = mAnswerDuration.getAxisLeft();
        yAxis.setDrawAxisLine(true);     //y坐标轴线
        yAxis.setDrawGridLines(false);   //y坐标轴竖线

        //可以设置一条警戒线，如下：
        LimitLine ll = new LimitLine(1000f, "");
        ll.setLineColor(ContextCompat.getColor(getContext(), R.color.icon_blue_sky));
        ll.setLineWidth(1f);
        yAxis.addLimitLine(ll);
        yAxis.setLabelCount(5, true);
        yAxis.setAxisMaximum(2000);
        yAxis.setAxisMinimum(0);
        yAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                if (value == 0){
                    return "00:00";
                } else if (value == 500) {
                    return "00:30";
                } else if (value == 1000) {
                    return "01:00";
                } else if (value == 1500) {
                    return "01:30";
                } else if (value == 2000) {
                    return "02:00";
                } else {
                    return "00:00";
                }
            }
        });

        Legend legend = mAnswerDuration.getLegend();             //左下角比例尺
        legend.setEnabled(false);
        mAnswerDuration.getAxisRight().setEnabled(false);        //右侧坐标轴
        mAnswerDuration.setDrawBorders(false);                   //隐藏最外层方框
        mAnswerDuration.setTouchEnabled(false);
        Description desc = new Description();
        desc.setText("");

        mAnswerDuration.setDescription(desc);
    }
}
