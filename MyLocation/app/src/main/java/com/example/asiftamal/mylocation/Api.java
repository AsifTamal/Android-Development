package com.example.asiftamal.mylocation;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    @POST("login")
    Call<LoginResponse> userLogin();
}
