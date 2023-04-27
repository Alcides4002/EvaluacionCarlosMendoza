package com.example.miproyectofinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.miproyectofinal.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), AdaptadorListener {
    lateinit var binding: ActivityMainBinding
    lateinit var adatador: AdaptadorLaboratorio
    lateinit var laboratorio: Laboratorio
    lateinit var room: dbLaboratorio
    var listaEstudiante: MutableList<Laboratorio> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvLab.layoutManager = LinearLayoutManager(this)
        room = Room.databaseBuilder(this, dbLaboratorio::class.java, "dbLaboratorio").build()
        obtenerLaboratorio(room)

        with(binding){
            binding.floatingActionButton.setOnClickListener {
                if (etNombre.text.toString() == "" || etDescripcion.text.toString() == "" ){
                    Toast.makeText(this@MainActivity, "Llenar los campos", Toast.LENGTH_LONG).show()
                }else{

                   laboratorio = Laboratorio(
                        etNombre.text.toString().trim(),
                        etDescripcion.text.toString().trim(),

                    )

                    agregarlaboratorio(room, laboratorio)

                }
            }

        }


    }
    fun obtenerLaboratorio(room:dbLaboratorio){


        lifecycleScope.launch{
            listaEstudiante = room.daoLaboratorio().obtenerLaboratorio()
            adatador = AdaptadorLaboratorio(listaLaboratorio,this@MainActivity)
            binding.rvlab.adapter = adatador


        }
    }
    fun agregarLaboratorio(room: dbLaboratorio,laboratorio: Laboratorio){
        lifecycleScope.launch{
            room.daoLaboratorio().agregarlaboratorio(laboratorio)
            obtenerLaboratorio(room)


        }
    }



    }
    fun actualizarLaboratorio(room: dbLaboratorio, laboratorio: Laboratorio) {
        lifecycleScope.launch {
            room.daoLaboratorio().actualizarLaboratorio(laboratorio.id, laboratorio.nombre, laboratorio.Descripcion)
            obtenerLaboratorio(room)

        }
    }
    override fun onUpdateItem(laboratorio: Laboratorio) {

        with(binding) {
            if (etNombre.text.toString() == "" || etDescripcion.text.toString() == "" ){
                Toast.makeText(this@MainActivity, "Todos los campos son requeridos", Toast.LENGTH_LONG).show()
            }else{

           laboratorio.nombre = etNombre.text.toString().trim()
                laboratorio.Descripcion = etDescripcion.text.toString().trim()




                actualizarLaboratorio(room, laboratorio)


            }
        }

    }

    override fun onEditItemClick(laboratorio: Laboratorio) {
        this.listaLaboratorio = estudiante
        var id = this.laboratorio.id
        binding.etNombre.setText(this.laboratorio.nombre)
        binding.etDescripcion.setText(this.laboratorio.descripcion)

    }

    override fun onDeleteItemClick(laboratorio: Laboratorio) {
        with(binding){
            lifecycleScope.launch{
                room.daoLaboratorio().deleteLaboratorio(laboratorio.id)
                adatador.notifyDataSetChanged()
                obtenerLaboratorio(room)

            }
        }
    }


}