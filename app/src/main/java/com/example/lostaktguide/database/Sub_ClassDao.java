package com.example.lostaktguide.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import com.example.lostaktguide.data.ClassItem;
import com.example.lostaktguide.data.SubClassItem;

@Dao
public interface Sub_ClassDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProduct(SubClassItem subClass);

    @Query("SELECT * FROM subclass WHERE id_subClass = :id_subClass LIMIT 1")
    SubClassItem loadClass(int id_subClass);

    @Query("SELECT * FROM subclass WHERE class_id=:class_id")
    List<ClassItem> loadClasses(final int class_id);

}
