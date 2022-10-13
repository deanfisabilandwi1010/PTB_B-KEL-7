package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class login extends AppCompatActivity {

    TextInputEditText editUsername, editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
    }

    public void login(View view){
        Intent ceklogin = new Intent(login. this,MainActivity.class);
        String username  = editUsername.getText().toString();
        String password = editPassword.getText().toString();
        ceklogin.putExtra("USERNAME", username);
        ceklogin.putExtra("password", password);
        ceklogin.putExtra("ISLOGGEDIN", true);
        startActivity(ceklogin);
    }
}