package com.example.asiftamal.weatherforcastwithwidget.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asiftamal.weatherforcastwithwidget.Common.common;
import com.example.asiftamal.weatherforcastwithwidget.Model.WeatherforcastResult;
import com.example.asiftamal.weatherforcastwithwidget.R;
import com.squareup.picasso.Picasso;

public class WeatherForcastRecyclerAdapter extends RecyclerView.Adapter<WeatherForcastRecyclerAdapter.ViewHolder> {
Context context;
WeatherforcastResult weatherforcastResult;

 public WeatherForcastRecyclerAdapter(Context context, WeatherforcastResult weatherforcastResult) {
  this.context=context;
  this.weatherforcastResult=weatherforcastResult;
 }

 @NonNull
 @Override
 public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
 View itemView=LayoutInflater.from(context).inflate(R.layout.cardview_for_forcast_recycler,viewGroup,false);
  return new ViewHolder(itemView);
 }

 @Override
 public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

  Picasso.get().load(new StringBuilder("https://openweathermap.org/img/w/").
          append(weatherforcastResult.list.get(i).weather.get(0).getIcon())
          .append(".png").toString()).into(viewHolder.img_weather_5);
  viewHolder.txt_date_time_5.setText(new StringBuilder(common.convertUnixToDate(
          weatherforcastResult.list.get(i).dt)));
  viewHolder.txt_description_5.setText(new StringBuilder(weatherforcastResult
  .list.get(i).weather.get(0).getDescription()));
     viewHolder.txt_temperature_5.setText(new StringBuilder(String.valueOf(weatherforcastResult
             .list.get(i).main.getTemp())).append("°C").toString());


 }

 @Override
 public int getItemCount() {
  return weatherforcastResult.list.size();
 }

 public class ViewHolder extends RecyclerView.ViewHolder{
   TextView txt_date_time_5,txt_temperature_5,txt_description_5;
   ImageView img_weather_5;

   public ViewHolder(@NonNull View itemView) {
    super(itemView);
    img_weather_5=(ImageView)itemView.findViewById(R.id.img_weather_5);
    txt_temperature_5=(TextView)itemView.findViewById(R.id.txt_temperature_5);
    txt_date_time_5=(TextView)itemView.findViewById(R.id.txt_date_time_5);
    txt_description_5=(TextView)itemView.findViewById(R.id.txt_description_5);


   }
  }
 }
