package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {

    TextInputEditText editUsername, editPassword;
    Button loginbutton;

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

                if(TextUtils.isEmpty(editUsername.getText().toString()) || TextUtils.isEmpty(editPassword.getText().toString())){
                    Toast.makeText(login.this, "username/Password Required", Toast.LENGTH_LONG).show();
                }
                else{
                    login();
                }
            }
        });
    }

    public void login(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(editUsername.getText().toString());
        loginRequest.setPassword(editPassword.getText().toString());
        Call<LoginResponse> loginResponseCall = ApiClient.getUserService().userlogin(loginRequest);
        loginResponseCall.enqueue((new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(login.this, "Login Successfull", Toast.LENGTH_LONG).show();
                    LoginResponse loginResponse = response.body();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(login. this,MainActivity.class).putExtra("data", loginResponse.getName()));
                        }
                    }, 700);
                }
                else{
                    Toast.makeText(login.this, "Login failed - Missing Credentials", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(login.this, "Throwable"+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        }));
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