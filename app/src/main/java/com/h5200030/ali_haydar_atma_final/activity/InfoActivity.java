package com.h5200030.ali_haydar_atma_final.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.h5200030.ali_haydar_atma_final.R;

import com.h5200030.ali_haydar_atma_final.util.GlideUtil;

public class InfoActivity extends AppCompatActivity {

    ImageView imgFilm2;
    TextView txtFilmBaslik;
    TextView txtFilmAciklama;

    //MainActivityden bir film seçildiğinde çalışan metoddur.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        init();
    }

    // tıklanan filmin adına göre filmin detay ekranına filmin resmini, adını ve açıklamasını çeken yer.
    private void init() {

        imgFilm2 = findViewById(R.id.imgFilm2);
        txtFilmBaslik = findViewById(R.id.txtFilmBaslik);
        txtFilmAciklama = findViewById(R.id.txtFilmAciklama);

        txtFilmBaslik.setText(MainActivity.filmAdi);
        txtFilmAciklama.setText(MainActivity.filmAciklamasi);
        GlideUtil.resmiIndiripGoster(getApplicationContext(), MainActivity.filmResimUrl, imgFilm2);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            txtFilmBaslik.setText(Html.fromHtml(MainActivity.filmAdi, Html.FROM_HTML_MODE_COMPACT));
            txtFilmAciklama.setText(Html.fromHtml(MainActivity.filmAciklamasi, Html.FROM_HTML_MODE_COMPACT));
        } else {
            txtFilmBaslik.setText(Html.fromHtml(MainActivity.filmAdi));
            txtFilmAciklama.setText(Html.fromHtml(MainActivity.filmAciklamasi));
        }
    }
}
