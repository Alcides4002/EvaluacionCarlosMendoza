package com.example.miproyectofinal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AdaptadorLaboratorio (
    val listaLaboratorio: MutableList<Laboratorio>,
    val listener: AdaptadorListener
):RecyclerView.Adapter<AdaptadorLaboratorio.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.rclaboratorio, parent, false)
        return RecyclerView.ViewHolder(vista)
    }
    override fun onBindViewHolder(holder: AdaptadorLaboratorio.ViewHolder, position: Int) {
        val laboratorio = listaLaboratorio[position]
        holder.etNombre.text = laboratorio.nombre
        holder.etDescripcion.text = laboratorio.descripcion

        holder.constrain.setOnClickListener {
            listener.onEditItemClick(laboratorio)
        }

        holder.btnEliminar.setOnClickListener {
            listener.onDeleteItemClick(laboratorio)
        }
        holder.btnActualizar.setOnClickListener {
            listener.onUpdateItem(laboratorio)
        }




    }
    override fun getItemCount(): Int {
        return listaLaboratorio.size
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var etNombre = itemView.findViewById<TextView>(R.id.etNombre)
        var etDescripcion = itemView.findViewById<TextView>(R.id.et)


    }


}