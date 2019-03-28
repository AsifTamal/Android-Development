package com.example.asiftamal.weatherforcastwithwidget.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asiftamal.weatherforcastwithwidget.Common.common;
import com.example.asiftamal.weatherforcastwithwidget.Model.WeatherResult;
import com.example.asiftamal.weatherforcastwithwidget.R;
import com.example.asiftamal.weatherforcastwithwidget.Retrofit.RetrofitClient;
import com.example.asiftamal.weatherforcastwithwidget.Retrofit.iOpenWeatherMap;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.label305.asynctask.SimpleAsyncTask;
import com.mancj.materialsearchbar.MaterialSearchBar;
import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class CityFragment extends Fragment {

    List<String> listcties;
    MaterialSearchBar materialSearchBar;
    ProgressBar progressBar;
    ImageView imageView;
    TextView txt_city_name,txt_temperature,txt_description,txt_date_time,txt_wind,txt_pressure,txt_humidity,txt_sunrise,txt_sunset,txt_coords;
    LinearLayout rootLinearLayout;
    CompositeDisposable compositeDisposable;
    iOpenWeatherMap mService;


    static CityFragment instance;
    public static CityFragment getInstance(){
        if(instance==null)
            instance=new CityFragment();
        return instance;
    }
    View view;
    public CityFragment() {
        // Required empty public constructor
        compositeDisposable =new CompositeDisposable();
        Retrofit retrofit= RetrofitClient.getInstance();
        mService =retrofit.create(iOpenWeatherMap.class);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view= inflater.inflate(R.layout.fragment_city, container, false);
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
        materialSearchBar=(MaterialSearchBar)view.findViewById(R.id.searchBar);
        materialSearchBar.setEnabled(false);


        new loadCties().execute();

        return view;
    }

    private class loadCties extends SimpleAsyncTask<List<String>> {
        @Override
        protected List<String> doInBackgroundSimple() {
            listcties=new ArrayList<>();
            try{
                StringBuilder builder=new StringBuilder();
                InputStream is=getResources().openRawResource(R.raw.city_list);
                GZIPInputStream gzipInputStream=new GZIPInputStream(is);

                InputStreamReader reader=new InputStreamReader(gzipInputStream);
                BufferedReader in =new BufferedReader(reader);

                String readed;
                while ((readed=in.readLine())!=null){
                     builder.append(readed);
                     listcties=new Gson().fromJson(builder.toString(),new TypeToken<List<String>>(){}.getType());
                }


            }catch(IOException e){
                    e.printStackTrace();
            }
            return listcties;
        }

        @Override
        protected void onSuccess(final List<String> listCities) {
            super.onSuccess(listCities);
            materialSearchBar.setEnabled(true);
            materialSearchBar.addTextChangeListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                List<String> suggest=new ArrayList<>();
                for(String search: listCities){
                    if(search.toLowerCase().contains(materialSearchBar.getText().toLowerCase()));
                    suggest.add(search);
                }
                materialSearchBar.setLastSuggestions(suggest);
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            materialSearchBar.setOnSearchActionListener(new MaterialSearchBar.OnSearchActionListener() {
                @Override
                public void onSearchStateChanged(boolean enabled) {

                }

                @Override
                public void onSearchConfirmed(CharSequence text) {
                    GetWeatherInfo(text.toString());

                    materialSearchBar.setLastSuggestions(listCities);
                }

                @Override
                public void onButtonClicked(int buttonCode) {

                }
            });
            materialSearchBar.setLastSuggestions(listCities);
            progressBar.setVisibility(View.GONE);
            rootLinearLayout.setVisibility(view.GONE);
        }
    }

    private void GetWeatherInfo(String cityName) {
        compositeDisposable.add(mService.getWeatherByCityName(cityName,
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
