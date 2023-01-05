package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.Adapter.pesertaseminarAdapter;
import com.example.myapplication.models.logbook;
import com.example.myapplication.models.pesertaseminar;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;

public class list_peserta_seminar extends AppCompatActivity implements pesertaseminarAdapter.ItempsClickListener {
    private RecyclerView rvps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_peserta_seminar);

        rvps = findViewById(R.id.rv_ps);

        pesertaseminarAdapter adapter = new pesertaseminarAdapter(getpesertaseminar());
        adapter.setListener((pesertaseminarAdapter.ItempsClickListener) this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvps.setLayoutManager(layoutManager);
        rvps.setAdapter(adapter);
    }

    public ArrayList<pesertaseminar> getpesertaseminar() {
        ArrayList<pesertaseminar> list_ps = new ArrayList<>();

        list_ps.add(new pesertaseminar(

                "Ahmad Fauzan",
                "1911523020"

        ));

        list_ps.add(new pesertaseminar(

                "Muhammad Al Hafiz",
                "1911523015"
        ));

        list_ps.add(new pesertaseminar(

                "M Kevin Beslia",
                "1911523009"
        ));

        list_ps.add(new pesertaseminar(

                "M Rafvy Octa Nugraha",
                "1911523007"
        ));

        list_ps.add(new pesertaseminar(

                "M Farhan Zuhdi",
                "1911522030"
        ));
        list_ps.add(new pesertaseminar(

                "Fauzan Maizardi",
                "1911523019"
        ));
        list_ps.add(new pesertaseminar(

                "Dhiya Nabila Denta",
                "1911523021"
        ));
        list_ps.add(new pesertaseminar(

                "M Afdhal Syafli",
                "1911523023"
        ));
        list_ps.add(new pesertaseminar(

                "William Wahyu",
                "1911523001"
        ));


        return list_ps;
    }

    @Override
    public void onItemListpesertaseminar(pesertaseminar pesertaseminar) {

    }

    @Override
    public void onItempsClick(pesertaseminar pesertaseminar) {
    }
}