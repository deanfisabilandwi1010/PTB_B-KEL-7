package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.models.ThesesData;
import com.example.myapplication.datamodels.Thesis;
import com.example.myapplication.Adapter.list_mahasiswaAdapter;
import com.example.myapplication.models.list_mahasiswa_ta;
import com.example.myapplication.retrofit.RetrofitClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.android.gms.tasks.Task;


import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;

import retrofit2.Response;



public class cari_mahasiswa extends AppCompatActivity implements list_mahasiswaAdapter.itemMahasiswaClickListener{
    private RecyclerView rvcm;
    private String token;
    String getToken;

    private static final String TAG = "cari_mahasiswa-Debug";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_mahasiswa);

        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }

                        // Get new FCM registration token
                        token = task.getResult();

                        // Log and toast
                        Log.d(TAG, token);
                        Toast.makeText(cari_mahasiswa.this, token, Toast.LENGTH_SHORT).show();
                    }
                });

        rvcm = findViewById(R.id.rv_cm);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvcm.setLayoutManager(layoutManager);

        getlist_mahasiswa();
    }

    public void detail_ta(View view) {
        Intent kedetail = new Intent(this, detail_ta.class);
        startActivity(kedetail);


    }

    public ArrayList<Thesis> getlist_mahasiswa(){

        RetrofitClient config = new RetrofitClient();
        ArrayList<Thesis> list_ta = new ArrayList<>();
        System.out.println("token saya : "+token);
        //panggil client
        Call<ThesesData> call = config.configRetrofit().getListTA("Bearer "+"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOi8vcHRiLWFwaS5odXNuaWxrYW1pbC5teS5pZC9hcGkvbG9naW4iLCJpYXQiOjE2NzI4NzU5NjYsImV4cCI6MTY3Mjg3OTU2NiwibmJmIjoxNjcyODc1OTY2LCJqdGkiOiJ4UldheFU2aTREQWRLOVlGIiwic3ViIjoiMiIsInBydiI6IjIzYmQ1Yzg5NDlmNjAwYWRiMzllNzAxYzQwMDg3MmRiN2E1OTc2ZjcifQ.ZoiVZbiuVfOKRUg8X2R_51IDyWQSgijXEWf2yKXn3VE");
        call.enqueue(new Callback<ThesesData>() {
            @Override
            public void onResponse(Call<ThesesData> call, Response<ThesesData> response) {
                ThesesData thesesData = response.body();
                List<Thesis>listTA = thesesData.getTheses();
                ArrayList<Thesis>list_ta = new ArrayList<>();
                for(Thesis thesis : listTA){
                    list_ta.add(thesis);
                }
                list_mahasiswaAdapter adapter = new list_mahasiswaAdapter(list_ta);
                rvcm.setAdapter(adapter);
                adapter.setListener(cari_mahasiswa.this);
                System.out.println("data TA : "+list_ta);
            }

            @Override
            public void onFailure(Call<ThesesData> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return list_ta;

    }


    @Override
    public void onItemListMahasiswa(Thesis listMahasiswaTa) {
        Intent detailTAOld = new Intent(this, detail_ta.class);
        detailTAOld.putExtra("nama_mahasiswa", listMahasiswaTa.getStudentName());
        detailTAOld.putExtra("judul_TA", listMahasiswaTa.getTitle());
        detailTAOld.putExtra("dosping_old", listMahasiswaTa.getStudentNim());
        startActivity(detailTAOld);
    }
}