package com.h5200030.ali_haydar_atma_final.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5200030.ali_haydar_atma_final.model.Film;
import com.h5200030.ali_haydar_atma_final.util.GlideUtil;
import com.h5200030.ali_haydar_atma_final.R;

import java.util.List;

//veri kaynağı ile kullanıcı arabirim arasında bağlantı kurar
public class FilmAdaptor extends RecyclerView.Adapter<FilmViewHolder> {

    List<Film> filmler;
    Context context;
    OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(Film tiklananFilm);
    }

    public FilmAdaptor(List<Film> filmler, Context context,OnItemClickListener onItemClickListener) {
        this.filmler = filmler;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_film,parent,false);
        FilmViewHolder filmViewHolder =new FilmViewHolder(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(filmler.get(filmViewHolder.getAdapterPosition()));
            }
        });

        return filmViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder viewHolder, int position) {
        viewHolder.txtTarih.setText(filmler.get(position).getVizyonTarihi());
        viewHolder.txtIsim.setText(filmler.get(position).getFilmAdi());
        GlideUtil.resmiIndiripGoster(context,filmler.get(position).getResimURL(),viewHolder.imgFilm);
    }

    @Override
    public int getItemCount() {
        return filmler.size();
    }
}
