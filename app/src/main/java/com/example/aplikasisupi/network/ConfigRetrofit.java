package com.example.aplikasisupi.network;


import com.example.aplikasisupi.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfigRetrofit {
    public static Retrofit setInit() {
        return new Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }
    public static ApiService getInstance() {return setInit().create(ApiService.class);}


}
