package com.example.asiftamal.weatherforcastwithwidget.Common;

import android.location.Location;

import java.text.SimpleDateFormat;
import java.util.Date;

public class common {
    public  static final String API_ID="3970a4bef207d7180259092429681491";
    public static Location current_location=null;

    public static String convertUnixToDate(long dt) {
        Date date=new Date(dt*1000L);
        SimpleDateFormat sdf=new SimpleDateFormat("hh:mm a EEE dd/MM/yyyy");
        String formatted=sdf.format(date);
        return formatted;
    }

    public static String convertUnixToHour(long sunrisesunset) {
        Date date=new Date(sunrisesunset*1000L);
        SimpleDateFormat sdf=new SimpleDateFormat("hh:mm a");
        String formatted=sdf.format(date);
        return formatted;
    }
}
