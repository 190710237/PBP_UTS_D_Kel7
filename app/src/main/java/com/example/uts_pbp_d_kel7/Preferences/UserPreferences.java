package com.example.uts_pbp_d_kel7.Preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.uts_pbp_d_kel7.Model.User;

public class UserPreferences {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    //Mendefinisikan key
    public static final String IS_LOGIN = "isLogin";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";

    public UserPreferences(Context context){
        this.context = context;
        //penamaan bebas nammun disini menggunakan userPreferences
        sharedPreferences = context.getSharedPreferences("userPreferences", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setLogin(String username, String password) {
        //Menyimpan data login ke sharedPreferences dengan key dan value
        editor.putBoolean(IS_LOGIN,true);
        editor.putString(KEY_USERNAME,username);
        editor.putString(KEY_PASSWORD,password);

        //jangan lupa commit
        editor.commit();
    }

    public User getUserLogin(){
        //mengembalikan objek User untuk menampilkan data user jika user sudah login
        String username,password;

        username = sharedPreferences.getString(KEY_USERNAME,null);
        password = sharedPreferences.getString(KEY_PASSWORD,null);

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
