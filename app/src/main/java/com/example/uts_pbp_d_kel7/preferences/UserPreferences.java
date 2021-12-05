package com.example.uts_pbp_d_kel7.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.uts_pbp_d_kel7.model.User;

public class UserPreferences {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    //Mendefinisikan key
    public static final String IS_LOGIN = "isLogin";
    public static final String KEY_ID = "id";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_FIRSTNAME = "firstname";
    public static final String KEY_LASTNAME = "lastname";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_BIRTHDATE = "birthdate";
    public static final String KEY_SCHOOLNAME = "schoolname";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_PHOTO = "photo";

    public UserPreferences(Context context){
        this.context = context;
        //penamaan bebas nammun disini menggunakan userPreferences
        sharedPreferences = context.getSharedPreferences("userPreferences", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setLogin(int id, String username, String password, String firstname, String lastname, String email,
                         String birthdate, String schoolname, String address, String photo) {
        //Menyimpan data login ke sharedPreferences dengan key dan value
        editor.putBoolean(IS_LOGIN,true);
        editor.putInt(KEY_ID, id);
        editor.putString(KEY_USERNAME,username);
        editor.putString(KEY_PASSWORD,password);
        editor.putString(KEY_FIRSTNAME,firstname);
        editor.putString(KEY_LASTNAME,lastname);
        editor.putString(KEY_EMAIL,email);
        editor.putString(KEY_BIRTHDATE,birthdate);
        editor.putString(KEY_SCHOOLNAME,schoolname);
        editor.putString(KEY_ADDRESS,address);
        editor.putString(KEY_PHOTO,photo);

        //jangan lupa commit
        editor.commit();
    }

    public User getUserLogin(){
        //mengembalikan objek User untuk menampilkan data user jika user sudah login
        int id;
        String username,password;
        String firstname,lastname;
        String email, birthdate, schoolname, address,photo;

        id = sharedPreferences.getInt(KEY_ID, -1);
        username = sharedPreferences.getString(KEY_USERNAME,null);
        password = sharedPreferences.getString(KEY_PASSWORD,null);
        firstname = sharedPreferences.getString(KEY_FIRSTNAME, null);
        lastname = sharedPreferences.getString(KEY_LASTNAME, null);
        email = sharedPreferences.getString(KEY_EMAIL, null);
        birthdate =  sharedPreferences.getString(KEY_BIRTHDATE, null);
        schoolname = sharedPreferences.getString(KEY_SCHOOLNAME, null);
        address = sharedPreferences.getString(KEY_ADDRESS, null);
        photo = sharedPreferences.getString(KEY_PHOTO, null);

        return new User(username,password);
    }

    public boolean checkLogin(){
        //mengembalikan nilai isLogin, jika sudah login nilai true jika tidak nilai false
        return sharedPreferences.getBoolean(IS_LOGIN,false);
    }

    public void logout(){
        //clear data pada sharedPreferences, jangan lupa commit
        editor.clear();
        editor.commit();
    }
}
