package com.example.agendamovil;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Contacto.class}, version = 1, exportSchema = false)
public abstract class MiDataBase extends RoomDatabase {
    public abstract DAOContacto devolverDAO();

}
