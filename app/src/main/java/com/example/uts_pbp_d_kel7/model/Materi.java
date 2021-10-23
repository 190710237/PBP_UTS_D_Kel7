package com.example.uts_pbp_d_kel7.model;

public class Materi {
    private String konten;

    public Materi(String subBab) {
        if(subBab.equals("Matriks")){
            konten=Matriks;
        }
    }

    public String getKonten() {
        return konten;
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }

    public static final String Matriks = "";
    public static final String TransformasiMatriks = "";
    public static final String EliminasiGaus = "";
    public static final String PerkalianSilang = "";

    public static final String RataRata = "";
    public static final String Median = "";
    public static final String Modus = "";
    public static final String Kuartil = "";

    public static final String Sequential = "";
    public static final String Seleksi = "";
    public static final String Perulangan = "";
    public static final String Array = "";

    public static final String Select = "";
    public static final String Insert = "";
    public static final String Update = "";
    public static final String Delete = "";

    public static final String Object = "";
    public static final String Class = "";
    public static final String Interface = "";
    public static final String Abstract = "";

    public static final String Stack = "";
    public static final String List = "";
    public static final String MultiList = "";
    public static final String BinaryTree = "";

    public static final String HTML = "";
    public static final String CSS = "";
    public static final String JavaScript = "";
    public static final String PHP = "";

}
