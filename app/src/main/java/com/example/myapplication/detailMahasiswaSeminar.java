package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Adapter.SemhasAdapter;
import com.example.myapplication.Adapter.SidangAdapter;
import com.example.myapplication.datamodels.SemhasResponse;
import com.example.myapplication.datamodels.SeminarResponse;
import com.example.myapplication.datamodels.SeminarsItem;
import com.example.myapplication.retrofit.apiClient;
import com.example.myapplication.retrofit.RetrofitClient;
import com.example.myapplication.datamodels.Thesis;
import com.example.myapplication.datamodels.Student;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class detailMahasiswaSeminar extends AppCompatActivity {
    TextView namaDetail, nimDetail, dateDetail, judulDetail, abstrakDetail;
    ImageView imgDetail;
    String tokenLogin, gettoken;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String namaMahasiswa = null;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sidang);

        Intent detailIntent = getIntent();
        if (detailIntent != null) {
            namaMahasiswa = detailIntent.getStringExtra("Peserta Sidang");
            namaDetail = findViewById(R.id.namaDetail);
            String str = namaMahasiswa.toLowerCase();
            String str2 = StringFormatter.capitalizeWord(str);
            namaDetail.setText(str2);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nimDetail = findViewById(R.id.nimDetail);
        dateDetail = findViewById(R.id.dateDetail);
        judulDetail = findViewById(R.id.judulDetail);
        abstrakDetail = findViewById(R.id.judulDetail);


        apiClient mainInterface = RetrofitClient.getService();
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.myapplication.SHARED_KEY", MODE_PRIVATE);
        gettoken = sharedPreferences.getString("tokenLogin", "");
        tokenLogin = "Bearer " + gettoken;

        String Nama = detailIntent.getStringExtra("Nama");
        String NIM = detailIntent.getStringExtra("NIM");
        String Waktu = detailIntent.getStringExtra("tanggalMulaiTA");
        String Judul = detailIntent.getStringExtra("judulSidang");
        String Abstrak = detailIntent.getStringExtra("Id Sidang");

        List<String> list = new ArrayList<String>();

        Call<SemhasResponse> call = RetrofitClient.getService().getDetail(tokenLogin);
        call.enqueue(new Callback<SemhasResponse>() {
            @Override
            public void onResponse(Call<SemhasResponse> call, Response<SemhasResponse> response) {
                SemhasResponse detailSidangResponse = response.body();

                namaDetail.setText(Nama);
                nimDetail.setText(NIM);
                dateDetail.setText(Waktu);
                judulDetail.setText(Judul);
                abstrakDetail.setText(Abstrak);


            }

            @Override
            public void onFailure(Call<SemhasResponse> call, Throwable t) {
                Toast.makeText(detailMahasiswaSeminar.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        Button formPengujiSidang = findViewById(R.id.tambahDosenSeminar);
        formPengujiSidang.setOnClickListener(views -> {
            Intent tetapkanPenguji = new Intent(detailMahasiswaSeminar.this, listDosenSeminar.class);
            startActivity(tetapkanPenguji);
        });
    }

    public static class StringFormatter {
        public static String capitalizeWord(String str) {
            String words[] = str.split("\\s");
            String capitalizeWord = "";
            for (String w : words) {
                String first = w.substring(0, 1);
                String afterfirst = w.substring(1);
                capitalizeWord += first.toUpperCase() + afterfirst + " ";
            }
            return capitalizeWord.trim();
        }
    }
}
//    //    private RecyclerView rvSidang;
////    private ArrayList<list_mahasiswa_sidang> list = new ArrayList<>();
//    public static final String EXTRA_SEMHAS = "extra_semhas";
//
//    //Sefza
//    private SemhasAdapter adapter;
//    private SearchView searchView;
//    SemhasResponse semhasResponse;
//
//    TextView namaDetail, nimDetail, dateDetail, judulDetail, abstrakDetail;
//    ImageView imgDetail;
//    String tokenLogin, gettoken;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_list_permintaan_seminar);
//
//        namaDetail = findViewById(R.id.namaDetail);
//        nimDetail = findViewById(R.id.nimDetail);
//        dateDetail = findViewById(R.id.dateDetail);
//        judulDetail = findViewById(R.id.judulDetail);
//        abstrakDetail = findViewById(R.id.abstrakDetail);
//
//        SemhasResponse semhasResponse = getIntent().getParcelableExtra(EXTRA_SEMHAS);
//
//        if (semhasResponse != null) {
//            if (semhasResponse != null) {
//                Glide.with(this)
//                        .load(R.drawable.ic_avatar4)
//                        .into(imgDetail);
//                namaDetail.setText(semhasResponse.getSeminars().get(0).getThesis().getStudent().getName());
//                nimDetail.setText(semhasResponse.getSeminars().get(0).getThesis().getStudent().getNim());
//                dateDetail.setText(semhasResponse.getSeminars().get(0).getThesis().getUpdatedAt());
//                judulDetail.setText(semhasResponse.getSeminars().get(0).getThesis().getTitle());
//                abstrakDetail.setText(semhasResponse.getSeminars().get(0).getThesis().getJsonMemberAbstract());
//
//            }
//            if (getSupportActionBar() != null) {
//                getSupportActionBar().setTitle("Detail Mahasiswa Seminar");
//                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            }
//            CallRetrofit();
//        }
//
//
//        //    private void CallRetrofit() {
////        RetrofitClient.getService();
////        Call<Response> call = apiClient.getSidang()
////
////
////
////    }
//
//
//
//
////    private  void showRecyclerList(){
////        rvSidang.setLayoutManager(new LinearLayoutManager(this));
////        SidangAdapter listClubAdapter = new SidangAdapter(list);
////        rvSidang.setAdapter(listClubAdapter);
////    }
//
//
//    }
//
//    private void CallRetrofit() {
//        apiClient mainInterface = RetrofitClient.getService();
//        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.myapplication.SHARED_KEY", MODE_PRIVATE);
//        gettoken = sharedPreferences.getString("tokenLogin", "");
//        tokenLogin = "Bearer " + gettoken;
//
//        Call<SemhasResponse> call = RetrofitClient.getService().getSemhas(tokenLogin);
//        call.enqueue(new Callback<SemhasResponse>() {
//            @Override
//            public void onResponse(Call<SemhasResponse> call, Response<SemhasResponse> response) {
//
//                SemhasResponse seminars = response.body();
//                if (seminars != null) {
//                    List<SeminarsItem> seminarsItemList = seminars.getSeminars();
//                    adapter = new SemhasAdapter(detailMahasiswaSeminar.this, seminarsItemList);
//
//                    semhasResponse.(adapter);
//
//
//                }
//
//
//            }
//
//            @Override
//            public void onFailure(Call<SemhasResponse> call, Throwable t) {
//
//            }
//
////        @Override
////        public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {
////
////            LogoutResponse logoutResponse = response.body();
////            SharedPreferences.Editor editor = sharedPreferences.edit();
////            editor.remove("tokenLogin");
////            editor.apply();
////            finish();
////            Toast.makeText(MainActivity.this, logoutResponse.getMessage(), Toast.LENGTH_SHORT).show();
////            Intent intent = new Intent(MainActivity.this, login.class);
////            startActivity(intent);
////        }
////
////        @Override
////        public void onFailure(Call<LogoutResponse> call, Throwable t) {
////
////        }
//        });
//    }
//    public void tambahDosenSeminar(View view){
//        Intent dosenSemhas = new Intent(detailMahasiswaSeminar.this, listDosenSeminar.class);
//        startActivity(dosenSemhas);
//    }
//
//
//}
//
//
////import com.example.myapplication.datamodels.SeminarResponse;
////
////public class detailMahasiswaSeminar extends AppCompatActivity {
////    public static final String EXTRA_SEMHAS = "extra_semhas";
////
////    TextView namaDetail, nimDetail, dateDetail, judulDetail,  abstrakDetail;
////    ImageView imgDetail;
////    String tokenLogin, gettoken;
////    SemhasResponse semhasResponse;
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_detail_mahasiswa_seminar);
////
////
////        namaDetail = findViewById(R.id.namaDetail);
////        nimDetail = findViewById(R.id.nimDetail);
////        dateDetail = findViewById(R.id.dateDetail);
////        judulDetail = findViewById(R.id.judulDetail);
////        abstrakDetail = findViewById(R.id.abstrakDetail);
////
////        semhasResponse = getIntent().getParcelableExtra(EXTRA_SEMHAS);
////
////
////
////
////
////
////
////    }
////
////
////    public void tambahDosenSeminar(View view){
////        Intent tambah = new Intent(detailMahasiswaSeminar. this, listDosenSeminar.class);
////        startActivity(tambah);
////    }
////}