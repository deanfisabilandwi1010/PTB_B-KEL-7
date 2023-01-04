package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.list_mahasiswaAdapter;
import com.example.myapplication.models.list_mahasiswa_ta;
import com.example.myapplication.models.ta_mahasiswa;

import java.util.ArrayList;

public class cari_mahasiswa extends AppCompatActivity implements list_mahasiswaAdapter.itemMahasiswaClickListener{
    private RecyclerView rvcm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_mahasiswa);

        rvcm = findViewById(R.id.rv_cm);

        list_mahasiswaAdapter adapter = new list_mahasiswaAdapter(getlist_mahasiswa());
        adapter.setListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvcm.setLayoutManager(layoutManager);
        rvcm.setAdapter(adapter);
    }

    public void detail_ta(View view) {
        Intent kedetail = new Intent(this, detail_ta.class);
        startActivity(kedetail);


    }

    public ArrayList<list_mahasiswa_ta> getlist_mahasiswa(){
        ArrayList<list_mahasiswa_ta> list_ta = new ArrayList<>();

        list_ta.add(new list_mahasiswa_ta(
                null,
                "Dean Fisabil Andwi",
                "SPK Pemilihan Bank Terbaik",
                "Ricky Akbar,MT"
        ));

        list_ta.add(new list_mahasiswa_ta(
                null,
                "Sefza Auma Tiang Alam",
                "SPK Pemilihan Kopi Terbaik",
                "Ricky Akbar,M.Kom"
        ));

        list_ta.add(new list_mahasiswa_ta(
                null,
                "Muhammad Zaky",
                "SPK Lokasi Bank Sampah terbaik",
                "Ricky Akbar,M.Kom"
        ));

        list_ta.add(new list_mahasiswa_ta(
                null,
                "Muhammad Afif",
                "Pembuatan E-Commerce AXIS",
                "Husnil Kamil,MT"
        ));

        list_ta.add(new list_mahasiswa_ta(
                null,
                "Thomas Akram Ferdinand",
                "Pemrograman Aplikasi Booking Android",
                "Prof. Surya Afnarius, P.Hd"
        ));


        return list_ta;

    }


    @Override
    public void onItemListMahasiswa(list_mahasiswa_ta listMahasiswaTa) {
        Intent detailTAOld = new Intent(this, detail_ta.class);
        detailTAOld.putExtra("nama_mahasiswa", listMahasiswaTa.getNamamahasiswa());
        detailTAOld.putExtra("judul_TA", listMahasiswaTa.getJudul_ta());
        detailTAOld.putExtra("dosping_old", listMahasiswaTa.getPembimbing());
        startActivity(detailTAOld);
    }
}