package com.h5200030.ali_haydar_atma_final.util;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

//cekılen resım url'sının kullanımını saglayan metod
public class GlideUtil {
    public  static  void resmiIndiripGoster(Context context, String resimUrl, ImageView hangiImageView)
    {
        Glide.with(context)
                .load(resimUrl)
                .centerCrop()
                .into(hangiImageView);
    }
}
