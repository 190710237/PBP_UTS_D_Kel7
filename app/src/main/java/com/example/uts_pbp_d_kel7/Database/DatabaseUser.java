package com.example.uts_pbp_d_kel7.Database;

import android.content.Context;

import androidx.room.Room;

public class DatabaseUser {
    private Context context;
    private static DatabaseUser databaseUser;

    private AppDatabaseUser database;

    public DatabaseUser(Context context) {
        this.context = context;
        database = Room.databaseBuilder(context, AppDatabaseUser.class, "user").allowMainThreadQueries().build();
    }

    public static synchronized DatabaseUser getInstance(Context context){
        if(databaseUser == null){
            databaseUser = new DatabaseUser(context);
        }
        return databaseUser;
    }

    public AppDatabaseUser getDatabase() { return database; }
}
