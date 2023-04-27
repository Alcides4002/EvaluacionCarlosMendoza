package com.example.miproyectofinal

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface daoLaboratorio (
    @Query("SELECT * FROM laboratorio")
    suspend fun obtenerLaboratorio():MutableList< Laboratorio>

@Query("UPDATE laboratorio nombre =:nombre, descripcion =:descripcion WHERE id =:id ")
suspend fun actualizarLaboratorio(id: Int, nombre: String, descripcion: String )
@Insert
suspend fun agrgarLaboratorio(laboratorio: Laboratorio)

@Query("DELETE FROM laboratorio WHERE id =:id")
suspend fun  deleteLaboratorio(id: Int)

)

























