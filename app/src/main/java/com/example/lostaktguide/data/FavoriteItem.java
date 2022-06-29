package com.example.lostaktguide.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(
        tableName = "favorite"

        /*
        foreignKeys= @ForeignKey(
                entity = UserItem.class ,
                parentColumns = "id_user",
                childColumns = "user_id",
                onDelete = CASCADE,

        ),
        foreignKeys = @ForeignKey(
        entity = SubClassItem.class,
        parentColumns = "id_subClass",
        childColumns = "subClass_id",
        onDelete = CASCADE)
*/
)


public class FavoriteItem {

    @ColumnInfo(name = "favorite_id")
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int id;

    @ColumnInfo(name = "user_id")
    @NonNull
    public UserItem user_id;

    @ColumnInfo(name = "subClass_id")
    @NonNull
    public SubClassItem subClass_id;




}
