package com.example.aplikasisupi;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.aplikasisupi.model.ReadSensorItem;
import com.example.aplikasisupi.model.ResponseGetData;
import com.example.aplikasisupi.network.ConfigRetrofit;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Grafik extends AppCompatActivity {
    double x, y;
    List<ReadSensorItem> dataItem = new ArrayList<>();
    GraphView graph;
    LineGraphSeries<DataPoint> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafik);

         graph = (GraphView) findViewById(R.id.graph);

         fetchData();
        //versi 1
    }

    private void fetchData() {
        ConfigRetrofit.getInstance().dataMasuk().enqueue(new Callback<ResponseGetData>() {
            @Override
            public void onResponse(Call<ResponseGetData> call, Response<ResponseGetData> response) {
                if (response.isSuccessful()) {
//                    Toast.makeText(MainActivity.this, String.valueOf(response.body().getResult().size()), Toast.LENGTH_SHORT).show();
                    if (response.body().getReadSensor().size() > 0) {
                        dataItem = response.body().getReadSensor();
                        initdataToGraphView();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseGetData> call, Throwable t) {
                Toast.makeText(Grafik.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    Date date;
    private void initdataToGraphView() {
        series = new LineGraphSeries<DataPoint>();

        for (int i=dataItem.size()-1; i>=0; i--) {
            @SuppressLint("SimpleDateFormat") SimpleDateFormat curTime = new SimpleDateFormat("hh:mm:ss");
            try {
                date = curTime.parse(dataItem.get(i).getWaktu());
            } catch (ParseException e) {
                e.printStackTrace();
            } finally {
                series.appendData(new DataPoint(date,
                        Double.parseDouble(dataItem.get(i).getSuhu())), true, 10);
            }

        }
        graph.addSeries(series);
    }
}
