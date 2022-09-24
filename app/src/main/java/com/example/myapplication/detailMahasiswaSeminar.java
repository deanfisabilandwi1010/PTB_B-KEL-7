package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class detailMahasiswaSeminar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mahasiswa_seminar);
    }
    public void tambahDosenSeminar(View view){
        Intent tambah = new Intent(detailMahasiswaSeminar. this, listDosenSeminar.class);
        startActivity(tambah);
    }
}