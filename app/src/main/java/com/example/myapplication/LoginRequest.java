package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

import java.net.PasswordAuthentication;

public class LoginRequest {
    @SerializedName("username")
    private String Username;
    @SerializedName("password")
    private String Password;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
