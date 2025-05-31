package com.example.introkotlin904.diccionario

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.introkotlin904.R

class BuscarPalabras : AppCompatActivity() {

    companion object {
        const val NOMBRE_ARCHIVO = "diccionario.txt"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar_palabras)

        val btnVolver = findViewById<Button>(R.id.btnVolver)
        val btnBuscar = findViewById<Button>(R.id.BtnBuscar)
        val radioBEspanol = findViewById<RadioButton>(R.id.radioBEspanol)
        val radioBIngles = findViewById<RadioButton>(R.id.radioBIngles)
        val editTextBuscar = findViewById<EditText>(R.id.editTextBuscar)
        val textViewResultado = findViewById<TextView>(R.id.textViewResultado)

        radioBEspanol.isChecked = true

        btnBuscar.setOnClickListener {
            val palabraABuscar = editTextBuscar.text.toString().trim()

            if (palabraABuscar.isEmpty()) {
                Toast.makeText(this, "Por favor ingresa una palabra", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!radioBEspanol.isChecked && !radioBIngles.isChecked) {
                Toast.makeText(this, "Por favor selecciona un idioma", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val esIngles = radioBIngles.isChecked

            val resultado = buscarTraduccion(palabraABuscar, esIngles)
            textViewResultado.text = resultado
        }

        btnVolver.setOnClickListener {
            finish()
        }
    }

    private fun buscarTraduccion(palabra: String, esIngles: Boolean): String {
        return try {
            val contenidoArchivo = openFileInput(NOMBRE_ARCHIVO).bufferedReader().useLines { lines ->
                lines.toList()
            }

            for (linea in contenidoArchivo) {
                val partes = linea.split("\\|".toRegex())
                if (partes.size == 2) {
                    val ingles = partes[0].trim()
                    val espanol = partes[1].trim()

                    if (esIngles && ingles.equals(palabra, ignoreCase = true)) {
                        return "Traducción al español: $espanol"
                    } else if (!esIngles && espanol.equals(palabra, ignoreCase = true)) {
                        return "Traducción al inglés: $ingles"
                    }
                }
            }

            "Palabra no encontrada"

        } catch (e: Exception) {
            when (e) {
                is java.io.FileNotFoundException -> "Archivo no encontrado"
                else -> "Error al leer el archivo: ${e.message}"
            }
        }
    }
}
