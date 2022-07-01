package com.rezzarn.tugas_sensor_2022_akb_if7_10119291;

// 10119291 - Rezza Ramdhani Nahsurllah - IF7

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override            public void run() {
                startActivity(new Intent(getApplicationContext(),
                        MainActivity.class));
                finish();
            }
        }, 3000L);
        /*Mengatur durasi Splash Screen. 2000L = 2 detik*/
    }
}