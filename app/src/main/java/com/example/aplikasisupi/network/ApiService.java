package com.example.aplikasisupi.network;


import com.example.aplikasisupi.model.ResponseGetData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("read.php")
    Call<ResponseGetData> dataMasuk();
}
