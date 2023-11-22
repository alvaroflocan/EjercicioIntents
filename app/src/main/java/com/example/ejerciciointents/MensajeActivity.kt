package com.example.ejerciciointents

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts


class MensajeActivity : AppCompatActivity() {

    private lateinit var mensajeView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mensaje)

        mensajeView = findViewById(R.id.mensaje)
        val buttonSend = findViewById<Button>(R.id.enviar)

        // Establecemos un listener para el botón, que se llamará cuando se haga clic en él.
        buttonSend.setOnClickListener {
            val intent = Intent()
            val text = mensajeView.text
            intent.putExtra("mensajetext", text)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }
}