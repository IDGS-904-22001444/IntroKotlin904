package com.example.introkotlin904

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin904.Cinepolis.Cinepolis
import com.example.introkotlin904.Tem2App.Ejemplo6Activity
import com.example.introkotlin904.diccionario.Diccionario
import com.example.introkotlin904.tema1Ejemplos.Ejemplo1Activity
import com.example.introkotlin904.tema4.Ejemplo7Activity
import com.example.introkotlin904.tema8.Ejemplo8

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        val btnEjemplo1 = findViewById<Button>(R.id.btn1)
        btnEjemplo1.setOnClickListener {
            navegateToEjemplo1()
        }

        val btnCinepolis = findViewById<Button>(R.id.btn2)
        btnCinepolis.setOnClickListener {
            navegateToCinepolis()
        }

        val btnEjemplo2 = findViewById<Button>(R.id.btn3)
        btnEjemplo2.setOnClickListener {
            navegateToEjemplo2()
        }


        val btnRandom = findViewById<Button>(R.id.btn4)
        btnRandom.setOnClickListener {
            navegateToRandomNumber()
        }

        val btnCadena = findViewById<Button>(R.id.btn5)
        btnRandom.setOnClickListener {
            navegateToCadena()
        }

        val btnDiccionario = findViewById<Button>(R.id.btn6)
        btnDiccionario.setOnClickListener {
            navegateToDiccionario()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }

    private fun navegateToEjemplo2() {
    val intent = Intent(this, Ejemplo6Activity::class.java)
        startActivity(intent)
    }

    private fun navegateToDiccionario() {
        val intent = Intent(this, Diccionario::class.java)
        startActivity(intent)
    }

    private fun navegateToCinepolis() {
    val intent = Intent(this, Cinepolis::class.java)
        startActivity(intent)
    }


    private fun navegateToEjemplo1() {
    val intent = Intent(this, Ejemplo1Activity::class.java)
    startActivity(intent)
    }

    private fun navegateToRandomNumber(){
        val intent = Intent(this, Ejemplo7Activity::class.java)
        startActivity(intent)
    }

    private fun navegateToCadena(){
        val intent = Intent(this, Ejemplo8::class.java)
        startActivity(intent)
    }

}
