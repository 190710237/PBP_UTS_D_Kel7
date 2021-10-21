package com.example.uts_pbp_d_kel7.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.uts_pbp_d_kel7.dao.MateriDao;
import com.example.uts_pbp_d_kel7.model.Materi;

@Database(entities = {Materi.class},version = 1)
public abstract class AppDatabaseMateri extends RoomDatabase {
    public abstract MateriDao materiDao();
}
