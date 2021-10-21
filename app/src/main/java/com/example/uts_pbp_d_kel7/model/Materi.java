package com.example.uts_pbp_d_kel7.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "materi")
public class Materi {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name="mataPelajaran")
    private String mataPelajaran;

    @ColumnInfo(name="author")
    private String author;

    @ColumnInfo(name="tingkatan")
    private String tingkatan;

    @ColumnInfo(name="bab")
    private int bab;

    @ColumnInfo(name="namabab")
    private String namaBab;

    @ColumnInfo(name="isiMateri")
    private String isiMateri;

    public Materi(String mataPelajaran, String author, String tingkatan, int bab, String namaBab, String isiMateri) {
        this.mataPelajaran = mataPelajaran;
        this.author = author;
        this.tingkatan = tingkatan;
        this.bab = bab;
        this.namaBab = namaBab;
        this.isiMateri = isiMateri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMataPelajaran() {
        return mataPelajaran;
    }

    public void setMataPelajaran(String mataPelajaran) {
        this.mataPelajaran = mataPelajaran;
    }

    public int getBab() {
        return bab;
    }

    public void setBab(int bab) {
        this.bab = bab;
    }

    public String getIsiMateri() {
        return isiMateri;
    }

    public void setIsiMateri(String isiMateri) {
        this.isiMateri = isiMateri;
    }

    public String getNamaBab() {
        return namaBab;
    }

    public void setNamaBab(String namaBab) {
        this.namaBab = namaBab;
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
