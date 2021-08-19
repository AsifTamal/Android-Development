package com.brighteststar.mvvmretrofitsigninup.viewModels;

import android.app.Application;
import android.util.Patterns;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.brighteststar.mvvmretrofitsigninup.models.DefaultResponse;
import com.brighteststar.mvvmretrofitsigninup.repositories.Repository;
//viewmodel name must be start with Capitalcase
public class CreateUserViewModel extends AndroidViewModel {
    Application application;
    public ObservableField<String> email = new ObservableField<>("");
    public ObservableField<String> password = new ObservableField<>("");
    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> school = new ObservableField<>("");
    Repository repository;
    public MutableLiveData<DefaultResponse> defResponseVal;

    public CreateUserViewModel(@NonNull Application application) {
        super(application);
        this.application=application;
        repository=new Repository(application);
        defResponseVal=new MutableLiveData<>();

    }
    public void CreateUser(){
          defResponseVal=repository.createuser(email.get(),password.get(),name.get(),school.get());
    }
}
