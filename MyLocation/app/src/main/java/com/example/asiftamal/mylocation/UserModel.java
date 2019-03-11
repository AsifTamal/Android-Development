package com.example.asiftamal.mylocation;

class UserModel {
    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    String Password;
            String Username;

    public UserModel(String password, String username) {
        Password = password;
        Username = username;
    }

    public UserModel() {
    }
}
