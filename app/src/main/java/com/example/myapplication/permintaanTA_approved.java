package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class permintaanTA_approved extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permintaan_ta_approved);
    }

    public void bekkk(View view){
        Intent bekkk = new Intent(permintaanTA_approved. this,listtugasakhir.class);
        startActivity(bekkk);

    }

}