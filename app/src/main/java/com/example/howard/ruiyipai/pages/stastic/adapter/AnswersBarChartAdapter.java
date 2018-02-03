package com.example.howard.ruiyipai.pages.stastic.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.howard.ruiyipai.R;
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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by howard on 2018/1/14.
 * Email 158988127@qq.com
 */

public class AnswersBarChartAdapter extends RecyclerView.Adapter<AnswersBarChartAdapter.ViewHolder> {

    private int mCount;

    private Context mContext;

    public AnswersBarChartAdapter(Context context, int count) {
        mCount = count;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 实例化展示的view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_answer_detail_bar_chart, parent, false);
        // 实例化viewholder
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
//        holder.mScreenNo.setText(String.valueOf(position+1));
        initBarChart(holder.mBarChart);
    }

    @Override
    public int getItemCount() {
        return mCount;
    }

    private void initBarChart(BarChart answerBarChart) {

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
        colors.add(ContextCompat.getColor(mContext, R.color.bar_chart_red));
        colors.add(ContextCompat.getColor(mContext, R.color.bar_chart_blue));
        colors.add(ContextCompat.getColor(mContext, R.color.bar_chart_blue));
        colors.add(ContextCompat.getColor(mContext, R.color.bar_chart_blue));
        colors.add(ContextCompat.getColor(mContext, R.color.bar_chart_blue));
        colors.add(ContextCompat.getColor(mContext, R.color.bar_chart_blue));
        colors.add(ContextCompat.getColor(mContext, R.color.bar_chart_blue));

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
//        answerBarChart.animateY(1000, Easing.EasingOption.Linear);


        Description desc = new Description();
        desc.setText("");

        answerBarChart.setDescription(desc);



//        Matrix matrix = new Matrix();
//        matrix.postScale(1.5f, 1f);
//        answerBarChart.getViewPortHandler().refresh(matrix, answerBarChart, false);




    }



    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.bc_chart)
        BarChart mBarChart;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

}

