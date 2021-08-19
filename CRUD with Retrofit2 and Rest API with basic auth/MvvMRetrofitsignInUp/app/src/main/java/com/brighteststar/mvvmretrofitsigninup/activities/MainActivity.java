package com.brighteststar.mvvmretrofitsigninup.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Toast;

import com.brighteststar.mvvmretrofitsigninup.R;
import com.brighteststar.mvvmretrofitsigninup.click.ButtonClick;
import com.brighteststar.mvvmretrofitsigninup.databinding.ActivityMainBinding;
import com.brighteststar.mvvmretrofitsigninup.models.DefaultResponse;
import com.brighteststar.mvvmretrofitsigninup.viewModels.CreateUserViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;
    CreateUserViewModel createUserviewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        createUserviewModel = ViewModelProviders.of(this).get(CreateUserViewModel.class);
        mainBinding.setCcretd(createUserviewModel);
        mainBinding.setLifecycleOwner(this);
        createUserviewModel.defResponseVal.observe(this, new Observer<DefaultResponse>() {
            @Override
            public void onChanged(@Nullable DefaultResponse defaultResponse) {
                assert defaultResponse != null;
                if(defaultResponse.getMsg()!=null){
                  // Toast.makeText(MainActivity.this, defaultResponse.getMsg().toString(), Toast.LENGTH_SHORT).show();
                }
                  //  activityLoginBinding.textval.setText(loginResponse.getUser().getEmail());
                //    Toast.makeText(MainActivity.this, defaultResponse.getMsg().toString(), Toast.LENGTH_SHORT).show();
            }

        });

        mainBinding.setClickfunction(new ButtonClick() {
            @Override
            public void getData() {
                String email = mainBinding.editTextEmail.getText().toString().trim();
                String password = mainBinding.editTextPassword.getText().toString().trim();
                String name = mainBinding.editTextName.getText().toString().trim();
                String school = mainBinding.editTextSchool.getText().toString().trim();

                if (email.isEmpty()) {
                    mainBinding.editTextEmail.setError("Email is required");
                    mainBinding.editTextEmail.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher( email).matches()) {
                    mainBinding.editTextEmail.setError("Enter a valid email");
                    mainBinding.editTextEmail.requestFocus();
                    return;
                }

                if (password.isEmpty()) {
                    mainBinding.editTextPassword.setError("Password required");
                    mainBinding.editTextPassword.requestFocus();
                    return;
                }

                if (password.length() < 6) {
                    mainBinding.editTextPassword.setError("Password should be atleast 6 character long");
                    mainBinding.editTextPassword.requestFocus();
                    return;
                }

                if (name.isEmpty()) {
                    mainBinding.editTextName.setError("Name required");
                    mainBinding.editTextName.requestFocus();
                    return;
                }

                if (school.isEmpty()) {
                    mainBinding.editTextSchool.setError("School required");
                    mainBinding.editTextSchool.requestFocus();
                    return;
                }
                createUserviewModel.CreateUser();
            }

            @Override
            public void goLogin() {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

    }
}