package com.brighteststar.mvvmretrofitsigninup.repositories;

import android.app.Application;
import android.content.Intent;
import android.widget.Toast;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;

import com.brighteststar.mvvmretrofitsigninup.activities.MainActivity;
import com.brighteststar.mvvmretrofitsigninup.activities.ProfileActivity;
import com.brighteststar.mvvmretrofitsigninup.activities.storage.SharedPrefManager;
import com.brighteststar.mvvmretrofitsigninup.api.RetroClass;
import com.brighteststar.mvvmretrofitsigninup.models.DefaultResponse;
import com.brighteststar.mvvmretrofitsigninup.models.LoginResponse;
import com.brighteststar.mvvmretrofitsigninup.models.UsersResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private MutableLiveData<DefaultResponse> dataDefaultResponse ;
    private MutableLiveData<LoginResponse> dataLoginResponse ;
    private MutableLiveData<UsersResponse> dataUserResponse ;
    Application application;
    public Repository(Application application) {
        this.application=application;
        dataDefaultResponse = new MutableLiveData<>();
        dataLoginResponse = new MutableLiveData<>();
        dataUserResponse = new MutableLiveData<>();
    }

    public MutableLiveData<DefaultResponse> createuser(String email, String password, String name, String school) {
        Call<DefaultResponse> createusercall = RetroClass
                .getRetroInstance().getApiService().createUser(email, password,name,school);
        createusercall.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {

                if (response.code() == 201) {

                    DefaultResponse dr = response.body();
                    dataDefaultResponse.setValue(response.body());
                    Toast.makeText(application, response.body().getMsg().toString(), Toast.LENGTH_SHORT).show();

                } else if (response.code() == 422) {
                    Toast.makeText(application, "User already exist", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                Toast.makeText(application, t.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return dataDefaultResponse;
    }

    public MutableLiveData<LoginResponse> userLogin(String email, String password) {

        Call<LoginResponse> logincall = RetroClass
                .getRetroInstance().getApiService().userLogin(email, password);
        logincall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse dr = response.body();
                dataLoginResponse.setValue(dr);

                if (!dr.isError()) {

                    SharedPrefManager.getInstance(application)
                            .saveUser(dr.getUser());

                    Intent intent = new Intent(application, ProfileActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    application.startActivity(intent);
                    Toast.makeText(application, dr.getMessage(), Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(application, dr.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(application, t.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return dataLoginResponse;
    }

    public MutableLiveData<LoginResponse> updateUserInfo(int id, String email, String name, String school) {
        Call<LoginResponse> updateinfocall = RetroClass
                .getRetroInstance().getApiService().updateUser(id,email, name,school);
        updateinfocall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse dr = response.body();
                dataLoginResponse.setValue(dr);

                if (!dr.isError()) {
                //  Toast.makeText(application, dr.getMessage(), Toast.LENGTH_LONG).show();
                } else {
                   // Toast.makeText(application, dr.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
        return dataLoginResponse;
    }

    public MutableLiveData<DefaultResponse> updatePassword(String Email, String currentpassword, String newpassword) {

        Call<DefaultResponse> call = RetroClass
                .getRetroInstance().getApiService()
                .updatePassword(currentpassword, newpassword, Email);

        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                DefaultResponse dr = response.body();
                dataDefaultResponse.setValue(dr);
                Toast.makeText(application, response.body().getMsg(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                Toast.makeText(application, t.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });
        return dataDefaultResponse;
    }

    public MutableLiveData<DefaultResponse> deleteUser(int id) {

        Call<DefaultResponse> call = RetroClass
                .getRetroInstance().getApiService()
                .deleteUser(id);
        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {

                if (!response.body().isErr()) {
                    DefaultResponse dr = response.body();
                    dataDefaultResponse.setValue(dr);
                    SharedPrefManager.getInstance(application).clear();
                    SharedPrefManager.getInstance(application).clear();
                    Intent intent = new Intent(application, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    application.startActivity(intent);
                }

                Toast.makeText(application, response.body().getMsg(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {

            }
        });
        return dataDefaultResponse;
    }

    public MutableLiveData<UsersResponse> getallUser() {
        Call<UsersResponse> call = RetroClass
                .getRetroInstance().getApiService()
                .getUsers();
        call.enqueue(new Callback<UsersResponse>() {
            @Override
            public void onResponse(Call<UsersResponse> call, Response<UsersResponse> response) {
                dataUserResponse.setValue(response.body());
            }

            @Override
            public void onFailure(Call<UsersResponse> call, Throwable t) {

            }
        });
        return dataUserResponse;
    }
}
