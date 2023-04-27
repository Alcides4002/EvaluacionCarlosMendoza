package com.example.miproyectofinal

interface AdaptadorListener{
    fun  onEditItemClick(laboratorio: Laboratorio)
    fun onDeleteItemClick(laboratorio: Laboratorio)
    fun onUpdateItem(laboratorio: Laboratorio)
}