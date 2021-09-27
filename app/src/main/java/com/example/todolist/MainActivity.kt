package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    val simpsonNames = arrayListOf<String>("Task 1") // 1. crear arreglo de datos
    var adapter: ArrayAdapter<String>?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, simpsonNames) // 2. crear un adapter usando el arreglo de datos
        val TaskListView = findViewById<ListView>(R.id.taskList)
        TaskListView.adapter = adapter // 3. conectar el adapter con el listview
        TaskListView.setOnItemClickListener { listview, listitem, index, id ->
            println("item: $listitem, index: $index, id: $id")
            val textview = listitem as TextView
            Toast.makeText(this, "Seleccionaste  ${textview.text}", Toast.LENGTH_SHORT).show()
        }

        val miBoton = findViewById<Button>(R.id.btnAgregar)
        miBoton.setOnClickListener {
            agregarTask()
        }

        val miBoton2 = findViewById<Button>(R.id.deletebut)
        miBoton2.setOnClickListener {
            quitarPersonaje()
        }

    }

    fun agregarTask() {
        val edAgregar: EditText = findViewById(R.id.edAgregar)
        val myTextView: TextView = findViewById(R.id.textView2)
        val nombre = edAgregar.text.toString()

        if (edAgregar.text.toString().length == 0) {
            Toast.makeText(this, "Campo Vacio... ingrese una task!!", Toast.LENGTH_SHORT).show()
        }

        simpsonNames.add(nombre)
        adapter?.notifyDataSetChanged()

    }

    fun quitarPersonaje() {
        simpsonNames.removeAt(simpsonNames.size-1)
        adapter?.notifyDataSetChanged()
    }



}
