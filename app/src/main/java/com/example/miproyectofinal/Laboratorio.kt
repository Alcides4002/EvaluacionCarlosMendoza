package com.example.miproyectofinal

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "laboratorio")
 data class Laboratorio (

        @ColumnInfo(name = "nombre") var nombre:String,
        @ColumnInfo(name = "Descripcion") var  descripcion:String,
        @PrimaryKey(autoGenerate = true)
        val id:Int = 0



    )

