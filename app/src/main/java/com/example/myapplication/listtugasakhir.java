package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.Adapter.ta_mahasiswaAdapter;
import com.example.myapplication.models.ta_mahasiswa;

import java.util.ArrayList;

public class listtugasakhir extends AppCompatActivity {
    private RecyclerView rv_ta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listtugasakhir);

        rv_ta = findViewById(R.id.rv_ta);

        ta_mahasiswaAdapter adapter = new ta_mahasiswaAdapter(getlist_TA());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rv_ta.setLayoutManager(layoutManager);
        rv_ta.setAdapter(adapter);


    }

    public void bekk(View view){
        Intent back = new Intent(listtugasakhir. this,MainActivity.class);
        startActivity(back);
    }

    public ArrayList<ta_mahasiswa> getlist_TA(){
        ArrayList<ta_mahasiswa> list_ta = new ArrayList<>();

        list_ta.add(new ta_mahasiswa(
                null,
                "Dean Fisabil Andwi",
                "SPK Pemilihan Bank Terbaik",
                "Ricky Akbar,MT"
        ));

        list_ta.add(new ta_mahasiswa(
                null,
                "Sefza Auma Tiang Alam",
                "SPK Pemilihan Kopi Terbaik",
                "Ricky Akbar,M.Kom"
        ));

        list_ta.add(new ta_mahasiswa(
                null,
                "Dean Fisabil Andwi",
                "SPK Pemilihan Bank Terbaik",
                "Ricky Akbar,M.Kom"
        ));

        list_ta.add(new ta_mahasiswa(
                null,
                "Muhammad Afif",
                "Pembuatan E-Commerce AXIS",
                "Husnil Kamil,MT"
        ));

        return list_ta;

    }






}