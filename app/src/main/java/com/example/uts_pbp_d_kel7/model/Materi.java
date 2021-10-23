package com.example.uts_pbp_d_kel7.model;

public class Materi {
    private String konten;

    public Materi(String subBab) {
        if(subBab.equals("Matriks")){
            konten=Matriks;
        }else if(subBab.equals("Transformasi Matriks")){
            konten=TransformasiMatriks;
        }else if(subBab.equals("Eliminasi Gaus")){
            konten=EliminasiGaus;
        }else if(subBab.equals("Perkalian Silang")){
            konten=PerkalianSilang;
        }else if(subBab.equals("Rata Rata")){
            konten=RataRata;
        }else if(subBab.equals("Median")){
            konten=Median;
        }else if(subBab.equals("Modus")){
            konten=Modus;
        }else if(subBab.equals("Kuartil")){
            konten=Kuartil;
        }else if(subBab.equals("Sequential")){
            konten=Sequential;
        }else if(subBab.equals("Seleksi")){
            konten=Seleksi;
        }else if(subBab.equals("Perulangan")){
            konten=Perulangan;
        }else if(subBab.equals("Array")){
            konten=Array;
        }else if(subBab.equals("Select")){
            konten=Select;
        }else if(subBab.equals("Insert")){
            konten=Insert;
        }else if(subBab.equals("Update")){
            konten=Update;
        }else if(subBab.equals("Delete")){
            konten=Delete;
        }else if(subBab.equals("Object")){
            konten=Object;
        }else if(subBab.equals("Class")){
            konten=Class;
        }else if(subBab.equals("Interface")){
            konten=Interface;
        }else if(subBab.equals("Abstract")){
            konten=Abstract;
        }else if(subBab.equals("Stack")){
            konten=Stack;
        }else if(subBab.equals("List")){
            konten=List;
        }else if(subBab.equals("Multi List")){
            konten=MultiList;
        }else if(subBab.equals("Binary Tree")){
            konten=BinaryTree;
        }else if(subBab.equals("HTML")){
            konten=HTML;
        }else if(subBab.equals("CSS")){
            konten=CSS;
        }else if(subBab.equals("Java Script")){
            konten=JavaScript;
        }else if(subBab.equals("PHP")){
            konten=PHP;
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
