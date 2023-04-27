package com.example.miproyectofinal

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Laboratorio::class],
    version = 1
)
abstract class  dbLaboratorio RoomDataBase() {
abstract fun daoLaboratorio():DaoLaboratorio

}

