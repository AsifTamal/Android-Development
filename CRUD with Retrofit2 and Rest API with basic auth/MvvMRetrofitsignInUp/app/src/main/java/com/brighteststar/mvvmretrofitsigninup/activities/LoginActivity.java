package com.brighteststar.mvvmretrofitsigninup.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.widget.Toast;

import com.brighteststar.mvvmretrofitsigninup.R;
import com.brighteststar.mvvmretrofitsigninup.activities.storage.SharedPrefManager;
import com.brighteststar.mvvmretrofitsigninup.click.ButtonClickLogin;
import com.brighteststar.mvvmretrofitsigninup.databinding.ActivityLoginBinding;
import com.brighteststar.mvvmretrofitsigninup.models.LoginResponse;
import com.brighteststar.mvvmretrofitsigninup.viewModels.CreateUserViewModel;
import com.brighteststar.mvvmretrofitsigninup.viewModels.LoginViewModel;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding loginBinding;
    LoginViewModel loginViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        loginBinding.setLoginviewmodel(loginViewModel);
        loginBinding.setLifecycleOwner(this);
        loginViewModel.loginResponseVal.observe(this, new Observer<LoginResponse>() {
            @Override
            public void onChanged(LoginResponse loginResponse) {


                if (!loginResponse.isError()) {

                    SharedPrefManager.getInstance(LoginActivity.this)
                            .saveUser(loginResponse.getUser());

                    Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
        loginBinding.setClickfunctionlogin(new ButtonClickLogin() {
            @Override
            public void loginClick() {

                String email = loginBinding.editTextEmail.getText().toString().trim();
                String password = loginBinding.editTextPassword.getText().toString().trim();
                if (email.isEmpty()) {
                    loginBinding.editTextEmail.setError("Email is required");
                    loginBinding.editTextEmail.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    loginBinding.editTextEmail.setError("Enter a valid email");
                    loginBinding.editTextEmail.requestFocus();
                    return;
                }

                if (password.isEmpty()) {
                    loginBinding.editTextPassword.setError("Password required");
                    loginBinding.editTextPassword.requestFocus();
                    return;
                }

                if (password.length() < 6) {
                    loginBinding.editTextPassword.setError("Password should be atleast 6 character long");
                    loginBinding.editTextPassword.requestFocus();
                    return;
                }
                loginViewModel.userLogin();
            }

            @Override
            public void goUserCreate() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();

        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
}