package com.example.uts_pbp_d_kel7.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.uts_pbp_d_kel7.model.Materi;

import java.util.List;

@Dao
public interface MateriDao {
    @Query("SELECT * FROM materi")
    List<Materi> getAll();

    @Insert
    void registerMateri(Materi materi);

    @Update
    void updateMateri(Materi materi);

    @Delete
    void deleteMateri(Materi materi);

    @Query("SELECT * FROM materi WHERE mataPelajaran=(:mataPelajaran)")
    List<Materi> getMateriMataPelajaran(String mataPelajaran);
}
