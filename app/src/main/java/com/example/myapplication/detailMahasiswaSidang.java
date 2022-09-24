package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class detailMahasiswaSidang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mahasiswa_sidang);
    }
    public void tambahDosenSidang(View view){
        Intent tambah = new Intent(detailMahasiswaSidang. this, listDosenSidang.class);
        startActivity(tambah);
    }
}