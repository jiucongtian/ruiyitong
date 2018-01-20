package com.example.howard.ruiyipai.pages;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import com.example.howard.ruiyipai.R;
import com.example.howard.ruiyipai.base.BaseActivity;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by howard on 2018/1/19.
 * Email 158988127@qq.com
 */

public class TestActivity extends BaseActivity {

    @BindView(R.id.lineChart)
    LineChart mLineChart;

    @BindView(R.id.barChart)
    BarChart mBarChart;

    @Override
    public void initPages() {
        initLineChart();

        initBarchart();

    }

    private void initLineChart() {
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
        entries2.add(new Entry(49, (float) 2));
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
        xAxis.setDrawAxisLine(true);                        //x坐标轴线
        xAxis.setDrawGridLines(true);                      //x坐标轴竖线
        xAxis.setLabelRotationAngle(-60f);                  //x轴旋转角度
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//设置x坐标轴显示在下边
        xAxis.setLabelCount(19, true);
        xAxis.setTextSize(10);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return "警戒线";
            }
        });

        //设置x轴个数
        Class<? extends AxisBase > clazz = AxisBase.class;

        try {
            Field nameField = clazz.getDeclaredField("mLabelCount");
            nameField.setAccessible(true);// 设置操作权限为true
            nameField.set(xAxis, 50);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //test



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
        mLineChart.animateX(3000);                           //设置动画

        Description desc = new Description();
        desc.setText("");

        mLineChart.setDescription(desc);
    }

    private void initBarchart() {

        BarChartManager barChartManager = new BarChartManager(mBarChart);


        //设置x轴的数据
        ArrayList<Float> xValues = new ArrayList<>();
        for (int i = 0; i <= 4; i++) {
            xValues.add((float) i);
        }

        //设置y轴的数据()
        List<List<Float>> yValues = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            List<Float> yValue = new ArrayList<>();
            for (int j = 0; j <= 4; j++) {
                yValue.add((float) (Math.random() * 80));
            }
            yValues.add(yValue);
        }

        //颜色集合
        List<Integer> colours = new ArrayList<>();
        colours.add(Color.GREEN);
        colours.add(Color.BLUE);
//        colours.add(Color.RED);
//        colours.add(Color.CYAN);

        //线的名字集合
        List<String> names = new ArrayList<>();
        names.add("折线一");
        names.add("折线二");
        names.add("折线三");
        names.add("折线四");

        barChartManager.showBarChart(xValues, yValues, names, colours);
        barChartManager.setXAxis(11f, 0f, 11);


//        barChartManager.showBarChart(xValues, yValues.get(0), names.get(1), colours.get(0));

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
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
