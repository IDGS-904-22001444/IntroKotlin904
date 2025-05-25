package com.example.introkotlin904.palindromo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.introkotlin904.R
import com.example.introkotlin904.Resulto.ResultActivity

class Palindromo : AppCompatActivity() {
    private lateinit var etInput: EditText
    private lateinit var tvResult: TextView
    private lateinit var btnCheck: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_palindromo)

        etInput = findViewById(R.id.etInput)
        tvResult = findViewById(R.id.tvResult)
        btnCheck = findViewById(R.id.btnCheck)

        btnCheck.setOnClickListener {
            val input = etInput.text.toString().trim()
            if (input.isEmpty()) {
                tvResult.text = "Por favor, ingresa una cadena."
            return@setOnClickListener
        }
            if (isPalindrome(input)) {
                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("original", input)
                    putExtra("reversed", input.reversed())
                    putExtra("vowels", extractVowels(input))
                    putExtra("consonants", countConsonants(input). toString())
                }
                startActivity(intent)
            } else {
                tvResult.text = "La cadena no es un palíndromo."
                }
            }

        }
    private fun isPalindrome(s: String): Boolean {
        val normalized = s.filter { it.isLetterOrDigit() }.lowercase()
        return normalized == normalized.reversed()
    }

    private fun extractVowels(s: String): String {
        return s.filter { it.lowercaseChar() in "aeiou" }
    }

    private fun countConsonants(s: String): Int {
        return s.count { it.isLetter() && it.lowercaseChar() !in "aeiou" }
    }
}