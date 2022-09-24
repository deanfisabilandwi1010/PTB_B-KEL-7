package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logout(View view){
        Intent keluar = new Intent(MainActivity. this,login.class);
        startActivity(keluar);

    }

    public void jdwlsidang(View view){
        Intent jdwlsid = new Intent(MainActivity. this,jadwalsidang.class);
        startActivity(jdwlsid);

    }

    public void jdwlseminar(View view){
        Intent jdwlsmnr = new Intent (MainActivity. this,jadwalseminar.class);
        startActivity(jdwlsmnr);
    }

    public void listta(View view){
        Intent listtamhs = new Intent (MainActivity. this,listtugasakhir.class);
        startActivity(listtamhs);
    }

    public void permintaanSeminar(View view){
        Intent pSeminar = new Intent (MainActivity. this,listPermintaanSeminar.class);
        startActivity(pSeminar);
    }

    public void permintaanSidang(View view){
        Intent pSidang = new Intent (MainActivity. this,listPermintaanSidang.class);
        startActivity(pSidang);
    }

}