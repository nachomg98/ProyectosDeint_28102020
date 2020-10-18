package com.example.changemessage;

import android.app.Application;

import com.example.changemessage.model.User;

public class ChangeMessageAplication extends Application {
    private User user;

    public User getUser() {
        return user;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        user = new User("juanjo", "dam.juanjo.lago.sanchez@gmail.com");
    }
}
