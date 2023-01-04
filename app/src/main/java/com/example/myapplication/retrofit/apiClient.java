package com.example.myapplication.retrofit;

import com.example.myapplication.datamodels.LoginResponse;
import com.example.myapplication.datamodels.LogoutResponse;
import com.example.myapplication.datamodels.PermintaanTAResponse;
import com.example.myapplication.datamodels.Student;
import com.example.myapplication.datamodels.TAResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface apiClient {
    @FormUrlEncoded
    @POST("api/login")
    Call<LoginResponse> login (
            @Field("username")String username,
            @Field("password")String password
    );
    @POST("api/logout")
    Call<LogoutResponse> logout (
            @Header("Authorization") String token
    );

    @GET("api/admin/thesis-submissions")
    Call<PermintaanTAResponse> getPTA (
            @Header("Authorization")String token

    );

    @GET("/api/admin/theses")
    Call<TAResponse> responseTA (
            @Header("Authorization")String token

    );



}
