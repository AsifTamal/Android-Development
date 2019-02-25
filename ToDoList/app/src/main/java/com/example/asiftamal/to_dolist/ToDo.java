package com.example.asiftamal.to_dolist;

public class ToDo {


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ToDo(String id, String title, String description, String userId, String date, Boolean state) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.date = date;
        this.state = state;

    }

    String id,title,description,userId,date;
    Boolean state;

    public ToDo() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }




}
