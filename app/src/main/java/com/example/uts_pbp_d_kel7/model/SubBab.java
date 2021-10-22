package com.example.uts_pbp_d_kel7.model;

public class SubBab {
    private String bab;
    private String namaBab;
    private String isiMateri;

    public SubBab(String bab, String namaBab, String isiMateri) {

        this.bab = bab;
        this.namaBab = namaBab;
        this.isiMateri = isiMateri;
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

    public String getIsiMateri() {
        return isiMateri;
    }

    public void setIsiMateri(String isiMateri) {
        this.isiMateri = isiMateri;
    }
}
