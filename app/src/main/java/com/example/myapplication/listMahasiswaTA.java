package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.myapplication.Adapter.uas2Adapter;
import com.example.myapplication.Adapter.uasAdapter;
import com.example.myapplication.datamodels.PermintaanTAResponse;
import com.example.myapplication.datamodels.TAResponse;
import com.example.myapplication.datamodels.ThesesItem;
import com.example.myapplication.datamodels.ThesisItem;
import com.example.myapplication.retrofit.apiClient;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class listMahasiswaTA extends AppCompatActivity {
    private RecyclerView rvmhs;
    private uas2Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa_ta);
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.myapplication.SHARED_KEY", MODE_PRIVATE);
        String token = sharedPreferences.getString("tokenLogin", "");

        rvmhs = findViewById(R.id.rv_mhs);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvmhs.setLayoutManager(layoutManager);
        adapter = new uas2Adapter();
        rvmhs.setAdapter(adapter);

        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

        apiClient client = retrofit.create(apiClient.class);

        Call<TAResponse> call = client.responseTA("Bearer " + token);
        call.enqueue(new Callback<TAResponse>() {
            @Override
            public void onResponse(Call<TAResponse> call, Response<TAResponse> response) {
                TAResponse taResponse = response.body();
                if (taResponse != null) {
                    List<ThesesItem> theses = taResponse.getTheses();
                    adapter.setItemList(theses);
                }
            }

            @Override
            public void onFailure(Call<TAResponse> call, Throwable t) {

            }
        });
    }
}
