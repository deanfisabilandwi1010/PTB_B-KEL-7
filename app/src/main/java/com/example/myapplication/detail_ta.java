package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class detail_ta extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ta);

    }

    public void onClickButtonLogbook (View view){
        Intent kelogbook = new Intent( this, list_logbook.class);
        startActivity(kelogbook);
    }
    public void onClickButtonListPesertaSeminar (View view){
        Intent listseminar = new Intent(this, list_peserta_seminar.class);
        startActivity(listseminar);
    }
}