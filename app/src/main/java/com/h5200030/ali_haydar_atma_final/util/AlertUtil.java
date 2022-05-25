package com.h5200030.ali_haydar_atma_final.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.p2p.WifiP2pManager;

import androidx.appcompat.app.AlertDialog;

import com.h5200030.ali_haydar_atma_final.R;


public class AlertUtil {
    //Internetın olmadıgı durumda uyarı verıp ınternetı actıran metod
    public static void alertDialog(Activity activity){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(activity.getResources().getString(R.string.alertTitle));
        builder.setMessage(activity.getResources().getString(R.string.alertWriting));
        builder.setNegativeButton(activity.getResources().getString(R.string.alertOff), null);
        builder.setPositiveButton(activity.getResources().getString(R.string.alertInternetOn), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                //startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
            }
        });
        builder.show();
    }
    //Geri butonuna basinca cikis yapar
    // public static void exitDialog(Activity activity){
    //     AlertDialog.Builder builder = new AlertDialog.Builder(activity);
    //     builder.setTitle("Cikis Yapiyorsunuz");
    //     builder.setMessage("Cikis yapmak istediginize emin misiniz");
    //     builder.setNegativeButton("Hayir", new DialogInterface.OnClickListener() {
    //         @Override
    //         public void onClick(DialogInterface dialog, int which) {
    //             dialog.dismiss();
    //         }
    //     });
    //     builder.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
    //         @Override
    //         public void onClick(DialogInterface dialog, int which) {
    //             System.exit(0);
    //         }
    //     });
    //     builder.show();
    // }
}