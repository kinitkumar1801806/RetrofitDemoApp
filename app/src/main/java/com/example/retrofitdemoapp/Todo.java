package com.example.retrofitdemoapp;

public class Todo {
    private int id;
    private int userTd;
    private String title;
    private boolean completed;

    public Todo(int id, int userTd, String title, boolean completed) {
        this.id = id;
        this.userTd = userTd;
        this.title = title;
        this.completed = completed;
    }
    public Todo(int userId, String title, boolean completed) {
        this.userTd = userId;
        this.title = title;
        this.completed = completed;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserTd() {
        return userTd;
    }

    public void setUserTd(int userTd) {
        this.userTd = userTd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
