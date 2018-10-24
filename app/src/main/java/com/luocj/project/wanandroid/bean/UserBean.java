package com.luocj.project.wanandroid.bean;

import java.io.Serializable;

public class UserBean implements Serializable {
    //    "chapterTops": [],
//            "collectIds": [],
//            "email": "",
//            "icon": "",
//            "id": 12001,
//            "password": "123123",
//            "token": "",
//            "type": 0,
//            "username": "username111"
    private String username;
    private String password;
    private int id;
    private String email;
    private String token;
    private String type;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", token='" + token + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
