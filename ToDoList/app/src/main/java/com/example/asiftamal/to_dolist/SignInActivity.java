package com.example.asiftamal.to_dolist;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignInActivity extends AppCompatActivity {

    EditText edttxtsigninemail,edttxtsigninPassword;
    TextView txtSinguppage;
    Button btnsingIn;
    ProgressBar signInprogrssbar;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(!isConnected(SignInActivity.this)) buildDialog(SignInActivity.this).show();
        else {
            setContentView(R.layout.activity_sign_in);
            mAuth = FirebaseAuth.getInstance();
            edttxtsigninemail=(EditText)findViewById(R.id.edttxtSignInEmail);
            edttxtsigninPassword=(EditText)findViewById(R.id.edttxtSignInPassword);
            txtSinguppage=(TextView)findViewById(R.id.txtSignUp);
            btnsingIn=(Button)findViewById(R.id.btnSignin);
            signInprogrssbar=(ProgressBar)findViewById(R.id.ProgressbarSignin) ;
            signinactivity signin=new signinactivity();
            txtSinguppage.setOnClickListener(signin);
            btnsingIn.setOnClickListener(signin);
        }
    }

    private class signinactivity implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.txtSignUp){
                Intent intent= new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(intent);

            }
            else if(v.getId()==R.id.btnSignin){
                UserSignIn();
            }
        }
//firebase sign in
        private void UserSignIn() {
            String Email=edttxtsigninemail.getText().toString().trim();
            String Password=edttxtsigninPassword.getText().toString().trim();

            if(!validation(Email,Password)){

                signInprogrssbar.setVisibility(View.VISIBLE);
                mAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            finish();
                            Intent intent= new Intent(getApplicationContext(),MainActivityToDoList.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                            edttxtsigninemail.setText("");
                            edttxtsigninPassword.setText("");

                            Toast.makeText(getApplicationContext(),"Sign In Successful",Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(getApplicationContext(),"Sign in Failed",Toast.LENGTH_SHORT).show();
                        }
                        signInprogrssbar.setVisibility(View.GONE);
                    }

                });
            }

        }
    }
    private boolean validation(String email, String password) {


        if(email.isEmpty()){
            edttxtsigninemail.setError("Please Enter Email");
            edttxtsigninemail.requestFocus();
            return true;

        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            edttxtsigninemail.setError("Please Enter a valid Email");
            edttxtsigninemail.requestFocus();
            return true;
        }
        if(password.isEmpty()){
            edttxtsigninPassword.setError("Please Enter Paswword");
            edttxtsigninPassword.requestFocus();
            return true;
        }
        if(password.length()<6){
            edttxtsigninPassword.setError("Paswword should be more than 6 characters");
            edttxtsigninPassword.requestFocus();
            return true;
        }
        return false;


    }



    public boolean isConnected(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = cm.getActiveNetworkInfo();

        if (netinfo != null && netinfo.isConnectedOrConnecting()) {
            android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting())) return true;
            else return false;
        } else
            return false;
    }

    public AlertDialog.Builder buildDialog(Context c) {

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You need to turn on Mobile Data or WiFi to access this App. Press ok to Exit");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });

        return builder;
    }
}
