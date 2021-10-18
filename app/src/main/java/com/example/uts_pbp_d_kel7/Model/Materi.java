package com.example.uts_pbp_d_kel7.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "materi")
public class Materi {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name="mataPelajaran")
    private String mataPelajaran;

    @ColumnInfo(name="bab")
    private int bab;

    @ColumnInfo(name="namabab")
    private String namaBab;

    @ColumnInfo(name="isiMateri")
    private String isiMateri;

    public Materi(String mataPelajaran, int bab, String namaBab, String isiMateri) {
        this.mataPelajaran = mataPelajaran;
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
}
