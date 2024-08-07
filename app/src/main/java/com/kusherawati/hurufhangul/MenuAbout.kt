package com.kusherawati.hurufhangul

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuAbout : AppCompatActivity() {

    private lateinit var AboutMe : Button
    private lateinit var AboutKor : Button
    private lateinit var AboutApl : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_about)

        AboutMe = findViewById(R.id.aboutme)
        AboutMe.setOnClickListener {
            val intent = Intent(this@MenuAbout, AboutUs::class.java)
            startActivity(intent)
        }
        AboutKor = findViewById(R.id.aboutkorea)
        AboutKor.setOnClickListener {
            val intent = Intent(this@MenuAbout, AboutKorea::class.java)
            startActivity(intent)
        }
        AboutApl = findViewById(R.id.aboutaplikasi)
        AboutApl.setOnClickListener {
            val intent = Intent(this@MenuAbout, AboutAplikasi::class.java)
            startActivity(intent)
        }
    }
}