package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class jadwalseminar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwalseminar);
    }

    public void bekk(View view){
        Intent back = new Intent(jadwalseminar. this,MainActivity.class);
        startActivity(back);
    }
}