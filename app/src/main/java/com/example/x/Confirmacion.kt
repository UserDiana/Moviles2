package com.example.x


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class Confirmacion : AppCompatActivity() {
    private lateinit var codigoEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmacion)

        codigoEditText = findViewById(R.id.codigo)
    }

    fun validarDatos(view: View) {

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
