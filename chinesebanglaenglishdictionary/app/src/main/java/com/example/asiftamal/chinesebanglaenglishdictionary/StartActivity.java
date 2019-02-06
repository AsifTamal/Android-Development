package com.example.asiftamal.chinesebanglaenglishdictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.asiftamal.chinesebanglaenglishdictionary.db.AdmindbClass;
import com.example.asiftamal.chinesebanglaenglishdictionary.dictionaryfiles.DefaultDictionaryActivity;

import java.io.IOException;

public class StartActivity extends AppCompatActivity implements View.OnClickListener{
Button btnAdminpage, btnDefaultPage;
    AdmindbClass admindbClasshelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //region Splash screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //endregion
        setContentView(R.layout.activity_start);
        btnAdminpage=(Button)findViewById(R.id.btnAdmin);
        btnDefaultPage=(Button)findViewById(R.id.btnGuest);

        btnDefaultPage.setOnClickListener(this);
        btnAdminpage.setOnClickListener(this);
        admindbClasshelper=new AdmindbClass(this);

        try {
            admindbClasshelper.checkAndCopyDatabase();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnAdmin){
            Intent intent=new Intent(StartActivity.this,MainActivityAdmin.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.btnGuest){
            Intent intent=new Intent(StartActivity.this,DefaultDictionaryActivity.class);
            startActivity(intent);
        }

    }
}
