package com.example.howard.ruiyipai.pages.stastic.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Matrix;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.base.BaseFragment;
import com.example.howard.ruiyipai.common.Utils;
import com.example.howard.ruiyipai.pages.TestActivity;
import com.example.howard.ruiyipai.pages.lesson.adapter.LessonToolsAdapter;
import com.example.howard.ruiyipai.pages.stastic.adapter.AnswerInfoAdapter;
import com.example.howard.ruiyipai.recyclerAdapter.ClassAdapter;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by howard on 2018/1/18.
 * Email 158988127@qq.com
 */

@SuppressLint("ValidFragment")
public class AnswerChartFragment extends BaseFragment {


    static final int LINE_HEIGHT_DP = 50;

    @BindView(R.id.rv_unanswer)
    RecyclerView unanswerRv;

    @BindView(R.id.rv_a)
    RecyclerView aRv;

    @BindView(R.id.rv_b)
    RecyclerView bRv;

    @BindView(R.id.rv_c)
    RecyclerView cRv;

    @BindView(R.id.rv_d)
    RecyclerView dRv;

    @BindView(R.id.rv_e)
    RecyclerView eRv;

    @BindView(R.id.rv_f)
    RecyclerView fRv;

    @BindView(R.id.bc_answer_statistic)
    BarChart answerBarChart;

    FragmentManager fm;


    public AnswerChartFragment() {}

    public AnswerChartFragment(FragmentManager fragmentManager ) {
        fm = fragmentManager;
    }

    @Override
    protected void initPages() {

        initBarChart();
        initRecyclerView(unanswerRv);
        initRecyclerView(aRv);
        initRecyclerView(bRv);
        initRecyclerView(cRv);
        initRecyclerView(dRv);
        initRecyclerView(eRv);
        initRecyclerView(fRv);
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

    @Override
    public int getLayoutId() {
        return R.layout.fragment_answer_chart;
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


        List<Integer> colors = new ArrayList<>();
        colors.add(ContextCompat.getColor(getContext(), R.color.bar_chart_red));
        colors.add(ContextCompat.getColor(getContext(), R.color.bar_chart_blue));
        colors.add(ContextCompat.getColor(getContext(), R.color.bar_chart_blue));
        colors.add(ContextCompat.getColor(getContext(), R.color.bar_chart_blue));
        colors.add(ContextCompat.getColor(getContext(), R.color.bar_chart_blue));
        colors.add(ContextCompat.getColor(getContext(), R.color.bar_chart_blue));
        colors.add(ContextCompat.getColor(getContext(), R.color.bar_chart_blue));

        barDataSet.setColors(colors);

        barDataSet.setValueTextSize(9f);
        barDataSet.setFormLineWidth(1f);
        barDataSet.setFormSize(15.f);

        barDataSet.setValueFormatter(new IValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                return String.valueOf((int)value);
            }
        });



        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(barDataSet);
        BarData data = new BarData(dataSets);
        //设置X轴的刻度数
        answerBarChart.setData(data);


        //获取x轴
        XAxis xAxis = answerBarChart.getXAxis();
        xAxis.setDrawGridLines(false);

        xAxis.setAxisMaximum(8);
        xAxis.setAxisMinimum(0);
        xAxis.setLabelCount(9, false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setDrawLabels(false);


        //获取y轴
        YAxis yAxis = answerBarChart.getAxisLeft();
        yAxis.setDrawGridLines(false);
        yAxis.setLabelCount(5, true);
        yAxis.setAxisMinimum(0);
        yAxis.setAxisMaximum(40);
        yAxis.setSpaceTop(20f);


        Legend legend = answerBarChart.getLegend();             //左下角比例尺
        legend.setEnabled(false);
        answerBarChart.getAxisRight().setEnabled(false);        //右侧坐标轴
        answerBarChart.setDrawBorders(false);                   //隐藏最外层方框
        answerBarChart.setTouchEnabled(false);
        answerBarChart.setDrawValueAboveBar(true);
        answerBarChart.animateY(1000, Easing.EasingOption.Linear);


        Description desc = new Description();
        desc.setText("");

        answerBarChart.setDescription(desc);



//        Matrix matrix = new Matrix();
//        matrix.postScale(1.5f, 1f);
//        answerBarChart.getViewPortHandler().refresh(matrix, answerBarChart, false);




    }


    public class BarChartManager {
        private BarChart mBarChart;
        private YAxis leftAxis;
        private YAxis rightAxis;
        private XAxis xAxis;

        public BarChartManager(BarChart barChart) {
            this.mBarChart = barChart;
            leftAxis = mBarChart.getAxisLeft();
            rightAxis = mBarChart.getAxisRight();
            xAxis = mBarChart.getXAxis();
        }

        /**
         * 初始化LineChart
         */
        private void initLineChart() {
            //背景颜色
            mBarChart.setBackgroundColor(Color.WHITE);
            //网格
            mBarChart.setDrawGridBackground(false);
            //背景阴影
            mBarChart.setDrawBarShadow(false);
            mBarChart.setHighlightFullBarEnabled(false);

            //显示边界
            mBarChart.setDrawBorders(true);
            //设置动画效果
            mBarChart.animateY(1000, Easing.EasingOption.Linear);
            mBarChart.animateX(1000, Easing.EasingOption.Linear);

            //折线图例 标签 设置
            Legend legend = mBarChart.getLegend();
            legend.setForm(Legend.LegendForm.LINE);
            legend.setTextSize(11f);
            //显示位置
            legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
            legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
            legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
            legend.setDrawInside(false);

            //XY轴的设置
            //X轴设置显示位置在底部
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
            xAxis.setGranularity(1f);
            //保证Y轴从0开始，不然会上移一点
            leftAxis.setAxisMinimum(0f);
            rightAxis.setAxisMinimum(0f);
        }

