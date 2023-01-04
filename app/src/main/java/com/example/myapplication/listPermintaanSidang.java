package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.SidangAdapter;
import com.example.myapplication.datamodels.LogoutResponse;
import com.example.myapplication.datamodels.SeminarsItem;
import com.example.myapplication.retrofit.apiClient;
import com.example.myapplication.retrofit.RetrofitClient;


import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class listPermintaanSidang extends AppCompatActivity {
//    private RecyclerView rvSidang;
//    private ArrayList<list_mahasiswa_sidang> list = new ArrayList<>();

    //Sefza
    private SidangAdapter adapter;
    private SearchView searchView;
    RecyclerView recyclerView;

    TextView textnamaUser;
    String gettoken,tokenLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_permintaan_sidang);

        recyclerView = findViewById(R.id.rv_sidang);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CallRetrofit();

    }

//    private void CallRetrofit() {
//        RetrofitClient.getService();
//        Call<Response> call = apiClient.getSidang()
//
//
//
//    }
    public void CallRetrofit(){
        apiClient mainInterface = RetrofitClient.getService();
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.myapplication.SHARED_KEY",MODE_PRIVATE);
        gettoken = sharedPreferences.getString("tokenLogin","");
        tokenLogin = "Bearer " + gettoken;

        Call<SeminarsItem> call = mainInterface.getSidang(tokenLogin);
        call.enqueue(new Callback<SeminarsItem>() {
            @Override
            public void onResponse(Call<SeminarsItem> call, Response<SeminarsItem> response) {
                List<SeminarsItem> sidangList = (List<SeminarsItem>) response.body().getThesis();
                adapter = new SidangAdapter(listPermintaanSidang.this, sidangList);



                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<SeminarsItem> call, Throwable t) {

            }

//        @Override
//        public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {
//
//            LogoutResponse logoutResponse = response.body();
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.remove("tokenLogin");
//            editor.apply();
//            finish();
//            Toast.makeText(MainActivity.this, logoutResponse.getMessage(), Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(MainActivity.this, login.class);
//            startActivity(intent);
//        }
//
//        @Override
//        public void onFailure(Call<LogoutResponse> call, Throwable t) {
//
//        }
    });

}


//    private  void showRecyclerList(){
//        rvSidang.setLayoutManager(new LinearLayoutManager(this));
//        SidangAdapter listClubAdapter = new SidangAdapter(list);
//        rvSidang.setAdapter(listClubAdapter);
//    }
}