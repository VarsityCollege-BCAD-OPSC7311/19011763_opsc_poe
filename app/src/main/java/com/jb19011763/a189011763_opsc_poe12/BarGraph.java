package com.jb19011763.a189011763_opsc_poe12;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class BarGraph extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_graph);

        BarChart barChart = findViewById(R.id.BarChart);

        ArrayList<BarEntry> Height = new ArrayList<>();
        ArrayList<BarEntry> Weight = new ArrayList<>();
        ArrayList<BarEntry> Calories = new ArrayList<>();
        //User.add(new BarEntry())


        BarDataSet barDataSet = new BarDataSet(Height, "Height");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarDataSet barDataSet1 = new BarDataSet(Weight, "Weight");
        barDataSet1.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet1.setValueTextColor(Color.BLACK);
        barDataSet1.setValueTextSize(16f);

        BarDataSet barDataSet2 = new BarDataSet(Calories, "Calories");
        barDataSet2.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet2.setValueTextColor(Color.BLACK);
        barDataSet2.setValueTextSize(16f);

        BarData barData = new BarData(barDataSet);

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("Bar Chart showing Health Attributes");
        barChart.animateY(2000);

    }
}