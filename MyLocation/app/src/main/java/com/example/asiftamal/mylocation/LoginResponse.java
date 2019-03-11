package com.example.asiftamal.mylocation;

public class LoginResponse {


    public LoginResponse(boolean error, UserModel userModel) {
        this.error = error;
        this.userModel = userModel;
    }
    private boolean error;

    public boolean isError() {
        return error;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    private UserModel userModel;
}
