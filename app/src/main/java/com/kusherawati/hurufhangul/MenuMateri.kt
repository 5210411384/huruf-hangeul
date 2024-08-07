package com.kusherawati.hurufhangul

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout

class MenuMateri : AppCompatActivity() {
    private lateinit var btnKonsonanDasar: Button
    private lateinit var btnVokalKombinasi: Button
    private lateinit var btnVokalDasar: Button
    private lateinit var btnKonsonanKeras: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_materi)


        btnKonsonanKeras = findViewById(R.id.konsonan_keras)
        btnKonsonanKeras.setOnClickListener {
            val intent = Intent(this@MenuMateri, KonsonanKeras::class.java)
            startActivity(intent)
        }

        btnVokalDasar = findViewById(R.id.vokal_dasar)
        btnVokalDasar.setOnClickListener {
            val intent = Intent(this@MenuMateri, VokalDasar::class.java)
            startActivity(intent)
        }

        btnVokalKombinasi = findViewById(R.id.vokal_kombinasi)
        btnVokalKombinasi.setOnClickListener {
            val intent = Intent(this@MenuMateri, VokalKombinasi::class.java)
            startActivity(intent)
        }

        btnKonsonanDasar = findViewById(R.id.konsonan_dasar)
        btnKonsonanDasar.setOnClickListener {
            val intent = Intent(this@MenuMateri, KonsonanDasar::class.java)
            startActivity(intent)
        }
    }
}