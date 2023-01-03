package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.Adapter.ta_mahasiswaAdapter;
import com.example.myapplication.Adapter.uasAdapter;
import com.example.myapplication.datamodels.PermintaanTAResponse;
import com.example.myapplication.datamodels.ThesisItem;
import com.example.myapplication.models.ta_mahasiswa;
import com.example.myapplication.retrofit.RetrofitClient;
import com.example.myapplication.retrofit.apiClient;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class listtugasakhir extends AppCompatActivity {
    private RecyclerView rvta;
    private uasAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listtugasakhir);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.myapplication.SHARED_KEY",MODE_PRIVATE);
        String token = sharedPreferences.getString("tokenLogin","");

        rvta = findViewById(R.id.rv_ta);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvta.setLayoutManager(layoutManager);
        adapter = new uasAdapter();
        rvta.setAdapter(adapter);

        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

        apiClient client = retrofit.create(apiClient.class);

        Call<PermintaanTAResponse> call = client.getPTA("Bearer " + token);
        call.enqueue(new Callback<PermintaanTAResponse>() {


            @Override
            public void onResponse(Call<PermintaanTAResponse> call, Response<PermintaanTAResponse> response) {
                PermintaanTAResponse permintaanTAResponse = response.body();
                if(permintaanTAResponse != null){
                    List<ThesisItem> thesis = permintaanTAResponse.getThesis();
                    adapter.setItemList(thesis);
                }
            }

            @Override
            public void onFailure(Call<PermintaanTAResponse> call, Throwable t) {

            }
        });
    }

    public void bekk(View view){
        Intent back = new Intent(listtugasakhir. this,MainActivity.class);
        startActivity(back);
    }

//    public ArrayList<ta_mahasiswa> getlist_TA(){
//        ArrayList<ta_mahasiswa> list_ta = new ArrayList<>();
//
//        list_ta.add(new ta_mahasiswa(
//                null,
//                "Dean Fisabil Andwi",
//                "SPK Pemilihan Bank Terbaik",
//                "34",
//                "2011521010",
//                "2016"
//        ));
//
//        list_ta.add(new ta_mahasiswa(
//                null,
//                "Pawal Atakosi",
//                "SPK Pemilihan Pupuk Terbaik",
//                "31",
//                "2011521011",
//                "2019"
//        ));
//
//        list_ta.add(new ta_mahasiswa(
//                null,
//                "Arby Zaid",
//                "SPK Pemilihan Bank Sampah",
//                "31",
//                "2011521010",
//                "2016"
//        ));
//
//        list_ta.add(new ta_mahasiswa(
//                null,
//                "Dean Fisabil Andwi",
//                "SPK Pemilihan Bank Terbaik",
//                "34",
//                "2011521010",
//                "2016"
//        ));
//
//        list_ta.add(new ta_mahasiswa(
//                null,
//                "Dean Fisabil Andwi",
//                "SPK Pemilihan Bank Terbaik",
//                "34",
//                "2011521010",
//                "2016"
//        ));
//
//
//        return list_ta;
//
//    }

//
//    @Override
//    public void onItemPermintaanTAClick(ta_mahasiswa taMahasiswa) {
//       Intent detailTAOld = new Intent(this, detailpermintaanTA.class);
//        detailTAOld.putExtra("nama_mahasiswa", taMahasiswa.getNama());
//        detailTAOld.putExtra("judul_TA", taMahasiswa.getJudul());
//        detailTAOld.putExtra("nim", taMahasiswa.getNIM());
//        detailTAOld.putExtra("year", taMahasiswa.getYear());
//        detailTAOld.putExtra("id",taMahasiswa.getId_mhs());
//       startActivity(detailTAOld);
    }
