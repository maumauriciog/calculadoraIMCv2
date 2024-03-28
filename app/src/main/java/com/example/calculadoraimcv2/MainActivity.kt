package com.example.calculadoraimcv2

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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnButton = findViewById<Button>(R.id.btnIMC)
        val txtPeso = findViewById<TextInputEditText>(R.id.txtPeso)
        val txtAltura = findViewById<TextInputEditText>(R.id.txtAltura)

        btnButton.setOnClickListener {
            if (txtPeso.text.toString() == "" || txtAltura.text.toString() == "") {
                Toast.makeText(this, "Ambos os campos precisam ser preenchidos...", Toast.LENGTH_SHORT).show()
            } else {
                val peso: Float =  txtPeso.text.toString().toFloat()
                val altura : Float =  txtAltura.text.toString().toFloat()

                val respAltura = altura * altura
                val respIMC = peso / respAltura

                println("Peso: " + peso + " - Atura: " + altura + " = seu IMC é " + respIMC)
            }
        }
    }
}