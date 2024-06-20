package com.example.x

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class Recuperacion : AppCompatActivity() {
    private lateinit var emailEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperacion)

        emailEditText = findViewById(R.id.emaiREC)
    }

    fun validarDatos(view: View) {
        // Aquí va tu lógica de validación del correo electrónico

        // Si la validación es exitosa, iniciar LoginActivity
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }
}