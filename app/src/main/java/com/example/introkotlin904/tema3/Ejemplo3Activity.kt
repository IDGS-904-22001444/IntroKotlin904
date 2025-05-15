package com.example.introkotlin904.tema3

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin904.R

class Ejemplo3Activity : AppCompatActivity() {

    private lateinit var et1: EditText
    private lateinit var et2: EditText
    private lateinit var tv1: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejemplo5)

        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        tv1 = findViewById(R.id.tv1)
        button = findViewById(R.id.button)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        button.setOnClickListener {
            calculate()
        }
    }

    private fun calculate() {
        val num1Str = et1.text.toString()
        val num2Str = et2.text.toString()

        if (num1Str.isNotEmpty() && num2Str.isNotEmpty()) {
            val num1 = num1Str.toInt()
            val repetitions = num2Str.toInt()

            val resultStringBuilder = StringBuilder()
            var resultSum = 0

            for (i in 1..repetitions) {
                resultSum += num1
                resultStringBuilder.append(num1)
                if (i != repetitions) {
                    resultStringBuilder.append("+")
                }
            }

            val resultString = "$resultStringBuilder=$resultSum"
            tv1.text = "Resultado: $resultString"

        } else {
            tv1.text = "Por favor, ingrese ambos valores."
        }
    }
}
