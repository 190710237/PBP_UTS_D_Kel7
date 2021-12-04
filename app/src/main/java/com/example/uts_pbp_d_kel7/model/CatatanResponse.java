package com.example.uts_pbp_d_kel7.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CatatanResponse {

    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private List<Catatan> catatanList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Catatan> getCatatanList() {
        return catatanList;
    }

    public void setCatatanList(List<Catatan> catatanList) {
        this.catatanList = catatanList;
    }
}
