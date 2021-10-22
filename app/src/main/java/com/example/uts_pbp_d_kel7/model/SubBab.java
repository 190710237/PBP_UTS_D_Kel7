package com.example.uts_pbp_d_kel7.model;

public class SubBab {
    private String bab;
    private String namaBab;
    private String deskripsi;

    public SubBab(String bab, String namaBab, String deskripsi) {

        this.bab = bab;
        this.namaBab = namaBab;
        this.deskripsi = deskripsi;
    }

    public String getBab() {
        return bab;
    }

    public void setBab(String bab) {
        this.bab = bab;
    }

    public String getNamaBab() {
        return namaBab;
    }

    public void setNamaBab(String namaBab) {
        this.namaBab = namaBab;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
