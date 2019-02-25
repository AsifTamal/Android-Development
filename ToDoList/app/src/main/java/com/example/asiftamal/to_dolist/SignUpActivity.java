package com.example.asiftamal.to_dolist;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
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

public class SignUpActivity extends AppCompatActivity {
    EditText edttxtsignupemail,edttxtsignupPassword;
    TextView txtSinginpage;
    Button btnsingup;
    private FirebaseAuth mAuth;
    ProgressBar signUpprogrssbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        edttxtsignupemail=(EditText)findViewById(R.id.edttxtSignUpEmail);
        edttxtsignupPassword=(EditText)findViewById(R.id.edttxtSignUpPassword);
        txtSinginpage=(TextView)findViewById(R.id.txtSignIn);
        btnsingup=(Button)findViewById(R.id.btnSignUp);
        signUpprogrssbar=(ProgressBar)findViewById(R.id.ProgressbarSignUp) ;
        mAuth = FirebaseAuth.getInstance();
         signupactivity signup=new signupactivity();
         txtSinginpage.setOnClickListener(signup);
        btnsingup.setOnClickListener(signup);

    }

    private class signupactivity implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.txtSignIn){
                Intent intent= new Intent(getApplicationContext(),SignInActivity.class);
                startActivity(intent);

            }
            else if(v.getId()==R.id.btnSignUp){
            UserRegistration();

            }

        }
//firebase registration
        private void UserRegistration() {
        String Email=edttxtsignupemail.getText().toString().trim();
        String Password=edttxtsignupPassword.getText().toString().trim();

        validation(Email,Password);
            signUpprogrssbar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    Toast.makeText(getApplicationContext(),"Sign Up Successful",Toast.LENGTH_SHORT).show();
                    edttxtsignupemail.setText("");
                    edttxtsignupPassword.setText("");
                    Intent intent= new Intent(getApplicationContext(),SignInActivity.class);
                    startActivity(intent);

                } else {
                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(),"User Already Registered",Toast.LENGTH_SHORT).show();
                    }
                   else {
                        Toast.makeText(getApplicationContext(),"Error : " +task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
                signUpprogrssbar.setVisibility(View.GONE);
            }
        });


        }

        private void validation(String email, String password) {


            if(email.isEmpty()){
                edttxtsignupemail.setError("Please Enter Email");
                edttxtsignupemail.requestFocus();

            }
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                edttxtsignupemail.setError("Please Enter a valid Email");
                edttxtsignupemail.requestFocus();

            }
            if(password.isEmpty()){
                edttxtsignupPassword.setError("Please Enter Paswword");
                edttxtsignupPassword.requestFocus();

            }
            if(password.length()<6){
                edttxtsignupPassword.setError("Paswword should be more than 6 characters");
                edttxtsignupPassword.requestFocus();

            }



        }
    }
}
