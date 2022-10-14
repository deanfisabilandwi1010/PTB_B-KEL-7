package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity<isloggedin> extends AppCompatActivity {

    private boolean isLoggedin = false;
    TextView textnamaUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent mainIntent = getIntent();
            String Username = mainIntent.getStringExtra("USERNAME");
        boolean isLoggedin = mainIntent.getBooleanExtra("ISLOGGEDIN",true);

        if(!isLoggedin){
                Intent loginIntent = new Intent(this, login.class);
                startActivity(loginIntent);
                finish();
        }

        textnamaUser = findViewById(R.id.textnamaUser);
        textnamaUser.setText(Username);
    }


    public void logout(View view){
        Intent keluar = new Intent(MainActivity. this,login.class);
        startActivity(keluar);

    }

    public void jdwlsidang(View view){
        Intent jdwlsid = new Intent(MainActivity. this,jadwalsidang.class);
        startActivity(jdwlsid);

    }

    public void jdwlseminar(View view){
        Intent jdwlsmnr = new Intent (MainActivity. this,jadwalseminar.class);
        startActivity(jdwlsmnr);
    }

    public void listta(View view){
        Intent listtamhs = new Intent (MainActivity. this,listtugasakhir.class);
        startActivity(listtamhs);
    }

    public void permintaanSeminar(View view){
        Intent pSeminar = new Intent (MainActivity. this,listPermintaanSeminar.class);
        startActivity(pSeminar);
    }

    public void permintaanSidang(View view){
        Intent pSidang = new Intent (MainActivity. this,listPermintaanSidang.class);
        startActivity(pSidang);
    }



}