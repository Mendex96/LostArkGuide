package com.example.lostaktguide.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.lostaktguide.data.UserItem;

import java.util.List;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(UserItem user);

    @Query("SELECT * FROM user")
    List<UserItem> loadUsers();

    @Query("SELECT * FROM user WHERE user = user LIMIT 1")
    UserItem loadUser(int user);
}
