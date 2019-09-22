package com.example.aplikasisupi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.aplikasisupi.adapter.AdapterGetData;
import com.example.aplikasisupi.model.ReadSensorItem;
import com.example.aplikasisupi.model.ResponseGetData;
import com.example.aplikasisupi.network.ConfigRetrofit;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    AdapterGetData adapterGetData;
    List<ReadSensorItem> dataItem = new ArrayList<>();
    RecyclerView rvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvData = findViewById(R.id.rv_data);

        fetchData();
    }

    private void fetchData() {
        ConfigRetrofit.getInstance().dataMasuk().enqueue(new Callback<ResponseGetData>() {
            @Override
            public void onResponse(Call<ResponseGetData> call, Response<ResponseGetData> response) {
                if (response.isSuccessful()) {
//                    Toast.makeText(MainActivity.this, String.valueOf(response.body().getResult().size()), Toast.LENGTH_SHORT).show();
                    if (response.body().getReadSensor().size() > 0) {
                        dataItem = response.body().getReadSensor();
                        initDataToRecyclerView();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseGetData> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initDataToRecyclerView() {
        adapterGetData = new AdapterGetData(getApplicationContext(), dataItem);
        rvData.setAdapter(adapterGetData);
        rvData.setLayoutManager(new LinearLayoutManager(this));
        rvData.setHasFixedSize(true);
    }
}


