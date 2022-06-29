package com.example.lostaktguide.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "User")
public class UserItem {

    @PrimaryKey
    @ColumnInfo(name = "id_user")
    public int id_user;

    @ColumnInfo(name = "user")
    public String user;

    @ColumnInfo(name = "password")
    public String password;

    @Override
    public String toString() {
        return user;
    }
}
