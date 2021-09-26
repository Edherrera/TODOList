package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    val simpsonNames = arrayListOf<String>("") // 1. crear arreglo de datos
    var adapter: ArrayAdapter<String>?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, simpsonNames) // 2. crear un adapter usando el arreglo de datos
        val simpsonsListView = findViewById<ListView>(R.id.simpsonsList)
        simpsonsListView.adapter = adapter // 3. conectar el adapter con el listview
        simpsonsListView.setOnItemClickListener { listview, listitem, index, id ->
            println("item: $listitem, index: $index, id: $id")
            val textview = listitem as TextView
            Toast.makeText(this, "Seleccionaste  ${textview.text}", Toast.LENGTH_SHORT).show()
        }

        val miBoton = findViewById<Button>(R.id.btnAgregar)
        miBoton.setOnClickListener {
            agregarPersonaje()
        }



    }

    fun agregarPersonaje() {
        val edAgregar: EditText = findViewById(R.id.edAgregar)
        val myTextView: TextView = findViewById(R.id.textView2)
        val nombre = edAgregar.text.toString()

        if (edAgregar.text.toString().length == 0) {
            myTextView.text = "Campo vacio... ingrese un nuevo items"
        }


        simpsonNames.add(nombre)
        adapter?.notifyDataSetChanged()
    }





}
