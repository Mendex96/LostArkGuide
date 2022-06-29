package com.example.lostaktguide.database;
import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.lostaktguide.data.ClassItem;
import com.example.lostaktguide.data.FavoriteItem;
import com.example.lostaktguide.data.SubClassItem;
import com.example.lostaktguide.data.UserItem;

@Database(entities = {ClassItem.class, FavoriteItem.class, UserItem.class, SubClassItem.class}, version = 1)
public abstract class GuideDatabase extends RoomDatabase{

    public abstract UserDao UserDao();
    public abstract FavoriteDao FavoriteDao();
    public abstract ClassDao ClassDao();
    public abstract Sub_ClassDao Sub_ClassDao();
}
