package com.example.uts_pbp_d_kel7.model;

import java.util.ArrayList;

public class DaftarSubBab {
    public ArrayList<SubBab> SubBab;
    private int x;
    public DaftarSubBab(String mataPelajaran) {
        if(mataPelajaran.equals("Aljabar Linear")){
            x = 1;
        }else if(mataPelajaran.equals("Statistika")){
            x = 2;
        }else if(mataPelajaran.equals("Dasar Pemrograman")){
            x = 3;
        }else if(mataPelajaran.equals("Basis Data")){
            x = 4;
        }else if(mataPelajaran.equals("Object Oriented Programming")){
            x = 5;
        }else if(mataPelajaran.equals("Struktur Data")){
            x = 6;
        }else if(mataPelajaran.equals("Pengembangan Web")){
            x = 7;
        }
        switch(x){
            case 1:
                SubBab.add(Alin1);
                SubBab.add(Alin2);
                SubBab.add(Alin3);
                SubBab.add(Alin4);
                break;
            case 2:
                SubBab.add(Statis1);
                SubBab.add(Statis2);
                SubBab.add(Statis3);
                SubBab.add(Statis4);
                break;
            case 3:
                SubBab.add(Daspro1);
                SubBab.add(Daspro2);
                SubBab.add(Daspro3);
                SubBab.add(Daspro4);
                break;
            case 4:
                SubBab.add(Bd1);
                SubBab.add(Bd2);
                SubBab.add(Bd3);
                SubBab.add(Bd4);
                break;
            case 5:
                SubBab.add(Oop1);
                SubBab.add(Oop2);
                SubBab.add(Oop3);
                SubBab.add(Oop4);
                break;
            case 6:
                SubBab.add(Strukdat1);
                SubBab.add(Strukdat2);
                SubBab.add(Strukdat3);
                SubBab.add(Strukdat4);
                break;
            case 7:
                SubBab.add(Pweb1);
                SubBab.add(Pweb2);
                SubBab.add(Pweb3);
                SubBab.add(Pweb4);
                break;
        }
    }
    public static final SubBab Alin1 = new SubBab("1","Matiks","");
    public static final SubBab Alin2 = new SubBab("2","Transformasi Matriks","");
    public static final SubBab Alin3 = new SubBab("3","Eliminasi Gaus","");
    public static final SubBab Alin4 = new SubBab("4","Perkalian silang","");

    public static final SubBab Statis1 = new SubBab("1","Rata Rata","");
    public static final SubBab Statis2 = new SubBab("2","Median","");
    public static final SubBab Statis3 = new SubBab("3","Mode","");
    public static final SubBab Statis4 = new SubBab("4","Kuartil","");

    public static final SubBab Daspro1 = new SubBab("1","Sequential","");
    public static final SubBab Daspro2 = new SubBab("2","Seleksi","");
    public static final SubBab Daspro3 = new SubBab("3","Perulangan","");
    public static final SubBab Daspro4 = new SubBab("4","Array","");

    public static final SubBab Bd1 = new SubBab("1","Select","");
    public static final SubBab Bd2 = new SubBab("2","Insert","");
    public static final SubBab Bd3 = new SubBab("3","Update","");
    public static final SubBab Bd4 = new SubBab("4","Delete","");

    public static final SubBab Oop1 = new SubBab("1","Object","");
    public static final SubBab Oop2 = new SubBab("2","Class","");
    public static final SubBab Oop3 = new SubBab("3","Inteface","");
    public static final SubBab Oop4 = new SubBab("4","Abstract","");

    public static final SubBab Strukdat1 = new SubBab("1","Stack","");
    public static final SubBab Strukdat2 = new SubBab("2","List","");
    public static final SubBab Strukdat3 = new SubBab("3","Multi List","");
    public static final SubBab Strukdat4 = new SubBab("4","Binary Tree","");

    public static final SubBab Pweb1 = new SubBab("1","HTML","");
    public static final SubBab Pweb2 = new SubBab("2","CSS","");
    public static final SubBab Pweb3 = new SubBab("3","Java Script","");
    public static final SubBab Pweb4 = new SubBab("4","PHP","");

}
