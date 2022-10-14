package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.Adapter.dosen_pembimbingAdapter;
import com.example.myapplication.models.dosen_pembimbing;

import java.util.ArrayList;

public class gantiDosenPem extends AppCompatActivity {
    private RecyclerView rvdosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganti_dosen_pem);

        rvdosen = findViewById(R.id.rv_doping);

        dosen_pembimbingAdapter dosenAdapter = new dosen_pembimbingAdapter(getList_Dosen());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvdosen.setLayoutManager(layoutManager);
        rvdosen.setAdapter(dosenAdapter);
    }

    public ArrayList<dosen_pembimbing> getList_Dosen(){
        ArrayList<dosen_pembimbing> list_dosen = new ArrayList<>();

        list_dosen.add(new dosen_pembimbing(
                null,
                "Ricky Akbar,M.Kom",
                "1930129932192922",
                "Bussiness Intelligence"
        ));

        list_dosen.add(new dosen_pembimbing(
                null,
                "Husnil Kamil,MT",
                "193012993219123122",
                "Android Programming"
        ));
        list_dosen.add(new dosen_pembimbing(
                null,
                "Prof. Surya Afnarius, P.HD",
                "19301299321929133",
                "GIS"
        ));
        list_dosen.add(new dosen_pembimbing(
                null,
                "Rahmatik Pratama Santi, MT",
                "1930129932192921222",
                "Database Analysis"
        ));
        list_dosen.add(new dosen_pembimbing(
                null,
                "Rahmat Suryana",
                "19301299321929122",
                "E-Bisnis Modelling"
        ));


        return list_dosen;

    }
}