package com.example.uts_pbp_d_kel7.model;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

public class DaftarMataPelajaran {
    public ArrayList<MataPelajaran> MataPelajaran;

    public DaftarMataPelajaran() {
        MataPelajaran = new ArrayList();
        MataPelajaran.add(AljabarLinear);
        MataPelajaran.add(Statistika);
        MataPelajaran.add(DasarPemrograman);
        MataPelajaran.add(BasisData);
        MataPelajaran.add(ObjectOrientedProgramming);
        MataPelajaran.add(StrukturData);
        MataPelajaran.add(PengembanganWeb);
    }

    public static final MataPelajaran AljabarLinear = new MataPelajaran("Aljabar Linear", "Prof. James", "Beginner");
    public static final MataPelajaran Statistika = new MataPelajaran("Statistika", "Dr. Eric", "Beginner");
    public static final MataPelajaran DasarPemrograman = new MataPelajaran("Dasar Pemrograman", "Sir. Vandal", "Intermediate");
    public static final MataPelajaran BasisData = new MataPelajaran("Basis Data", "Prof. Phantom", "Intermediate");
    public static final MataPelajaran ObjectOrientedProgramming = new MataPelajaran("Object Oriented Programming", "Prof. Sherif", "Expert");
    public static final MataPelajaran StrukturData = new MataPelajaran("Struktur Data", "Dr. Marshall", "Expert");
    public static final MataPelajaran PengembanganWeb = new MataPelajaran("Pengembangan Web", "Sir. Odin", "Intermediate");
}