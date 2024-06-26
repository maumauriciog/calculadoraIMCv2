package com.example.calculadoraimcv2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
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
        val rClassf = findViewById<TextView>(R.id.txtClassf)
        val vlrPeso = findViewById<TextView>(R.id.vlrPeso)
        val vlrAltura = findViewById<TextView>(R.id.vlrAltura)

        val getPeso = intent.getFloatExtra("dateIMCp", 0f)
        val getAltura = intent.getFloatExtra("dateIMCa", 0f)
        val getRespIMC = intent.getFloatExtra("dateIMC", 0f)

        var respClassified = ""

        if (getRespIMC <= 16.9) {
            respClassified = "Muito Abaixo do Peso"
            rClassf.setTextColor(getColor(R.color.magreza))
        } else if (getRespIMC in 17.0..18.4) {
            respClassified = "Abaixo do Peso"
            rClassf.setTextColor(getColor(R.color.magreza))
        } else if (getRespIMC in 18.5..24.9) {
            respClassified = "Peso Normal"
            rClassf.setTextColor(getColor(R.color.normal))
        } else if (getRespIMC in 25.0..29.9) {
            respClassified = "Acima do Peso"
            rClassf.setTextColor(getColor(R.color.sobrepeso))
        } else if (getRespIMC in 30.0..34.9) {
            respClassified = "Obesidade Grau I"
            rClassf.setTextColor(getColor(R.color.obesidade))
        } else if (getRespIMC in 35.0..40.0) {
            respClassified = "Obesidade Grau II"
            rClassf.setTextColor(getColor(R.color.obesidadeg))
        } else if (getRespIMC > 40.0) {
            respClassified = "Obesidade Grau III"
            rClassf.setTextColor(getColor(R.color.obesidadeg))
        }

        vlrPeso.text = "Peso:  " + getPeso + "Kg"
        vlrAltura.text = "Altura: $getAltura"

        rIMC.text = getRespIMC.toString()
        rClassf.text = respClassified
    }
}