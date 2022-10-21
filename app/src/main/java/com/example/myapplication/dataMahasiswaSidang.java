package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.models.list_mahasiswa_sidang;

import java.util.ArrayList;

public class dataMahasiswaSidang extends AppCompatActivity {
    private static String[] namaMSidang = {
            "Sefza Auma",
            "Dean Fisabil",
            "Al Hafiz",
            "Nadiem Makarim"

    };

    private static String[] judul = {
            "Machine Learning pada balblablabla",
            "Penerapan SPK dalam blalablabla",
            "Flutter abcdfr",
            "ERP pada toko xyz"

    };

    private static String[] jadwal = {
            "Senin, 1 Oktober 2022",
            "Senin, 2 Oktober 2022",
            "Senin, 3 Oktober 2022",
            "Senin, 4 Oktober 2022"

    };

    private static Integer[] photo = {
            R.drawable.ic_avatar1,
            R.drawable.ic_avatar2,
            R.drawable.ic_avatar3,
            R.drawable.ic_avatar4

    };

    static ArrayList<list_mahasiswa_sidang> getListData(){
        ArrayList<list_mahasiswa_sidang> list = new ArrayList<>();
        for (int position = 0; position<namaMSidang.length; position++){
            list_mahasiswa_sidang data = new list_mahasiswa_sidang();
            data.setNamaMSidang(namaMSidang[position]);
            data.setJudul(judul[position]);
            data.setJadwal(jadwal[position]);
            data.setPhoto(photo[position]);
            list.add(data);


        }
        return list;
    };


}