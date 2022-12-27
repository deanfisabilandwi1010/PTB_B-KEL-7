package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.datamodels.LoginResponse;
import com.example.myapplication.retrofit.RetrofitClient;
import com.example.myapplication.retrofit.apiClient;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {

    TextInputEditText editUsername, editPassword;
    Button loginbutton;
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        loginbutton = findViewById(R.id.loginbutton);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = editUsername.getText().toString();
                password = editPassword.getText().toString();


                apiClient mainInterface = RetrofitClient.getService();
                Call<LoginResponse> call = mainInterface.login(username,password);
                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        String message = null;
                        JSONObject jsonObject = null;
                        LoginResponse loginResponse = response.body();
                        if(loginResponse.getStatus() != "")
                        {
                            String token = loginResponse.getAuthorisation().getToken();
                            String name = loginResponse.getUser().getName();
                            String username2 = loginResponse.getUser().getUsername();
                            String email = loginResponse.getUser().getEmail();

                            Log.i("success", token);
                            SharedPreferences sharedPreferences = getSharedPreferences("com.example.myapplication.SHARED_KEY",MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("token",token);
                            editor.putString("name",name);
                            editor.putString("username",username2);
                            editor.putString("email",email);

                            Log.d("email",email);
                            editor.apply();
                            Intent login = new Intent(login.this, MainActivity.class);
                            startActivity(login);
                        }
                        else
                        {
                            message = loginResponse.getStatus();
                            Toast.makeText(login.this, message , Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Toast.makeText(login.this,t.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


//        loginbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if(TextUtils.isEmpty(editUsername.getText().toString()) || TextUtils.isEmpty(editPassword.getText().toString())){
//                    Toast.makeText(login.this, "username/Password Required", Toast.LENGTH_LONG).show();
//                }
//                else{
//                    login();
//                }
//            }
//        });
//    }

//    public void login(){
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername(editUsername.getText().toString());
//        loginRequest.setPassword(editPassword.getText().toString());
//        Call<LoginResponse> loginResponseCall = ApiClient.getUserService().userlogin(loginRequest);
//        loginResponseCall.enqueue((new Callback<LoginResponse>() {
//            @Override
//            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//                if(response.isSuccessful()){
//                    Toast.makeText(login.this, "Login Successfull", Toast.LENGTH_LONG).show();
//                    LoginResponse loginResponse = response.body();
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            startActivity(new Intent(login. this,MainActivity.class).putExtra("data", loginResponse.getName()));
//                        }
//                    }, 700);
//                }
//                else{
//                    Toast.makeText(login.this, "Login failed - Missing Credentials", Toast.LENGTH_LONG).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<LoginResponse> call, Throwable t) {
//                Toast.makeText(login.this, "Throwable"+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
//            }
//        }));
    }
//    public void login(View view){
//        Intent ceklogin = new Intent(login. this,MainActivity.class);
//        String username  = editUsername.getText().toString();
//        String password = editPassword.getText().toString();
//        ceklogin.putExtra("USERNAME", username);
//        ceklogin.putExtra("password", password);
//        ceklogin.putExtra("ISLOGGEDIN", true);
//        startActivity(ceklogin);
//    }


}