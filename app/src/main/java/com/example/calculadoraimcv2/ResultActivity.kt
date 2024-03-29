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
        val rClassfield = findViewById<TextView>(R.id.txtClassf)

        val getPeso = intent.getFloatExtra("dateIMCp", 0f)
        val getAltura = intent.getFloatExtra("dateIMCa", 0f)
        val getRespIMC = intent.getFloatExtra("dateIMC", 0f)

        var respClassified: String

        if (getRespIMC <= 16.9){
            respClassified = "Muito Abaixo do Peso"
        }else if (getRespIMC >= 17 && getRespIMC <= 18.4) {
            respClassified = "Abaixo do Peso"
        } else if (getRespIMC >= 18.5 && getRespIMC <= 24.9){
            respClassified = "Peso Normal"
        } else if (getRespIMC >= 25.0 && getRespIMC <= 29.9) {
            respClassified = "Acima do Peso"
        } else if (getRespIMC >= 30.0 && getRespIMC <= 34.9) {
            respClassified = "Obesidade Grau I"
        }else if (getRespIMC >= 35.0 && getRespIMC <= 40.0) {
            respClassified = "Obesidade Grau II"
        } else if (getRespIMC > 40.0) {
            respClassified = "Obesidade Grau III"
        }

        rIMC.text = getRespIMC.toString()
        rClassfield.text = respClassified

    }
}