package com.example.ejerciciointents

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts


class MainActivity : AppCompatActivity() {

    private lateinit var respuestaView: TextView
    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        // Este bloque de código se ejecutará cuando ProvinceActivity envíe un resultado de vuelta.
        // Si el resultado es correcto
        if (result.resultCode == Activity.RESULT_OK) {
            // Obtenemos el dato "province" del Intent que ha vuelto.
            val mensaje = result.data?.getStringExtra("mensaje2")
            // Establecemos el texto del TextView con la provincia seleccionada.
            respuestaView.text = mensaje
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        respuestaView = findViewById(R.id.respuesta_main)
        val buttonSend = findViewById<Button>(R.id.enviar_main)

        // Establecemos un listener para el botón, que se llamará cuando se haga clic en él.
        buttonSend.setOnClickListener {

            val intent = Intent(this, MensajeActivity::class.java).apply {
                val mensaje_main : TextView = findViewById(R.id.mensaje_main)
                putExtra("mensaje1", mensaje_main.text.toString())
            }
            // Lanzamos la actividad con el launcher que espera un resultado.
            startForResult.launch(intent)
        }
    }
}