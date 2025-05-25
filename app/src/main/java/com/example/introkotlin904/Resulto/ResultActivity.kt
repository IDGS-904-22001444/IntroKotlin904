package com.example.introkotlin904.Resulto

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.introkotlin904.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val original = intent.getStringExtra("original")
        val reversed = intent.getStringExtra("reversed")
        val vowels = intent.getStringExtra("vowels")
        val consonants = intent.getStringExtra("consonants")

        findViewById<TextView>(R.id.tvOriginal).text = "Cadena original: $original"
        findViewById<TextView>(R.id.tvReversed).text = "Cadena invertida: $reversed"
        findViewById<TextView>(R.id.tvVowels).text = "Vocales: $vowels"
        findViewById<TextView>(R.id.tvConsonants).text = "Número de consonantes: $consonants"
    }
}
