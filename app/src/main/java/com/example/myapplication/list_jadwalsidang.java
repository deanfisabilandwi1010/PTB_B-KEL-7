package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.Adapter.jdwl_sidangAdapter;
import com.example.myapplication.models.jadwal_sidang;

import java.util.ArrayList;

public class list_jadwalsidang extends AppCompatActivity {
    private RecyclerView rv_jdwlSidang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_jadwalsidang);

        rv_jdwlSidang = findViewById(R.id.rv_jdwlsid);

        jdwl_sidangAdapter adapter = new jdwl_sidangAdapter(getlistSidang());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rv_jdwlSidang.setLayoutManager(layoutManager);
        rv_jdwlSidang.setAdapter(adapter);
    }

    public void mainmenu(View view){
        Intent mainmenu = new Intent(list_jadwalsidang. this,MainActivity.class);
        startActivity(mainmenu);

    }

    public ArrayList<jadwal_sidang> getlistSidang(){
        ArrayList<jadwal_sidang> list_sidang = new ArrayList<>();

        list_sidang.add(new jadwal_sidang(
                null,
                "Dean Fisabil Andwi",
                "SPK Pemilihan Bank Terbaik",
                "Seminar E (11-01-2022) 05.00 P.M.",
                "Prof. Surya Afnarius"
        ));
        list_sidang.add(new jadwal_sidang(
                null,
                "Sefza Auma Tiang Alam",
                "SPK Pemilihan E Commerce Terbaik",
                "Seminar E (12-01-2022) 01.00 P.M",
                "Prof. Surya Afnarius"
        ));

        list_sidang.add(new jadwal_sidang(
                null,
                "Muhammad Afif",
                "SPK Pemilihan Tempat Bermain Anak",
                "Seminar C (12-01-2022) 03.00 PM",
                "Ricky Akbar, M.Kom"
        ));

        return list_sidang;

    }



}