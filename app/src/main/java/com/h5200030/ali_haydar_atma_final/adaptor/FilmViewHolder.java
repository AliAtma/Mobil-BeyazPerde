package com.h5200030.ali_haydar_atma_final.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5200030.ali_haydar_atma_final.R;
//adaptor tarafından sağlanan veri kümelerini görüntülemek için kullanılır.
public class FilmViewHolder extends RecyclerView.ViewHolder {
    //Liste elemanlarını öğe üzerinde tutan yapı.
    ImageView imgFilm;
    TextView txtIsim;
    TextView txtTarih;
    TextView txtAciklama;
    TextView txtBaslik;
    ImageView imgFilm2;

    public FilmViewHolder(@NonNull View itemView) {
        super(itemView);
        imgFilm =itemView.findViewById(R.id.imgFilm);
        txtIsim =itemView.findViewById(R.id.txtFilmAdi);
        txtTarih =itemView.findViewById(R.id.txtVizyonTarihi);
        txtAciklama =itemView.findViewById(R.id.txtFilmAciklama);
        txtBaslik =itemView.findViewById(R.id.txtFilmBaslik);
        imgFilm2 =itemView.findViewById(R.id.imgFilm2);
    }
}
