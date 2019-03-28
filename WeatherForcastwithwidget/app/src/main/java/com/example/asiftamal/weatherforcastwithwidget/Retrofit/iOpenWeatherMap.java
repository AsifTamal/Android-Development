package com.example.asiftamal.weatherforcastwithwidget.Retrofit;

import com.example.asiftamal.weatherforcastwithwidget.Model.WeatherResult;
import com.example.asiftamal.weatherforcastwithwidget.Model.WeatherforcastResult;

import io.reactivex.Observable;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface iOpenWeatherMap {
    @GET("weather")
    Observable<WeatherResult> getWeatherByLanLng(@Query("lat") String lat,
                                                              @Query("lon") String lng,
                                                              @Query("appid") String appid,
                                                              @Query("units") String unit
                                                 );

    @GET("weather")
    Observable<WeatherResult> getWeatherByCityName(@Query("q") String cityName,
                                                 @Query("appid") String appid,
                                                 @Query("units") String unit
    );
    @GET("forecast")
    Observable<WeatherforcastResult> getforcastWeatherByLanLng(@Query("lat") String lat,
                                                               @Query("lon") String lng,
                                                               @Query("appid") String appid,
                                                               @Query("units") String unit
    );
}
