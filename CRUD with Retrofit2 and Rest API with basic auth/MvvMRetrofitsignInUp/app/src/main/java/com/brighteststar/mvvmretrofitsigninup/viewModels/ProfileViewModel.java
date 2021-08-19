package com.brighteststar.mvvmretrofitsigninup.viewModels;

import android.app.Application;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;

import com.brighteststar.mvvmretrofitsigninup.R;
import com.brighteststar.mvvmretrofitsigninup.fragments.HomeFragment;
import com.brighteststar.mvvmretrofitsigninup.fragments.SettingFragment;
import com.brighteststar.mvvmretrofitsigninup.fragments.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileViewModel extends AndroidViewModel {

    public boolean firstStarted;
    Application application;
    public Fragment fag;


    public ProfileViewModel(@NonNull Application application) {
        super(application);
        this.application=application;
        fag=new HomeFragment();
        firstStarted=true;

    }

    public void setFragment(Fragment fragment){
        fag=fragment;

    }
    public Fragment getFragment(){
        return fag;

    }

    public void setFirststarted() {
        firstStarted=false;
    }
}
