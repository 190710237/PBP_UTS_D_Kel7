package com.example.uts_pbp_d_kel7.database;

import android.content.Context;

import androidx.room.Room;

public class DatabaseMateri {
    private Context context;
    private static DatabaseMateri databaseMateri;

    private AppDatabaseMateri database;

    public DatabaseMateri(Context context){
        this.context = context;
        database = Room.databaseBuilder(context,AppDatabaseMateri.class,"materi").allowMainThreadQueries().build();
    }
    public static synchronized  DatabaseMateri getInstance(Context context){
        if(databaseMateri == null){
            databaseMateri = new DatabaseMateri(context);
        }
        return databaseMateri;
    }

    public AppDatabaseMateri getDatabase(){
        return database;
    }
}
