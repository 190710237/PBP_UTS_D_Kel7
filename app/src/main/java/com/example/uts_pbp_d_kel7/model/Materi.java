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

    public static final String Matriks = "     Matriks adalah sekumpulan bilangan yang disusun berdasarkan baris dan kolom, serta ditempatkan di dalam tanda kurung. Nah, tanda kurungnya ini bisa berupa kurung biasa “( )” atau kurung siku “[ ]”, ya. Suatu matriks diberi nama dengan huruf kapital, seperti A, B, C, dan seterusnya. ";
    public static final String TransformasiMatriks = "     Transformasi digunakan untuk untuk memindahkan suatu titik atau bangun padasuatu bidang. Transformasi geometri adalah bagian dari geometri yang membahastentang perubahan (letak,bentuk , penyajian) yang didasarkan dengan gambar danmatriks.";
    public static final String EliminasiGaus = "     Eliminasi gauss ditemukan oleh Carl Friedrich Gauss, metode ini dapat dimanfaatkan untuk memecahkan sistem persamaan linear dengan merepresentasikan (mengubah) menjadi bentuk matriks, matriks tersebut lalu diubah kebentuk Eselon Baris melalui Operasi Baris Elementer. Kemudian sistem diselesaikan dengan substitusi balik.";
    public static final String PerkalianSilang = "     Eliminasi gauss ditemukan oleh Carl Friedrich Gauss, metode ini dapat dimanfaatkan untuk memecahkan sistem persamaan linear dengan merepresentasikan (mengubah) menjadi bentuk matriks, matriks tersebut lalu diubah kebentuk Eselon Baris melalui Operasi Baris Elementer. Kemudian sistem diselesaikan dengan substitusi balik.";

    public static final String RataRata = "     Dipandang dari sisi matematis, rerata adalah momen pertama dari suatu peubah acak. Momen pertama mengenai rerata dari suatu peubah acak disebut simpangan (deviasi).";
    public static final String Median = "     Ukuran pemusatan data adalah metode deskriptif yang menunjukkan pusat suatu data atau perwakilan suatu data. Ukuran pemusatan data yang umum kita kenal ada tiga, yaitu mean, modus, dan median. Tulisan ini akan membahas median.";
    public static final String Modus = "     Dalam Matematika, modus adalah bagian dari statistika. Ada tiga jenis rata-rata yang paling umum dalam statistika; mean, median, dan modus. Ketiga hitungan ini paling sering muncul dalam perhitungan matematika statistika.";
    public static final String Kuartil = "     Kuartil adalah salah satu jenis kuantil yang membagi data menjadi empat bagian dengan jumlah yang kurang lebih sama. Kuartil pertama atau kuartil bawah (Q1) merupakan nilai tengah antara nilai terkecil dan median dari kelompok data. Kuartil pertama menjadi penanda bahwa data pada kuartil tersebut berada 25% dari bawah pada kelompok data. Kuartil kedua (Q2) adalah median data yang menandai 50% data (membagi data menjadi dua). Kuartil ketiga atau kuartil atas (Q3) adalah nilai tengah antara median dan nilai tertinggi dari kelompok data. Kuartil ketiga menjadi penanda bahwa data pada kuartil tersebut berada 75% dari bawah pada kelompok data.";

    public static final String Sequential = "     Algoritma Sekuensial (Sequence Algorithm) adalah algoritma yang langkah-langkahnya dikerjakan atau dieksekusi secara urut dari awal hingga akhir sesuai dengan urutannya.";
    public static final String Seleksi = "     Algoritma percabangan atau Algoritma bersyarat adalah algoritma yang menjalankan instruksi selanjutnya apabila syarat yang ditetapkan sudah terpenuhi.";
    public static final String Perulangan = "     Algoritma Perulangan atau Looping Algorithm adalah sebuah struktur dasar algoritma yang menjalankan beberapa langkah tertentu secara berulang-ulang sampai terpenuhinya suatu kondisi.";
    public static final String Array = "     Array merupakan tipe data terstruktur yang berguna untuk menyimpan sejumlah data yang bertipe sama. Bagian yang menyusun array disebut elemen array(isi), yang masing-masing elemen dapat diakses tersendiri melalui indeks array.";

    public static final String Select = "     Query select digunakan untuk menampilkan baris data yang terdapat pada sebuah tabel. Khusus query select ini saya akan membahasnya secara tersendiri pada tutorial selanjutnya, mengingat query select diperlukan filter-filter tertentu untuk menampilkan data yang dibutuhkan.";
    public static final String Insert = "     Query insert digunakan untuk menambahkan baris data baru pada sebuah tabel.";
    public static final String Update = "     Query update digunakan untuk mengubah nilai sebuah baris data. Perintah update ini harus menggunakan klausa “where” untuk mencegah terjadinya perubahan pada seluruh data, kecuali jika memang ingin mengubah seluruhnya maka tidak diperlukan klausa tersebut.";
    public static final String Delete = "     Query delete digunakan untuk menghapus baris data. Sama seperti perintah update diatas, perintah/query delete biasanya diikuti dengan klausa “where” untuk menghapus data secara spesifik. Jika query delete tanpa adanya klausa “where” maka seluruh data pada tabel tersebut akan terhapus semuanya pada satu kali query.";

    public static final String Object = "     Objek adalah hasil cetakan dari blueprint class.";
    public static final String Class = "     Class adalah cetak biru atau blueprint dari object. Class digunakan hanya untuk membuat kerangka dasar. Yang akan kita pakai nantinya adalah hasil cetakan dari class, yakni object.";
    public static final String Interface = "     Interface adalah sebuah blok signature kumpulan method tanpa tubuh (konstan). Interface memungkinkan kita mengimplementasikan method yang sama terhadap class yang tidak ada hubungan sama sekali (tidak dalam satu hirarki). Oleh karena itu interface bukanlah sebuah class, walaupun memiliki ciri yang serupa dengan abstract class.";
    public static final String Abstract = "     Abstract class adalah sebuah class setengah jadi (abstrak) yang memuat/memiliki method dan atrribut. Abstract class sebenarnya adalah sebuah class, sehingga memiliki semua sifat dari class biasa (punya konstruktor). Hanya saja sifatnya masih abstrak, karena itu biasanya method kosong/belum di implementasikan.";

    public static final String Stack = "     Stack adalah salah satu komponen yang biasanya digunakan dalam pemrograman ataupun penyimpanan komputer.";
    public static final String List = "     Array List adalah sebuah kelas  yang  dapat penyimpanan data berupa list objek berbentuk array yang ukurannya dapat berubah secara dinamis sesuai dengan jumlah data yang dimasukkan.";
    public static final String MultiList = "     MultiList adalah suatu struktur yang terdiri dari beberapa buah list berkait yang saling berkaitan (berelasi).";
    public static final String BinaryTree = "     Binary Tree adalah struktur data yang hampir mirip juga dengan Linked List untuk menyimpan koleksi dari data. Linked List dapat dianalogikan sebagai rantai linier sedangkan Binary Tree bisa digambarkan sebagai rantai tidak linier. Binary Tree dikelompokkan menjadi unordered Binary Tree (tree yang tidak berurut) dan ordered Binary Tree (tree yang terurut).";

    public static final String HTML = "     Hypertext Markup Language atau HTML adalah bahasa markup yang digunakan untuk membuat struktur halaman website.";
    public static final String CSS = "     CSS adalah kepanjangaan dari Cascading Style Sheets yang berguna untuk menyederhanakan proses pembuatan website dengan mengatur elemen yang tertulis di bahasa markup.";
    public static final String JavaScript = "     avaScript adalah bahasa pemrograman populer yang digunakan untuk membuat situs dengan konten website yang dinamis. Faktanya, ada lebih dari 67,7 persen developer yang menggunakan JavaScript.";
    public static final String PHP = "     PHP  (PHP: Hypertext Preprocessor) adalah sebuah bahasa pemrograman server side scripting yang bersifat open source.";

}
