package com.example.asiftamal.chinesebanglaenglishdictionary;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asiftamal.chinesebanglaenglishdictionary.db.AdmindbClass;

import java.io.IOException;

public class MainActivityAdmin extends AppCompatActivity {
        AdmindbClass admindbClasshelper;
        private EditText edtinputLoginuseroremail,edtinputLoginpassword;
        private Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);
        btnlogin=(Button)findViewById(R.id.btnAdiminLogin);
        edtinputLoginuseroremail=(EditText)findViewById(R.id.signInusernameEditTextId);
        edtinputLoginpassword=(EditText)findViewById(R.id.signInpasswordEditTextId);

        admindbClasshelper=new AdmindbClass(this);

        try {
            admindbClasshelper.checkAndCopyDatabase();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

     // SQLiteDatabase  sqLiteDatabase = admindbClasshelper.getWritableDatabase();
        ClassAdminlogin loginAdmin=new ClassAdminlogin();
          btnlogin.setOnClickListener(loginAdmin);


    }

    private class ClassAdminlogin implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String Username=edtinputLoginuseroremail.getText().toString();
        String Password=edtinputLoginpassword.getText().toString();
        if(v.getId()==R.id.btnAdiminLogin){
            boolean result=admindbClasshelper.findPassword(Username,Password);
            if(result){
                Intent intent=new Intent(MainActivityAdmin.this,AdminPanelActivity.class);
                startActivity(intent);
               }
               else {
                Toast.makeText(getApplicationContext(),"Username Password Didn't match",Toast.LENGTH_SHORT).show();
            }
        }
        }
    }


}
