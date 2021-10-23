package com.example.uts_pbp_d_kel7.model;

public class MataPelajaran {
    private String mataPelajaran;
    private String author;
    private String tingkatan;
    private String deskripsi;
    public MataPelajaran(String mataPelajaran, String author, String tingkatan, String deskripsi) {
        this.mataPelajaran = mataPelajaran;
        this.author = author;
        this.tingkatan = tingkatan;
        this.deskripsi = deskripsi;
    }

    public String getMataPelajaran() {
        return mataPelajaran;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setMataPelajaran(String mataPelajaran) {
        this.mataPelajaran = mataPelajaran;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTingkatan() {
        return tingkatan;
    }

    public void setTingkatan(String tingkatan) {
        this.tingkatan = tingkatan;
    }
}
