package com.h5200030.ali_haydar_atma_final.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.h5200030.ali_haydar_atma_final.adaptor.FilmAdaptor;
import com.h5200030.ali_haydar_atma_final.util.GlideUtil;
import com.h5200030.ali_haydar_atma_final.R;
import com.h5200030.ali_haydar_atma_final.network.Service;
import com.h5200030.ali_haydar_atma_final.model.Film;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

// itemlerin listelendiği ekrandır
public class MainActivity extends AppCompatActivity {

    public static String filmAdi;
    public static String filmAciklamasi;
    public static String filmResimUrl;

    ImageView imgKapak;
    String resimUrl = "https://i.hizliresim.com/io5y5c2.png";
    RecyclerView recyclerView;

    //splashScreen sonrası çalışan metoddur layout olarak activity_main set edilmiştir.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();

    }

    // kapakResminiCek ve FilmleriGetir fonksiyonlarının birlikte çalıştırması için yapılmıştır.
    private void init() {
        kapakResminiCek();
        filmleriGetir();
    }
    //liste ekranına kapak resmini GlideUtilde dönüştürülerek atar.
    private void kapakResminiCek() {
        imgKapak = findViewById(R.id.imgKapak);
        GlideUtil.resmiIndiripGoster(getApplicationContext(), resimUrl, imgKapak);
    }
    //listede tıklanan filmin bilgi ekranına gider
    private void initRecycleView(List < Film > filmList) {
        recyclerView = findViewById(R.id.rcvFilmler);

        FilmAdaptor filmAdaptor = new FilmAdaptor(filmList, getApplicationContext(), new FilmAdaptor.OnItemClickListener() {
            @Override
            public void onItemClick(Film tiklananFilm) {
                filmAdi = tiklananFilm.getFilmAdi();
                filmAciklamasi = tiklananFilm.getFilmAciklama();
                filmResimUrl = tiklananFilm.getResimURL2();
                openInfoActivity();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(filmAdaptor);
    }
    // jsonda atadığımız filmlerin verilerini çekerek listeler.
    void filmleriGetir() {
        new Service().getServiceApi().filmleriGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer < List < Film >> () {
                    List < Film > filmler = new ArrayList < > ();

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {}

                    @Override
                    public void onNext(List < Film > filmListParam) {
                        filmler = filmListParam;
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {}

                    @Override
                    public void onComplete() {
                        if (filmler.size() > 0) {
                            initRecycleView(filmler);
                        }
                    }
                });
    }
    // tıkladığımız filmin detay ekranına gider
    public void openInfoActivity() {
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }

    // public void exitButton(){
    //         super.onBackPressed();
    //         AlertUtil.exitDialog(this);
    // }
}