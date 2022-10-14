package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class detailpermintaanTA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailpermintaan_ta);
    }

    public void gantiDosen(View view){
        Intent gantiDosen = new Intent(detailpermintaanTA. this,gantiDosenPem.class);
        startActivity(gantiDosen);

    }
    public void kembali(View view){
        Intent kembali = new Intent(detailpermintaanTA. this,listtugasakhir.class);
        startActivity(kembali);

    }






}