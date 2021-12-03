package com.example.uts_pbp_d_kel7.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserResponse {
    private String message;

    //TODO : recheck serialized name with db

    @SerializedName("user")
    private List<User> userList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setMahasiswaList(List<User> userList) {
        this.userList = userList;
    }
}
