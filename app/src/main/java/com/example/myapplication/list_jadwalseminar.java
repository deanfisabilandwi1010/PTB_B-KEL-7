//package com.example.myapplication;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//
//import com.example.myapplication.models.jadwal_seminar;
//
//
//import java.util.ArrayList;
//
//public class list_jadwalseminar extends AppCompatActivity {
//    private RecyclerView rv_jdwlSeminar;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_list_jadwalseminar);
//
//        rv_jdwlSeminar = findViewById(R.id.rv_jdwlsem);
//
//        jdwl_seminarAdapter adapter = new jdwl_seminarAdapter(getlistSeminar());
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//
//        rv_jdwlSeminar.setLayoutManager(layoutManager);
//        rv_jdwlSeminar.setAdapter(adapter);
//    }
//
//    public void mainmenu(View view){
//        Intent mainmenu = new Intent(list_jadwalseminar. this,MainActivity.class);
//        startActivity(mainmenu);
//
//    }
//
//    public ArrayList<jadwal_seminar> getlistSeminar(){
//        ArrayList<jadwal_seminar> list_seminar = new ArrayList<>();
//
//        list_seminar.add(new jadwal_seminar(
//                null,
//                "Firhan Hadi Yoza",
//                "Mobile APP BMKG",
//                "Seminar E (11-01-2022) 05.00 P.M.",
//                "Prof. Surya Afnarius"
//        ));
//        list_seminar.add(new jadwal_seminar(
//                null,
//                "Muhammad Raihan Reynaldi",
//                "E-Commerce 'KomPoser'",
//                "Seminar E (12-01-2022) 01.00 P.M",
//                "Husnil Kamil,MT"
//        ));
//
//        list_seminar.add(new jadwal_seminar(
//                null,
//                "Muhammad Raihan Zuhdi",
//                "Bank Sampah Online",
//                "Seminar C (12-01-2022) 03.00 PM",
//                "Ricky Akbar, M.Kom"
//        ));
//
//        return list_seminar;
//
//    }
//}