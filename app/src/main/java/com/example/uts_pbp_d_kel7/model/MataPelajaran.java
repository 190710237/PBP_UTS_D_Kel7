package com.example.uts_pbp_d_kel7.model;

public class MataPelajaran {
    private String mataPelajaran;
    private String author;
    private String tingkatan;

    public MataPelajaran(String mataPelajaran, String author, String tingkatan) {
        this.mataPelajaran = mataPelajaran;
        this.author = author;
        this.tingkatan = tingkatan;
    }

    public String getMataPelajaran() {
        return mataPelajaran;
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
