package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.Adapter.listSidangAdapter;
import com.example.myapplication.models.list_mahasiswa_sidang;

import java.util.ArrayList;

public class listPermintaanSidang extends AppCompatActivity {
    private RecyclerView rvSidang;
    private ArrayList<list_mahasiswa_sidang> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_permintaan_sidang);

        rvSidang = findViewById(R.id.rv_sidang);
        rvSidang.setHasFixedSize(true);

        list.addAll(dataMahasiswaSidang.getListData());
        showRecyclerList();
    }

    private  void showRecyclerList(){
        rvSidang.setLayoutManager(new LinearLayoutManager(this));
        listSidangAdapter listClubAdapter = new listSidangAdapter(list);
        rvSidang.setAdapter(listClubAdapter);
    }
}