package com.example.introkotlin904.diccionario

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin904.R

class AgregarPalabras : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_agregar_palabras)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val btnVolver = findViewById<Button>(R.id.btnVolver)
        val editTextEspañol = findViewById<EditText>(R.id.editTextTextEspañol)
        val editTextIngles = findViewById<EditText>(R.id.editTextTextIngles)

        val archivo = "diccionario.txt"


        btnGuardar.setOnClickListener {
            val palabraIngles = editTextIngles.text.toString().trim()
            val palabraEspanol = editTextEspañol.text.toString().trim()

            if (palabraIngles.isNotEmpty() && palabraEspanol.isNotEmpty()) {
                guardarPalabras(palabraIngles, palabraEspanol)
                editTextIngles.text.clear()
                editTextEspañol.text.clear()

                AlertDialog.Builder(this)
                    .setTitle("Éxito")
                    .setMessage("Las palabras se han almacenado correctamente")
                    .setPositiveButton("OK", null)
                    .show()
            } else {
                Toast.makeText(this, "Por favor completa ambos campos", Toast.LENGTH_SHORT).show()
            }
        }

        btnVolver.setOnClickListener {
            finish()
        }
    }

    private fun guardarPalabras(ingles: String, espanol: String) {
        try {
            val archivo = "diccionario.txt"
            val contenidoArchivo = "$ingles|$espanol\n"

            openFileOutput(archivo, Context.MODE_APPEND).use {
                it.write(contenidoArchivo.toByteArray())
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Error al guardar: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
}