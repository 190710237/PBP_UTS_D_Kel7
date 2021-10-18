package com.example.uts_pbp_d_kel7.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.uts_pbp_d_kel7.Dao.MateriDao;
import com.example.uts_pbp_d_kel7.Model.Materi;

@Database(entities = {Materi.class},version = 1)
public abstract class AppDatabaseMateri extends RoomDatabase {
    public abstract MateriDao materiDao();
}
