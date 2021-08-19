package com.brighteststar.mvvmretrofitsigninup.viewModels.fragmentViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.brighteststar.mvvmretrofitsigninup.models.LoginResponse;
import com.brighteststar.mvvmretrofitsigninup.models.UsersResponse;
import com.brighteststar.mvvmretrofitsigninup.repositories.Repository;

public class UserFragmentViewModel extends AndroidViewModel {
    Application application;
    Repository repository;
    public MutableLiveData<UsersResponse> userResponseVal;
    public UserFragmentViewModel(@NonNull Application application) {
        super(application);
        this.application=application;
        repository=new Repository(application);
        userResponseVal=new MutableLiveData<>();
        getAllUsers();
    }

    public void getAllUsers(){
        userResponseVal=repository.getallUser();

    }
    public MutableLiveData<UsersResponse> getAllUserslivedata(){
        return userResponseVal;
    }
}
