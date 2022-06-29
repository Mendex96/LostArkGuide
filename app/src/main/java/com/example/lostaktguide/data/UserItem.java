package com.example.lostaktguide.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "User")
public class UserItem {

    @PrimaryKey
    public int id_user;


    public String user;
    public String password;

    @Override
    public String toString() {
        return user;
    }
}
