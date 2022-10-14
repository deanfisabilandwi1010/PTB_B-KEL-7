package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class detailpermintaanTA extends AppCompatActivity {

    String nama_dosping;
    TextView textDospingTA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailpermintaan_ta);

        Intent detailTA = getIntent();
        if(detailTA != null){
            nama_dosping = detailTA.getStringExtra("nama_dosping");
            textDospingTA = findViewById(R.id.textDospingTA);
            textDospingTA.setText(nama_dosping);
        }
    }

    public void gantiDosen(View view){
        Intent gantiDosen = new Intent(detailpermintaanTA. this,gantiDosenPem.class);
        startActivity(gantiDosen);

    }
    public void kembali(View view){
        Intent kembali = new Intent(detailpermintaanTA. this,listtugasakhir.class);
        startActivity(kembali);

    }

    public void approve(View view){
        Intent approve = new Intent(detailpermintaanTA. this,permintaanTA_approved.class);
        startActivity(approve);

    }





}