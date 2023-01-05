package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.SemhasAdapter;
import com.example.myapplication.Adapter.SidangAdapter;
import com.example.myapplication.datamodels.SemhasResponse;
import com.example.myapplication.datamodels.SeminarResponse;
import com.example.myapplication.datamodels.SeminarsItem;
import com.example.myapplication.retrofit.apiClient;
import com.example.myapplication.retrofit.RetrofitClient;
import com.example.myapplication.datamodels.Thesis;
import com.example.myapplication.datamodels.Student;




import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class listPermintaanSeminar extends AppCompatActivity implements SemhasAdapter.ItemSeminarClickListener {
//    private RecyclerView rvSidang;
//    private ArrayList<list_mahasiswa_sidang> list = new ArrayList<>();

    //Sefza
    private SemhasAdapter adapter;
    private SearchView searchView;
    RecyclerView recyclerView;

    TextView textnamaUser;
    String gettoken, tokenLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_permintaan_seminar);

        recyclerView = findViewById(R.id.rv_seminar);
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
    public void CallRetrofit() {
        apiClient mainInterface = RetrofitClient.getService();
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.myapplication.SHARED_KEY", MODE_PRIVATE);
        gettoken = sharedPreferences.getString("tokenLogin", "");
        tokenLogin = "Bearer " + gettoken;

        Call<SemhasResponse> call = RetrofitClient.getService().getSemhas(tokenLogin);
        call.enqueue(new Callback<SemhasResponse>() {
            @Override
            public void onResponse(Call<SemhasResponse> call, Response<SemhasResponse> response) {

                SemhasResponse seminars = response.body();
                if (seminars != null) {
                    List<SeminarsItem> seminarsItemList = seminars.getSeminars();
                    adapter = new SemhasAdapter(listPermintaanSeminar.this, seminarsItemList);

                    recyclerView.setAdapter(adapter);


                }


            }

            @Override
            public void onFailure(Call<SemhasResponse> call, Throwable t) {

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

    @Override
    public void onItemPermintaanClick(SeminarsItem seminar) {
        Intent detailSidang = new Intent(this, detailMahasiswaSeminar.class);
        detailSidang.putExtra("Nama", seminar.getThesis().getStudent().getName());
        detailSidang.putExtra("NIM", seminar.getThesis().getStudent().getNim());
        detailSidang.putExtra("Waktu", seminar.getThesis().getUpdatedAt());
        detailSidang.putExtra("Judul", seminar.getThesis().getTitle());
        detailSidang.putExtra("Abstrak", seminar.getThesis().getJsonMemberAbstract());
        startActivity(detailSidang);
    }


//    private  void showRecyclerList(){
//        rvSidang.setLayoutManager(new LinearLayoutManager(this));
//        SidangAdapter listClubAdapter = new SidangAdapter(list);
//        rvSidang.setAdapter(listClubAdapter);
//    }

//    public void tambahDosenSeminar(View view){
//        Intent dosenSemhas = new Intent (listPermintaanSeminar. this,listDosenSeminar.class);
//        startActivity(dosenSemhas);
//    }

}