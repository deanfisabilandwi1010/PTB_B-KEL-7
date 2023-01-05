package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class halaman_TA extends AppCompatActivity {

    TextView getTextViewJudultgsakhir, getTextViewNamaMHSA, getTexttanggal,getTextAbstract;
    String judulTA, nama, tanggal, abstrak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_ta);

        Intent intentTA = getIntent();
        if(intentTA != null){
            judulTA = intentTA.getStringExtra("judulTA");
            nama = intentTA.getStringExtra("nama");
            tanggal = intentTA.getStringExtra("tanggal");
            abstrak = intentTA.getStringExtra("abstrak");

            getTextViewJudultgsakhir = findViewById(R.id.textJTA);
            getTextViewJudultgsakhir.setText((judulTA));
            getTextViewNamaMHSA = findViewById(R.id.text_NMMHS);
            getTextViewNamaMHSA.setText(nama);
            getTexttanggal = findViewById(R.id.textNIMMHS);
            getTexttanggal.setText(tanggal);
            getTextAbstract = findViewById(R.id.textAbstractMHS);
            getTextAbstract.setText(abstrak);

        }
}
}