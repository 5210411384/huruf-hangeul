package com.kusherawati.hurufhangul

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.TextView

class ScoreActivity : AppCompatActivity() {

    private lateinit var QuizToHome : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        QuizToHome = findViewById(R.id.quiztohome)
        QuizToHome.setOnClickListener {
            val intent = Intent(this@ScoreActivity, MainActivity::class.java)
            startActivity(intent)
        }

        // Terima skor dari Intent
        val score = intent.getIntExtra("SCORE", 0)

        // Tampilkan skor pada tampilan
        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        scoreTextView.text = "Your Score: $score"


        }
}
