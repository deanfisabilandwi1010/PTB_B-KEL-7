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

                "Ahmad Fauzan",
                "1911523020"
        ));

        list_ps.add(new pesertaseminar(

                "Ahmad Fauzan",
                "1911523020"
        ));

        list_ps.add(new pesertaseminar(

                "Ahmad Fauzan",
                "1911523020"
        ));

        list_ps.add(new pesertaseminar(

                "Ahmad Fauzan",
                "1911523020"
        ));
        list_ps.add(new pesertaseminar(

                "Ahmad Fauzan",
                "1911523020"
        ));
        list_ps.add(new pesertaseminar(

                "Ahmad Fauzan",
                "1911523020"
        ));
        list_ps.add(new pesertaseminar(

                "Ahmad Fauzan",
                "1911523020"
        ));
        list_ps.add(new pesertaseminar(

                "Ahmad Fauzan",
                "1911523020"
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