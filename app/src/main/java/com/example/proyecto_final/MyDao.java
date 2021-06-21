package com.example.proyecto_final;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface MyDao {

    @Insert
    public void agregar(User user);

    @Query("Select * from users where contraseña=:user")
    User editar(String user);

    @Query("select * from users where id=:id and contraseña=:contraseña")
    User ingresar(int id,String contraseña);

    @Query("select * from users where id=:id")
    User registro(int id);

    @Update
    public void actualiza(User user);

}