        /**
         * 展示柱状图(一条)
         *
         * @param xAxisValues
         * @param yAxisValues
         * @param label
         * @param color
         */
        public void showBarChart(List<Float> xAxisValues, List<Float> yAxisValues, String label, int color) {
            initLineChart();
            ArrayList<BarEntry> entries = new ArrayList<>();
            for (int i = 0; i < xAxisValues.size(); i++) {
                entries.add(new BarEntry(xAxisValues.get(i), yAxisValues.get(i)));
            }
            // 每一个BarDataSet代表一类柱状图
            BarDataSet barDataSet = new BarDataSet(entries, label);

            barDataSet.setColor(color);
            barDataSet.setValueTextSize(9f);
            barDataSet.setFormLineWidth(1f);
            barDataSet.setFormSize(15.f);

            ArrayList<IBarDataSet> dataSets = new ArrayList<>();
            dataSets.add(barDataSet);
            BarData data = new BarData(dataSets);
            //设置X轴的刻度数
            xAxis.setLabelCount(xAxisValues.size() - 1, false);
            mBarChart.setData(data);
        }

        /**
         * 展示柱状图(多条)
         *
         * @param xAxisValues
         * @param yAxisValues
         * @param labels
         * @param colours
         */
        public void showBarChart(List<Float> xAxisValues, List<List<Float>> yAxisValues, List<String> labels, List<Integer> colours) {
            initLineChart();
            BarData data = new BarData();
            for (int i = 0; i < yAxisValues.size(); i++) {
                ArrayList<BarEntry> entries = new ArrayList<>();
                for (int j = 0; j < yAxisValues.get(i).size(); j++) {

                    entries.add(new BarEntry(xAxisValues.get(j), yAxisValues.get(i).get(j), j));
                }
                BarDataSet barDataSet = new BarDataSet(entries, labels.get(i));

                barDataSet.setColor(colours.get(i));
                barDataSet.setValueTextColor(colours.get(i));
                barDataSet.setValueTextSize(10f);
                barDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
                data.addDataSet(barDataSet);
            }
            int amount = yAxisValues.size();

            float groupSpace = 0.12f; //柱状图组之间的间距
            float barSpace = (float) ((1 - 0.12) / amount / 10); // x4 DataSet
            float barWidth = (float) ((1 - 0.12) / amount / 10 * 9); // x4 DataSet

            // (0.2 + 0.02) * 4 + 0.08 = 1.00 -> interval per "group"
            xAxis.setLabelCount(xAxisValues.size() - 1, false);
            data.setBarWidth(barWidth);


            data.groupBars((float) 0.5, groupSpace, barSpace);
            mBarChart.setData(data);
        }


        /**
         * 设置Y轴值
         *
         * @param max
         * @param min
         * @param labelCount
         */
        public void setYAxis(float max, float min, int labelCount) {
            if (max < min) {
                return;
            }
            leftAxis.setAxisMaximum(max);
            leftAxis.setAxisMinimum(min);
            leftAxis.setLabelCount(labelCount, false);

            rightAxis.setAxisMaximum(max);
            rightAxis.setAxisMinimum(min);
            rightAxis.setLabelCount(labelCount, false);
            mBarChart.invalidate();
        }

        /**
         * 设置X轴的值
         *
         * @param max
         * @param min
         * @param labelCount
         */
        public void setXAxis(float max, float min, int labelCount) {
            xAxis.setAxisMaximum(max);
            xAxis.setAxisMinimum(min);
            xAxis.setLabelCount(labelCount, false);

            mBarChart.invalidate();
        }

        /**
         * 设置高限制线
         *
         * @param high
         * @param name
         */
        public void setHightLimitLine(float high, String name, int color) {
            if (name == null) {
                name = "高限制线";
            }
            LimitLine hightLimit = new LimitLine(high, name);
            hightLimit.setLineWidth(4f);
            hightLimit.setTextSize(10f);
            hightLimit.setLineColor(color);
            hightLimit.setTextColor(color);
            leftAxis.addLimitLine(hightLimit);
            mBarChart.invalidate();
        }

        /**
         * 设置低限制线
         *
         * @param low
         * @param name
         */
        public void setLowLimitLine(int low, String name) {
            if (name == null) {
                name = "低限制线";
            }
            LimitLine hightLimit = new LimitLine(low, name);
            hightLimit.setLineWidth(4f);
            hightLimit.setTextSize(10f);
            leftAxis.addLimitLine(hightLimit);
            mBarChart.invalidate();
        }

        /**
         * 设置描述信息
         *
         * @param str
         */
        public void setDescription(String str) {
            Description description = new Description();
            description.setText(str);
            mBarChart.setDescription(description);
            mBarChart.invalidate();
        }
    }
}
