package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserServices {
 @POST("/api/login")
 Call<LoginResponse> userlogin(@Body LoginRequest loginRequest);

}
