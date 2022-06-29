package com.example.lostaktguide.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.lostaktguide.data.ClassItem;

import java.util.List;

@Dao
public interface ClassDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCategory(ClassItem category);

    @Update
    void updateClass(ClassItem category);

    @Query("SELECT * FROM class")
    List<ClassItem>  loadClasses();

    @Query("SELECT * FROM class WHERE id_class = :id_class LIMIT 1")
    ClassItem loadClass(int id_class);
}
