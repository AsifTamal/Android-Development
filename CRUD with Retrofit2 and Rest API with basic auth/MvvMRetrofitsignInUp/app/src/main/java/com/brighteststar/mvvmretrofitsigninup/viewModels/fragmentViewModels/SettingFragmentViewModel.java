package com.brighteststar.mvvmretrofitsigninup.viewModels.fragmentViewModels;

import android.app.AlertDialog;
import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.brighteststar.mvvmretrofitsigninup.activities.LoginActivity;
import com.brighteststar.mvvmretrofitsigninup.activities.MainActivity;
import com.brighteststar.mvvmretrofitsigninup.activities.storage.SharedPrefManager;
import com.brighteststar.mvvmretrofitsigninup.models.DefaultResponse;
import com.brighteststar.mvvmretrofitsigninup.models.LoginResponse;
import com.brighteststar.mvvmretrofitsigninup.models.User;
import com.brighteststar.mvvmretrofitsigninup.repositories.Repository;

public class SettingFragmentViewModel extends AndroidViewModel {
    Application application;
    Repository repository;
    public ObservableField<String> email = new ObservableField<>("");
    public ObservableField<String> password = new ObservableField<>("");
    public ObservableField<String> newPassword = new ObservableField<>("");
    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> school = new ObservableField<>("");
    public MutableLiveData<LoginResponse> updateinfoResponseVal;
    public MutableLiveData<DefaultResponse> defResponseVal;
    User user;

    public SettingFragmentViewModel(@NonNull Application application) {
        super(application);
        this.application=application;
        repository=new Repository(application);
        user = SharedPrefManager.getInstance(application).getUser();
        if(updateinfoResponseVal!=null){
            updateinfoResponseVal= repository.updateUserInfo(user.getId(),email.get(),name.get(),school.get());
        }else {
            updateinfoResponseVal=new MutableLiveData<>();
        }

        defResponseVal=new MutableLiveData<>();
    }

    public void updateUser(){

        updateinfoResponseVal= repository.updateUserInfo(user.getId(),email.get(),name.get(),school.get());


    }
    public MutableLiveData<LoginResponse> getLoginresponse(){
        return updateinfoResponseVal;
    }
    public MutableLiveData<DefaultResponse> getDefaultresponse(){
        return defResponseVal;
    }
    public void logout() {
        SharedPrefManager.getInstance(application).clear();
        Intent intent = new Intent(application, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        application.startActivity(intent);
    }

    public void updatePassword() {
        User user = SharedPrefManager.getInstance(application).getUser();
        defResponseVal= repository.updatePassword(user.getEmail(),password.get(),newPassword.get());
    }

    public void deleteUser() {
                User user = SharedPrefManager.getInstance(application).getUser();
                SharedPrefManager.getInstance(application).clear();
                Intent intent = new Intent(application, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                application.startActivity(intent);
                defResponseVal=new MutableLiveData<>();
                defResponseVal= repository.deleteUser(user.getId());
    }
//    public MutableLiveData<LoginResponse> getResponseval() {
//        return updateinfoResponseVal;
//    }
}
