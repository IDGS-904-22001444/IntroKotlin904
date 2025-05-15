package com.example.introkotlin904.tema2Calculadora

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.introkotlin904.R

class Ejemplo2Activity : AppCompatActivity() {

    private lateinit var et1: EditText
    private lateinit var et2: EditText
    private lateinit var tv1: TextView
    private lateinit var button: Button
    private lateinit var radioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejemplo4)

        // Inicializar vistas
        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        tv1 = findViewById(R.id.tv1)
        button = findViewById(R.id.button)
        radioGroup = findViewById(R.id.radioGroup)

        // Setear listener al botón
        button.setOnClickListener {
            calculate()
        }
    }

    private fun calculate() {
        val num1Text = et1.text.toString()
        val num2Text = et2.text.toString()

        // Validar inputs
        if (num1Text.isEmpty() || num2Text.isEmpty()) {
            Toast.makeText(this, "Por favor ingresa ambos números", Toast.LENGTH_SHORT).show()
            return
        }

        val num1: Double
        val num2: Double

        try {
            num1 = num1Text.toDouble()
            num2 = num2Text.toDouble()
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Formato de número no válido", Toast.LENGTH_SHORT).show()
            return
        }

        // Obtener el RadioButton seleccionado
        val selectedOptionId = radioGroup.checkedRadioButtonId

        if (selectedOptionId == -1) {
            Toast.makeText(this, "Selecciona una operación", Toast.LENGTH_SHORT).show()
            return
        }

        val result: Double = when (selectedOptionId) {
            R.id.radioButton -> num1 + num2
            R.id.radioButton2 -> num1 - num2
            R.id.radioButton3 -> num1 * num2
            R.id.radioButton4 -> {
                if (num2 == 0.0) {
                    Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_SHORT).show()
                    return
                }
                num1 / num2
            }
            else -> {
                Toast.makeText(this, "Operación no válida", Toast.LENGTH_SHORT).show()
                return
            }
        }

        tv1.text = "Resultado: $result"
    }
}
