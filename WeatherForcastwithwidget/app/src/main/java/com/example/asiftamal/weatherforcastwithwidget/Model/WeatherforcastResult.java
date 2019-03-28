package com.example.asiftamal.weatherforcastwithwidget.Model;

import java.util.List;

public class WeatherforcastResult {
    public String cod ;
    public double message;
    public int cnt ;
    public List<myList> list ;
    public City city;

    public WeatherforcastResult() {
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<myList> getList() {
        return list;
    }

    public void setList(List<myList> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
