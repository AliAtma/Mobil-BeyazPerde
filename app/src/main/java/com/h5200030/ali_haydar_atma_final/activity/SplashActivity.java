package com.h5200030.ali_haydar_atma_final.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.h5200030.ali_haydar_atma_final.R;
import com.h5200030.ali_haydar_atma_final.util.AlertUtil;
import com.h5200030.ali_haydar_atma_final.util.NetworkUtil;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    //ACILISTA CALISAN ILK METODDUR LAYOUT OLARAK ACTIVITIY_SPLASH SET EDILMISTIR
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        internetAlert();
    }

    //internet kontrolu yapar ve bagli degilse ekrana uyari verir
    private void internetAlert(){
        if (!NetworkUtil.internetControl(getApplicationContext())) {
            AlertUtil.alertDialog(this);
            return;
        }
        switchScreen();// kontrolden sonra ekran degistir
    }

    // 3saniyelik bir geri sayım sonrası MainActivity ekranını açıp bu ekranı öldürür
    private void switchScreen(){
        new Handler().postDelayed(() -> {
            Intent i = new Intent(SplashActivity.this,MainActivity.class);
            startActivity(i);
            finish();
        }, 3000);
    }
}