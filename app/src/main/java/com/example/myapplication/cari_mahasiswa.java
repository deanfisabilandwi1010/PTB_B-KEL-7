package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class cari_mahasiswa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_mahasiswa);
    }

    public void detail_ta(View view) {
        Intent kedetail = new Intent(this, detail_ta.class);
        startActivity(kedetail);

    }
}