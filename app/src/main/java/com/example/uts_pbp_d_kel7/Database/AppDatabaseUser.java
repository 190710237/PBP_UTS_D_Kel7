package com.example.uts_pbp_d_kel7.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.uts_pbp_d_kel7.Dao.UserDao;
import com.example.uts_pbp_d_kel7.Model.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabaseUser extends RoomDatabase {
    public abstract UserDao userDao();
}
