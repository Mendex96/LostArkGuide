package com.example.lostaktguide.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "class")
public class ClassItem {

    @ColumnInfo(name = "id_class")
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int id_class;

    public String nombre;
    public int url_imagen;

    @Ignore
    @SerializedName("subClass")
    public List<SubClassItem> subClass;

}
