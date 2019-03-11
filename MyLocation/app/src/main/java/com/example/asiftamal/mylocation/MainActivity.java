package com.example.asiftamal.mylocation;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText edtname,edtpass;
    Button btnlogIn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtname=(EditText)findViewById(R.id.edtnameid);
        edtpass=(EditText)findViewById(R.id.edtpassid);
        btnlogIn=(Button)findViewById(R.id.btnlogin);
        btnlogIn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnlogin){

            userLogin();

        }





    }

    private void userLogin() {

        String email = edtname.getText().toString().trim();
        String password = edtpass.getText().toString().trim();

        if (email.isEmpty()) {
            edtname.setError("Email is required");
            edtname.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtname.setError("Enter a valid email");
            edtname.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            edtpass.setError("Password required");
            edtpass.requestFocus();
            return;
        }

        if (password.length() < 4) {
            edtpass.setError("Password should be atleast 6 character long");
            edtpass.requestFocus();
            return;
        }

        Call<LoginResponse> call = new RetrofitClient(email+":"+password)
                .getApi().userLogin();

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if(null !=response.body()) {
                    LoginResponse loginResponse =response.body() ;
                    if (!loginResponse.isError()) {


                        Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);


                    } else {
                        Toast.makeText(MainActivity.this, "Login Fail", Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(MainActivity.this, "Invalid credentials.", Toast.LENGTH_LONG).show();
                }


            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

                Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });

    }
}
