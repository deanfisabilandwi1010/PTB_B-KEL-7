package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.datamodels.LogoutResponse;
import com.example.myapplication.retrofit.RetrofitClient;
import com.example.myapplication.retrofit.apiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity<isloggedin> extends AppCompatActivity {

    private static final String CHANNEL_ID = "jadwal_sidang" ;
    private static final String TAG = "MainActivity-Debug";
    private boolean isloggedin = false;
    TextView textnamaUser;
    String gettoken,tokenLogin;
    private NotificationManagerCompat notificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();

                        // Log and toast
                        Log.d(TAG, token);
                        Toast.makeText(MainActivity.this, token, Toast.LENGTH_SHORT).show();
                    }
                });



        notificationManager = NotificationManagerCompat.from(this);

        createNotificationChannel();


        Intent mainIntent = getIntent();
        String Username = mainIntent.getStringExtra("USERNAME");
        boolean isloggedin = mainIntent.getBooleanExtra("ISLOGGEDIN",true);


        if(!isloggedin){
            Intent loginIntent = new Intent(this, login.class);
            startActivity(loginIntent);
            finish();

        }

        textnamaUser = findViewById(R.id.textnamaUser);
        textnamaUser.setText(Username);


    }


    public void logout(View view){
        apiClient mainInterface = RetrofitClient.getService();
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.myapplication.SHARED_KEY",MODE_PRIVATE);
        gettoken = sharedPreferences.getString("tokenLogin","");
        tokenLogin = "Bearer " + gettoken;

        Call<LogoutResponse> call = mainInterface.logout(tokenLogin);
        call.enqueue(new Callback<LogoutResponse>() {
            @Override
            public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {

                LogoutResponse logoutResponse = response.body();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("tokenLogin");
                editor.apply();
                finish();
                Toast.makeText(MainActivity.this, logoutResponse.getMessage(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, login.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<LogoutResponse> call, Throwable t) {

            }
        });

    }

    public void jdwlsidang(View view){
        Intent jdwlsid = new Intent(MainActivity. this,list_jadwalsidang.class);
        startActivity(jdwlsid);

        Intent resultIntent = new Intent(MainActivity.this, list_jadwalsidang.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(MainActivity.this);
        stackBuilder.addNextIntentWithParentStack(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0,
                        PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                .setSmallIcon(R.drawable.logounand)
                .setContentTitle("Reminder Sidang")
                .setContentText("Sidang yang akan datang besok hari!!")
//                .setContentIntent(resultPendingIntent)
                .addAction(R.drawable.logounand, "CEK", resultPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        Notification notification = builder.build();
        notificationManager.notify(101,notification);

    }

    public void jdwlseminar(View view){
        Intent jdwlsmnr = new Intent (MainActivity. this,list_jadwalseminar.class);
        startActivity(jdwlsmnr);

        Intent notifjdwlsmeniar = new Intent(MainActivity.this, list_jadwalseminar.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(MainActivity.this);
        stackBuilder.addNextIntentWithParentStack(notifjdwlsmeniar);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0,
                        PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                .setSmallIcon(R.drawable.logounand)
                .setContentTitle("Reminder Seminar")
                .setContentText("Seminar yang akan datang besok hari!!")
//                .setContentIntent(resultPendingIntent)
                .addAction(R.drawable.logounand, "CEK", resultPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        Notification notification = builder.build();
        notificationManager.notify(101,notification);
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
    public void tugasakhir(View view){
        Intent listtugasakhir = new Intent(MainActivity. this,cari_mahasiswa.class);
        startActivity(listtugasakhir);
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "notifikasi sidang";
            String description = "reminder untuk jadwal sidang";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "jadwal Sidang", NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("notifikasi jadwal sidang");
            notificationManager.createNotificationChannel(channel);
        }
    }



}