package com.brighteststar.mvvmretrofitsigninup.viewModels.fragmentViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.brighteststar.mvvmretrofitsigninup.activities.storage.SharedPrefManager;
import com.brighteststar.mvvmretrofitsigninup.models.User;
import com.brighteststar.mvvmretrofitsigninup.repositories.Repository;

public class HomeFragmentViewModel extends AndroidViewModel {
    Application application;
    Repository repository;
    public MutableLiveData<User> user;
    User usermodel;
    public ObservableField<String> email = new ObservableField<>("");
    public ObservableField<String> password = new ObservableField<>("");
    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> school = new ObservableField<>("");
    public HomeFragmentViewModel(@NonNull Application application) {
        super(application);
        this.application=application;
        repository=new Repository(application);
        user=new MutableLiveData<>();
        usermodel=new User();
        getUser();
        //for binding
//        email.set(usermodel.getEmail());
//        name.set(usermodel.getName());
//        school.set(usermodel.getSchool());
    }

    private void getUser() {
        //for observer live data
        usermodel.setId(SharedPrefManager.getInstance(application).getUser().getId());
        usermodel.setEmail(SharedPrefManager.getInstance(application).getUser().getEmail());
        usermodel.setName(SharedPrefManager.getInstance(application).getUser().getName());
        usermodel.setSchool(SharedPrefManager.getInstance(application).getUser().getSchool());

        user.setValue(usermodel);
    }
    public MutableLiveData<User> getuser(){
        return user;
    }

}
