package com.h5200030.ali_haydar_atma_final.network;

import com.h5200030.ali_haydar_atma_final.model.Film;

import java.util.List;
import io.reactivex.Observable;
import retrofit2.http.GET;

//json dosyasından gelen veriyi atama.
public interface ServiceApi {
    @GET("filmler.json")
    Observable<List<Film>> filmleriGetir();
}
