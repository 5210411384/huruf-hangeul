package com.kusherawati.hurufhangul


import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnMateri: Button
    private lateinit var btnBudayaKorea: Button
    private lateinit var exitButton: Button
    private lateinit var about: Button
    private lateinit var btnQuiz: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        about = findViewById(R.id.about)
        about.setOnClickListener {
            val intent = Intent(this@MainActivity, MenuAbout::class.java)
            startActivity(intent)
        }

        btnQuiz = findViewById(R.id.KeQuiz)
        btnQuiz.setOnClickListener {
            val intent = Intent(this@MainActivity, Quiz::class.java)
            startActivity(intent)
        }

        exitButton = findViewById(R.id.exit_button)
        exitButton.setOnClickListener {
            finishAffinity()
        }

        btnBudayaKorea = findViewById(R.id.budaya_korea)
        btnBudayaKorea.setOnClickListener {
            val intent = Intent(this@MainActivity, BudayaKorea::class.java)
            startActivity(intent)
        }

        btnMateri = findViewById(R.id.menu_materi)
        btnMateri.setOnClickListener {
            val intent = Intent(this@MainActivity, MenuMateri::class.java)
            startActivity(intent)
        }
    }
}