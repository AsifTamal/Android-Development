package com.brighteststar.mvvmretrofitsigninup.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.brighteststar.mvvmretrofitsigninup.R;
import com.brighteststar.mvvmretrofitsigninup.activities.storage.SharedPrefManager;
import com.brighteststar.mvvmretrofitsigninup.databinding.ActivityProfileBinding;
import com.brighteststar.mvvmretrofitsigninup.fragments.HomeFragment;
import com.brighteststar.mvvmretrofitsigninup.fragments.SettingFragment;
import com.brighteststar.mvvmretrofitsigninup.fragments.UserFragment;
import com.brighteststar.mvvmretrofitsigninup.viewModels.ProfileViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class ProfileActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
        ActivityProfileBinding activityProfileBinding;
        ProfileViewModel profileViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityProfileBinding = DataBindingUtil.setContentView(this,R.layout.activity_profile);
        profileViewModel = ViewModelProviders.of(this).get(ProfileViewModel.class);
        activityProfileBinding.setProfileviewmodel(profileViewModel);
        activityProfileBinding.setLifecycleOwner(this);

        BottomNavigationView navigationView = activityProfileBinding.bottomNav;
        navigationView.setOnNavigationItemSelectedListener(this);


        if(profileViewModel.firstStarted){
            displayFragment(profileViewModel.getFragment());
            profileViewModel.setFirststarted();
        }

    }

    private void displayFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.relativeLayout, fragment)
                .commit();
    }



    @Override
    protected void onStart() {
        super.onStart();

        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.menu_home:
                profileViewModel.setFragment(new HomeFragment());
                break;
            case R.id.menu_users:
                profileViewModel.setFragment(new UserFragment());
                break;
            case R.id.menu_settings:
                profileViewModel.setFragment(new SettingFragment());

                break;
        }
        displayFragment( profileViewModel.getFragment());
        Toast.makeText(this, "onNavigationItemSelected", Toast.LENGTH_SHORT).show();
        return false;

}


}