package com.brighteststar.mvvmretrofitsigninup.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brighteststar.mvvmretrofitsigninup.R;
import com.brighteststar.mvvmretrofitsigninup.databinding.FragmentHomeBinding;
import com.brighteststar.mvvmretrofitsigninup.models.User;
import com.brighteststar.mvvmretrofitsigninup.viewModels.fragmentViewModels.HomeFragmentViewModel;
import com.brighteststar.mvvmretrofitsigninup.viewModels.fragmentViewModels.SettingFragmentViewModel;


public class HomeFragment extends Fragment {

    FragmentHomeBinding fragmentHomeBinding;
    HomeFragmentViewModel homeFragmentViewModel;
    View view;
    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentHomeBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_home, container, false);
        view=fragmentHomeBinding.getRoot();
        homeFragmentViewModel = ViewModelProviders.of(this).get(HomeFragmentViewModel.class);
        fragmentHomeBinding.setHomeviewmodel(homeFragmentViewModel);
        fragmentHomeBinding.setLifecycleOwner(this);
      //  return inflater.inflate(R.layout.fragment_home, container, false);
        homeFragmentViewModel.user.observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                fragmentHomeBinding.textViewEmail.setText(user.getEmail());
                fragmentHomeBinding.textViewName.setText(user.getName());
                fragmentHomeBinding.textViewSchool.setText(user.getSchool());
            }
        });


        return view;
    }
}