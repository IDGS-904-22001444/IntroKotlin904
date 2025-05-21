package com.example.introkotlin904.Cinepolis

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin904.R
import java.text.NumberFormat
import java.util.Locale

class Cinepolis : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cinepolis)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editTextNombre = findViewById<EditText>(R.id.editTextText)
        val editTextBoletos = findViewById<EditText>(R.id.editTextNumber2)
        val editTextCompradores = findViewById<EditText>(R.id.editTextNumber)
        val checkBoxSi = findViewById<CheckBox>(R.id.checkBox)
        val checkBoxNo = findViewById<CheckBox>(R.id.checkBox2)
        val textViewResultado = findViewById<TextView>(R.id.textView7)
        val botonCalcular = findViewById<Button>(R.id.button2)

        editTextNombre.hint = "Ingrese su nombre"
        editTextBoletos.hint = "Cantidad de boletos"

        botonCalcular.setOnClickListener {
            try {
                val nombre = editTextNombre.text.toString().trim()
                if (nombre.isEmpty()) {
                    Toast.makeText(this, "Por favor ingrese su nombre", Toast.LENGTH_SHORT).show()
                    editTextNombre.requestFocus()
                    return@setOnClickListener
                }

                val compradoresTexto = editTextCompradores.text.toString()
                if (compradoresTexto.isEmpty()) {
                    Toast.makeText(this, "Ingrese la cantidad de compradores", Toast.LENGTH_SHORT).show()
                    editTextCompradores.requestFocus()
                    return@setOnClickListener
                }
                val compradores = compradoresTexto.toInt()
                if (compradores <= 0) {
                    Toast.makeText(this, "Debe haber al menos 1 comprador", Toast.LENGTH_SHORT).show()
                    editTextCompradores.requestFocus()
                    return@setOnClickListener
                }

                val boletosTexto = editTextBoletos.text.toString()
                if (boletosTexto.isEmpty()) {
                    Toast.makeText(this, "Ingrese la cantidad de boletos", Toast.LENGTH_SHORT).show()
                    editTextBoletos.requestFocus()
                    return@setOnClickListener
                }
                val boletos = boletosTexto.toInt()
                if (boletos <= 0) {
                    Toast.makeText(this, "Debe comprar al menos 1 boleto", Toast.LENGTH_SHORT).show()
                    editTextBoletos.requestFocus()
                    return@setOnClickListener
                }

                val maxBoletos = compradores * 7
                if (boletos > maxBoletos) {
                    Toast.makeText(this, "Máximo $maxBoletos boletos para $compradores compradores", Toast.LENGTH_SHORT).show()
                    editTextBoletos.requestFocus()
                    return@setOnClickListener
                }

                if (!checkBoxSi.isChecked && !checkBoxNo.isChecked) {
                    Toast.makeText(this, "Seleccione si tiene tarjeta Cineco", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val precioBase = 12.00
                var total = boletos * precioBase

                when {
                    boletos > 5 -> {
                        total *= 0.85
                        Toast.makeText(this, "Se aplicó un 15% de descuento por comprar más de 5 boletos", Toast.LENGTH_SHORT).show()
                    }
                    boletos in 3..5 -> {
                        total *= 0.90
                        Toast.makeText(this, "Se aplicó un 10% de descuento por comprar entre 3 y 5 boletos", Toast.LENGTH_SHORT).show()
                    }
                    boletos == 2 -> {
                        total = total
                        Toast.makeText(this, "No se aplica descuento por comprar 2 boletos", Toast.LENGTH_SHORT).show()
                    }
                }

                if (checkBoxSi.isChecked) {
                    total *= 0.90
                }

                val formatter = NumberFormat.getCurrencyInstance(Locale("es", "MX"))
                formatter.maximumFractionDigits = 2
                textViewResultado.text = formatter.format(total)

            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Error en los valores numéricos ingresados", Toast.LENGTH_SHORT).show()
            }
        }

        checkBoxSi.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                checkBoxNo.isChecked = false
            } else if (!checkBoxNo.isChecked) {
                checkBoxNo.isChecked = true
            }
        }

        checkBoxNo.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                checkBoxSi.isChecked = false
            } else if (!checkBoxSi.isChecked) {
                checkBoxSi.isChecked = true
            }
        }
    }
}
