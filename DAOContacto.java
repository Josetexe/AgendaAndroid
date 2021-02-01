package com.example.agendamovil;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DAOContacto {

    @Query("SELECT * FROM contacto")
    List<Contacto> devolverContactos();

    @Insert
    void grabarContacto (Contacto c);
}
