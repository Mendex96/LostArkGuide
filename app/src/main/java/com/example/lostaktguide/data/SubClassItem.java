package com.example.lostaktguide.data;

import static androidx.room.ForeignKey.CASCADE;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "subclass",
        foreignKeys = @ForeignKey(
                entity = ClassItem.class,
                parentColumns = "id_class",
                childColumns = "class_id",
                onDelete = CASCADE
        )
)
public class SubClassItem {

        @ColumnInfo(name = "id_subClass")
        @PrimaryKey(autoGenerate = true)
        @NonNull
        public int id_subClass;

        @ColumnInfo(name = "nombre_subClass")
        public String nombre;

        @ColumnInfo(name = "imagen_subClass")
        public String subClassI;

        @ColumnInfo(name = "imagen_habilidad")
        public String habilidad;

        @ColumnInfo(name = "info")
        public String info;

        @ColumnInfo(name = "url_video")
        public String video;

        @ColumnInfo(name = "class_id")
        public String class_id;
}
