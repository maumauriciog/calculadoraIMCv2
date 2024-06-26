package com.example.calculadoraimcv2

import android.content.Intent
import android.os.Bundle

import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        val btnButton = findViewById<Button>(R.id.btnIMC)
        val impPeso = findViewById<TextInputEditText>(R.id.impPeso)
        val impAltura = findViewById<TextInputEditText>(R.id.impAltura)

        btnButton.setOnClickListener {
            if (impPeso.text.toString() == "" || impAltura.text.toString() == "") {
                Toast.makeText(this, "Todos os campos precisam estar preenchidos!", Toast.LENGTH_SHORT).show()
            } else {
                val peso: Float = impPeso.text.toString().toFloat()
                val altura: Float = impAltura.text.toString().toFloat()

                val respAltura = altura * altura
                val respIMC = peso / respAltura

                val intent = Intent(this, ResultActivity::class.java)
                    .putExtra("dateIMCp", peso)
                    .putExtra("dateIMCa", altura)
                    .putExtra("dateIMC", respIMC)
                startActivity(intent)
            }
        }
    }
}