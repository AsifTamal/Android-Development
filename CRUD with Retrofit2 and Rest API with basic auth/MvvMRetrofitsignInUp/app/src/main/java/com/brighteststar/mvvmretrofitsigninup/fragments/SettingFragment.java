package com.brighteststar.mvvmretrofitsigninup.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.brighteststar.mvvmretrofitsigninup.R;
import com.brighteststar.mvvmretrofitsigninup.activities.storage.SharedPrefManager;
import com.brighteststar.mvvmretrofitsigninup.click.SettingButtonClick;
import com.brighteststar.mvvmretrofitsigninup.databinding.FragmentSettingBinding;
import com.brighteststar.mvvmretrofitsigninup.models.DefaultResponse;
import com.brighteststar.mvvmretrofitsigninup.models.LoginResponse;
import com.brighteststar.mvvmretrofitsigninup.models.User;
import com.brighteststar.mvvmretrofitsigninup.viewModels.LoginViewModel;
import com.brighteststar.mvvmretrofitsigninup.viewModels.fragmentViewModels.SettingFragmentViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SettingFragment extends Fragment {

    FragmentSettingBinding settingBinding;
    SettingFragmentViewModel settingFragmentViewModel;
    View view;
    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        settingBinding = DataBindingUtil.inflate(
                 inflater, R.layout.fragment_setting, container, false);
        view=settingBinding.getRoot();
        settingFragmentViewModel = ViewModelProviders.of(this).get(SettingFragmentViewModel.class);
        settingBinding.setSettingviewmodel(settingFragmentViewModel);
        settingBinding.setLifecycleOwner(this);
        settingFragmentViewModel.getDefaultresponse().observe(this, new Observer<DefaultResponse>() {
            @Override
            public void onChanged(DefaultResponse loginResponse) {
                Toast.makeText(getActivity(), loginResponse.getMsg().toString(), Toast.LENGTH_SHORT).show();
            }
        });

       LoadObserverforchangepass();
        LoadButtonClick();


        return view;

    }

    private void LoadButtonClick() {
        settingBinding.setButtonclicksetting(new SettingButtonClick() {
            @Override
            public void updateUserinfo() {
               // Toast.makeText(getActivity(), "updateUserinfo", Toast.LENGTH_SHORT).show();
                String email = settingBinding.editTextEmail.getText().toString().trim();
                String name = settingBinding.editTextName.getText().toString().trim();
                String school = settingBinding.editTextSchool.getText().toString().trim();

                if (email.isEmpty()) {
                    settingBinding.editTextEmail.setError("Email is required");
                    settingBinding.editTextEmail.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    settingBinding.editTextEmail.setError("Enter a valid email");
                    settingBinding.editTextEmail.requestFocus();
                    return;
                }

                if (name.isEmpty()) {
                    settingBinding.editTextName.setError("Name required");
                    settingBinding.editTextName.requestFocus();
                    return;
                }

                if (school.isEmpty()) {
                    settingBinding.editTextSchool.setError("School required");
                    settingBinding.editTextSchool.requestFocus();
                    return;
                }
                settingFragmentViewModel.updateUser();

            }

            @Override
            public void updatePassword() {
                String currentpassword =  settingBinding.editTextCurrentPassword.getText().toString().trim();
                String newpassword =  settingBinding.editTextNewPassword.getText().toString().trim();

                if (currentpassword.isEmpty()) {
                    settingBinding.editTextCurrentPassword.setError("Password required");
                    settingBinding.editTextCurrentPassword.requestFocus();
                    return;
                }

                if (newpassword.isEmpty()) {
                    settingBinding.editTextNewPassword.setError("Enter new password");
                    settingBinding.editTextNewPassword.requestFocus();
                    return;
                }
                settingFragmentViewModel.updatePassword();
            }

            @Override
            public void deleteUserinfo() {
                deleteUser();
            }

            @Override
            public void logout() {
                settingFragmentViewModel.logout();
            }
        });
    }

    private void deleteUser() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Are you sure?");
        builder.setMessage("This action is irreversible...");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                settingFragmentViewModel.deleteUser();

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.create().show();
    }

    private void LoadObserverforchangepass() {
        settingFragmentViewModel.getLoginresponse().observe(this, new Observer<LoginResponse>() {
            @Override
            public void onChanged(LoginResponse LoginResponse) {
                Toast.makeText(getActivity(), LoginResponse.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}