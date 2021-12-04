package com.example.uts_pbp_d_kel7.model;

import com.google.gson.annotations.SerializedName;

public class Catatan {
    @SerializedName("id")
    private Long id;
    @SerializedName("judul")
    private String judul;
    @SerializedName("isi")
    private String isi;
    @SerializedName("user_id")
    private Long user_id;

    public Catatan(String judul, String isi, Long user_id) {
        this.judul = judul;
        this.isi = isi;
        this.user_id = user_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
