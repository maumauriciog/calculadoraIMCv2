package com.example.calculadoraimcv2

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ResultMain)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val rIMC = findViewById<TextView>(R.id.txtRespIMC)

        val getPeso = intent.getFloatExtra("dateIMCp", 0f)
        val getAltura = intent.getFloatExtra("dateIMCa", 0f)
        val getRespIMC = intent.getFloatExtra("dateIMC", 0f)

        rIMC.text = getRespIMC.toString()
    }
}