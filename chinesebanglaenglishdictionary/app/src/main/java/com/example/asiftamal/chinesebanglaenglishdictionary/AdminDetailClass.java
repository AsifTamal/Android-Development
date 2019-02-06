package com.example.asiftamal.chinesebanglaenglishdictionary;

public class AdminDetailClass {
    private int id;
    private String name;
    private String email;
    private String username;
    private String passwword;


    public AdminDetailClass(int id, String name, String email, String username, String passwword) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.passwword = passwword;
    }


    public AdminDetailClass() {
    }

    public int getId() {
    return id;
}

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswword() {
        return passwword;
    }

    public void setPasswword(String passwword) {
        this.passwword = passwword;
    }


}
