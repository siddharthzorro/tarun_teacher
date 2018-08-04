package com.example.siddharth.tarun_teacher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.numetriclabz.numandroidcharts.BarChart;
import com.numetriclabz.numandroidcharts.ChartData;

import java.util.ArrayList;
import java.util.List;

public class test extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar);
        BarChart chart=findViewById(R.id.bar_chart);
        List<ChartData> data=new ArrayList<>();
        data.add(new ChartData(1f,"M"));
        data.add(new ChartData(2f,"T"));
        data.add(new ChartData(3f,"W"));
        data.add(new ChartData(5f,"T"));
        data.add(new ChartData(6f,"F"));
        data.add(new ChartData(7f,"S"));
        data.add(new ChartData(4f,"S"));
         chart.setData(data);
    }
}
