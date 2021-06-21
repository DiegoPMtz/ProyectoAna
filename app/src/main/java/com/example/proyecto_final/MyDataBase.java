package com.example.proyecto_final;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class},version = 1)
public abstract class MyDataBase extends RoomDatabase {

    public abstract MyDao myDao();

}
