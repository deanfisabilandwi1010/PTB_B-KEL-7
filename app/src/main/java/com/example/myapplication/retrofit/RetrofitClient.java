package com.example.myapplication.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.Route;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";
    private static apiClient service;

    public static apiClient getService() {

        if (service == null) {

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            Retrofit.Builder builder = new Retrofit.Builder().baseUrl(API_BASE_URL).addConverterFactory(GsonConverterFactory.create());
            Retrofit retrofit = builder.client(httpClient.build()).build();

            service = retrofit.create(apiClient.class);
        }
        return service;

    }
    public apiClient configRetrofit () {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiClient apiClient = retrofit.create(apiClient.class);
        return apiClient;
    }
}

