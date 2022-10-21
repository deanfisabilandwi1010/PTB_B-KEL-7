package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.Adapter.ta_mahasiswaAdapter;
import com.example.myapplication.models.ta_mahasiswa;

import java.util.ArrayList;

public class listtugasakhir extends AppCompatActivity implements ta_mahasiswaAdapter.ItemPermintaanTAClickListener {
    private RecyclerView rvta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listtugasakhir);

        rvta = findViewById(R.id.rv_ta);

        ta_mahasiswaAdapter adapter = new ta_mahasiswaAdapter(getlist_TA());
        adapter.setListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvta.setLayoutManager(layoutManager);
        rvta.setAdapter(adapter);

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
                "Muhammad Zaky",
                "SPK Lokasi Bank Sampah terbaik",
                "Ricky Akbar,M.Kom"
        ));

        list_ta.add(new ta_mahasiswa(
                null,
                "Muhammad Afif",
                "Pembuatan E-Commerce AXIS",
                "Husnil Kamil,MT"
        ));

        list_ta.add(new ta_mahasiswa(
                null,
                "Thomas Akram Ferdinand",
                "Pemrograman Aplikasi Booking Android",
                "Prof. Surya Afnarius, P.Hd"
        ));


        return list_ta;

    }


    @Override
    public void onItemPermintaanTAClick(ta_mahasiswa taMahasiswa) {
       Intent detailTAOld = new Intent(this, detailpermintaanTA.class);
        detailTAOld.putExtra("nama_mahasiswa", taMahasiswa.getNama());
        detailTAOld.putExtra("judul_TA", taMahasiswa.getJudul());
        detailTAOld.putExtra("dosping_old", taMahasiswa.getDoping());
       startActivity(detailTAOld);
    }
}