package com.example.lostaktguide.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.lostaktguide.data.FavoriteItem;
import com.example.lostaktguide.data.SubClassItem;

import java.util.List;

@Dao
public interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProduct(FavoriteItem favorite);

    @Query("SELECT * FROM favorite")
    List<FavoriteItem> loadFavorites();

    @Delete
    void deleteProduct(FavoriteItem product);

    @Query("SELECT subClass_id FROM favorite WHERE user_id = user_id")
    List<SubClassItem> loadSubClass();


}
