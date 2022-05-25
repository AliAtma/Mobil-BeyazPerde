package com.h5200030.ali_haydar_atma_final.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//json dosyasında girdiğimiz verileri  işlem yapmamız için dönüştüren metod
public class Film {

    @SerializedName("FilmAdi")
    @Expose
    private String filmAdi;
    @SerializedName("FilmBaslik")
    @Expose
    private String filmBaslik;
    @SerializedName("VizyonTarihi")
    @Expose
    private String vizyonTarihi;
    @SerializedName("ResimURL")
    @Expose
    private String resimURL;
    @SerializedName("ResimURL2")
    @Expose
    private String resimURL2;
    @SerializedName("FilmAciklama")
    @Expose
    private String filmAciklama;

    public String getFilmAdi() { return filmAdi; }

    public void setFilmAdi(String filmAdi) { this.filmAdi = filmAdi; }

    public String getFilmBaslik() { return filmBaslik; }

    public void setFilmBaslik(String filmBaslik) { this.filmBaslik = filmBaslik; }

    public String getVizyonTarihi() { return vizyonTarihi; }

    public void setVizyonTarihi(String vizyonTarihi) { this.vizyonTarihi = vizyonTarihi; }

    public String getResimURL() { return resimURL; }

    public void setResimURL(String resimURL) { this.resimURL = resimURL; }

    public String getResimURL2() { return resimURL2; }

    public void setResimURL2(String resimURL2) { this.resimURL2 = resimURL2; }

    public String getFilmAciklama() { return filmAciklama; }

    public void setFilmAciklama(String filmAciklama) { this.filmAciklama = filmAciklama; }
}