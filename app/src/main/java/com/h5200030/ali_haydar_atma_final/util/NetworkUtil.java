package com.h5200030.ali_haydar_atma_final.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

//ınternet baglantısını kontrol eden metod
public class NetworkUtil {
    public static boolean internetControl(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
        return netInfo != null
                && netInfo.isAvailable()
                && netInfo.isConnected();
    }
}
