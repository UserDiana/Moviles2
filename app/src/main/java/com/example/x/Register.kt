package com.example.x

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.x.databinding.ActivityRegisterBinding
import org.json.JSONObject
import java.util.regex.Pattern

class Register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    private lateinit var txtName: EditText
    private lateinit var txtEmail: EditText
    private lateinit var txtPassword: EditText
    private lateinit var txtConfirmPassword: EditText
    private lateinit var imageViewPasswordVisibility: ImageView
    private lateinit var imageViewConfirmPasswordVisibility: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        txtName = findViewById(R.id.nameET)
        txtEmail = findViewById(R.id.emailET)
        txtPassword = findViewById(R.id.passwordET)
        txtConfirmPassword = findViewById(R.id.cPasswordET)
        imageViewPasswordVisibility = findViewById(R.id.passwordIcon)
        imageViewConfirmPasswordVisibility = findViewById(R.id.cPasswordIcon)

        binding.btnRegistrar.setOnClickListener { registrarse() }
    }

    private fun mainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    fun signInClicked(view: View) {
        startActivity(Intent(this, Login::class.java))
    }

    fun validarDatos(view: View) {
        val nombre = txtName.text.toString()
        val correo = txtEmail.text.toString()
        val contraseña = txtPassword.text.toString()
        val confirmacionContraseña = txtConfirmPassword.text.toString()
        val patternName = Pattern.compile("^[a-zA-Z ]+\$")
        val patternEmail = Pattern.compile("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")

        if (nombre.isBlank()) {
            Toast.makeText(this, "Por favor, ingresa tu nombre", Toast.LENGTH_SHORT).show()
            return
        }

        if (correo.isBlank()) {
            Toast.makeText(this, "Por favor, ingresa tu correo electrónico", Toast.LENGTH_SHORT).show()
            return
        }

        if (contraseña.isBlank()) {
            Toast.makeText(this, "Por favor, ingresa tu contraseña", Toast.LENGTH_SHORT).show()
            return
        }

        if (confirmacionContraseña.isBlank()) {
            Toast.makeText(this, "Por favor, confirma tu contraseña", Toast.LENGTH_SHORT).show()
            return
        }

        if (!patternName.matcher(nombre).matches()) {
            Toast.makeText(this, "Por favor, ingresa un nombre válido (solo letras)", Toast.LENGTH_SHORT).show()
            return
        }

        if (!(contraseña.length in 8..16)) {
            Toast.makeText(this, "La contraseña debe tener entre 8 y 16 caracteres", Toast.LENGTH_SHORT).show()
            return
        }

        if (contraseña != confirmacionContraseña) {
            Toast.makeText(this, "La contraseña y la confirmación de contraseña no coinciden", Toast.LENGTH_SHORT).show()
            return
        }

        if (!patternEmail.matcher(correo).matches()) {
            Toast.makeText(this, "Por favor, ingresa un correo electrónico válido", Toast.LENGTH_SHORT).show()
            return
        }

        Toast.makeText(this, "Su registro ha sido exitoso", Toast.LENGTH_LONG).show()
    }

    fun togglePasswordVisibility(view: View) {
        toggleVisibility(txtPassword, imageViewPasswordVisibility)
    }

    fun toggleConfirmPasswordVisibility(view: View) {
        toggleVisibility(txtConfirmPassword, imageViewConfirmPasswordVisibility)
    }

    private fun toggleVisibility(editText: EditText, imageView: ImageView) {
        if (editText.inputType == (InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)) {
            editText.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            imageView.setImageResource(R.drawable.visible_password)
        } else {
            editText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            imageView.setImageResource(R.drawable.hide_password)
        }
        editText.setSelection(editText.text.length)
    }

    private fun registrarse() {
        val name = txtName.text.toString().trim()
        val email = txtEmail.text.toString().trim()
        val password = txtPassword.text.toString().trim()
        val confPassword = txtConfirmPassword.text.toString().trim()

        val url = "http://192.168.183.117:8000/api/users"
        val body = JSONObject().apply {
            put("name", name)
            put("email", email)
            put("password", password)
        }

        val request = JsonObjectRequest(
            Request.Method.POST, url, body,
            { response ->
                Toast.makeText(this, "Felicidades, usuario agregado exitosamente", Toast.LENGTH_LONG).show()
                mainActivity()  // Mover mainActivity() aquí
            },
            { error ->
                if (error.networkResponse?.statusCode == 409) {
                    Toast.makeText(this, "Error: El usuario ya existe.", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Error: ${error.message}", Toast.LENGTH_LONG).show()
                }
                Log.e("MiTag", "No funcionó, $error")
            }
        )

        val queue = Volley.newRequestQueue(this)
        queue.add(request)
    }
}
