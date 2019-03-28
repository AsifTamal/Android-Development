package com.example.asiftamal.weatherforcastwithwidget.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asiftamal.weatherforcastwithwidget.Adapter.WeatherForcastRecyclerAdapter;
import com.example.asiftamal.weatherforcastwithwidget.Common.common;
import com.example.asiftamal.weatherforcastwithwidget.Model.WeatherResult;
import com.example.asiftamal.weatherforcastwithwidget.Model.WeatherforcastResult;
import com.example.asiftamal.weatherforcastwithwidget.R;
import com.example.asiftamal.weatherforcastwithwidget.Retrofit.RetrofitClient;
import com.example.asiftamal.weatherforcastwithwidget.Retrofit.iOpenWeatherMap;
import com.squareup.picasso.Picasso;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodatWeatherFragment extends Fragment {

           ProgressBar progressBar;
           ImageView imageView;
           TextView txt_city_name,txt_temperature,txt_description,txt_date_time,txt_wind,txt_pressure,txt_humidity,txt_sunrise,txt_sunset,txt_coords;
            LinearLayout rootLinearLayout;
            CompositeDisposable compositeDisposable;
            iOpenWeatherMap mService;

            //for 5 days///
    TextView txt_city_name_5,txt_coords_5;
    RecyclerView forcast_recycler;

///////////////////////////////////
            static TodatWeatherFragment instance;
                public static TodatWeatherFragment getInstance(){
                 if(instance==null)
                    instance=new TodatWeatherFragment();
                return instance;
                }
    View view;
    public TodatWeatherFragment() {
        compositeDisposable =new CompositeDisposable();
        Retrofit retrofit= RetrofitClient.getInstance();
        mService =retrofit.create(iOpenWeatherMap.class);

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_todat_weather, container, false);
       imageView=(ImageView)view.findViewById(R.id.img_weather);
       progressBar=(ProgressBar)view.findViewById(R.id.loading);
       rootLinearLayout=(LinearLayout)view.findViewById(R.id.weather_panel) ;
       txt_city_name=(TextView)view.findViewById(R.id.txt_city_name);
        txt_temperature=(TextView)view.findViewById(R.id.txt_temperature);
        txt_description=(TextView)view.findViewById(R.id.txt_description);
        txt_date_time=(TextView)view.findViewById(R.id.txt_date_time);
        txt_wind=(TextView)view.findViewById(R.id.txt_wind);
        txt_pressure=(TextView)view.findViewById(R.id.txt_pressure);
        txt_humidity=(TextView)view.findViewById(R.id.txt_humidity);
        txt_sunrise=(TextView)view.findViewById(R.id.txt_sunrise);
        txt_sunset=(TextView)view.findViewById(R.id.txt_sunset);
        txt_coords=(TextView)view.findViewById(R.id.txt_coords);

        //5 days////
        txt_city_name_5=(TextView)view.findViewById(R.id.txt_city_name_5);
        txt_coords_5=(TextView)view.findViewById(R.id.txt_coords_5);
        forcast_recycler=(RecyclerView)view.findViewById(R.id.forcast_recycler);
        forcast_recycler.setHasFixedSize(true);
        forcast_recycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        GetForcastWeatherInfo();
        //////
        
        GetWeatherInformation();
        
        
        return view;
    }

    private void GetForcastWeatherInfo() {
        compositeDisposable.add(mService.getforcastWeatherByLanLng
                (String.valueOf(common.current_location.getLatitude()),
                String.valueOf(common.current_location.getLongitude()),
                common.API_ID,
                "metric" )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WeatherforcastResult>() {
                    @Override
                    public void accept(WeatherforcastResult weatherforcastResult) throws Exception {

                        txt_city_name_5.setText(new StringBuilder(weatherforcastResult.city.name));
                        txt_coords_5.setText(new StringBuilder(weatherforcastResult.city.coord.toString()));
                        WeatherForcastRecyclerAdapter adapter=new WeatherForcastRecyclerAdapter(getContext(),weatherforcastResult);
                        forcast_recycler.setAdapter(adapter);



                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(getActivity(),"Forcast ERROR"+throwable,Toast.LENGTH_SHORT).show();
                    }
                }));

    }

    private void GetWeatherInformation() {
        compositeDisposable.add(mService.getWeatherByLanLng(String.valueOf(common.current_location.getLatitude()),
                String.valueOf(common.current_location.getLongitude()),
                common.API_ID,
                "metric" )
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<WeatherResult>() {
            @Override
            public void accept(WeatherResult weatherResult) throws Exception {
                Picasso.get().load(new StringBuilder("https://openweathermap.org/img/w/").
                        append(weatherResult.getWeather().get(0).getIcon())
                .append(".png").toString()).into(imageView);
                txt_city_name.setText(weatherResult.getName());
                txt_description.setText(new StringBuilder("Weather in ")
                .append(weatherResult.getName()).toString());
                txt_wind.setText(new StringBuilder(String.valueOf(weatherResult.getWind().getSpeed())).append(" speed, ").append(String.valueOf(weatherResult.getWind().getDeg())).append(" Deg").toString());
                txt_temperature.setText(new StringBuilder(String.valueOf(weatherResult.getMain().getTemp())).append("°C").toString());
                txt_date_time.setText(common.convertUnixToDate(weatherResult.getDt()));
                txt_pressure.setText(new StringBuilder(String.valueOf(weatherResult.getMain().getPressure())).append(" hpa").toString());
                txt_humidity.setText(new StringBuilder(String.valueOf(weatherResult.getMain().getHumidity())).append("%").toString());
                txt_sunrise.setText(common.convertUnixToHour(weatherResult.getSys().getSunrise()));
                txt_sunset.setText(common.convertUnixToHour(weatherResult.getSys().getSunset()));
                txt_coords.setText(new StringBuilder(String.valueOf(weatherResult.getCoord())).toString());

                rootLinearLayout.setVisibility(view.VISIBLE);
                progressBar.setVisibility(view.GONE);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Toast.makeText(getActivity(),"ERROR"+throwable,Toast.LENGTH_SHORT).show();
            }
        }));

    }
    @Override
    public void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }

    @Override
    public void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }

}
