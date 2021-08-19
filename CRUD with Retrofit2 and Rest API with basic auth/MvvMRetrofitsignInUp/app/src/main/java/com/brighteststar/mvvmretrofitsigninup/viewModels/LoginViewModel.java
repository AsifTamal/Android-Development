package com.brighteststar.mvvmretrofitsigninup.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.brighteststar.mvvmretrofitsigninup.models.LoginResponse;
import com.brighteststar.mvvmretrofitsigninup.repositories.Repository;

public class LoginViewModel extends AndroidViewModel {
    Application application;
    public ObservableField<String> email = new ObservableField<>("");
    public ObservableField<String> password = new ObservableField<>("");
    Repository repository;
    public MutableLiveData<LoginResponse> loginResponseVal;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        this.application=application;
        repository=new Repository(application);
        loginResponseVal=new MutableLiveData<>();

    }
    public void userLogin(){

        loginResponseVal=repository.userLogin(email.get(),password.get());
    }
}
