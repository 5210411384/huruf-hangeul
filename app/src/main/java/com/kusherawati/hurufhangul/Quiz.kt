package com.kusherawati.hurufhangul

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class Quiz : AppCompatActivity() {

    private lateinit var questionTextView: TextView
    private lateinit var answerOptions: RadioGroup
    private lateinit var option1: RadioButton
    private lateinit var option2: RadioButton
    private lateinit var option3: RadioButton
    private lateinit var option4: RadioButton
    private lateinit var submitButton: Button

    private val questions = listOf(
        Question("Apa nama huruf 'A' dalam Hangeul?", listOf("ㅏ", "ㅓ", "ㅣ", "ㅗ"), "ㅏ"),
        Question("Apa nama huruf 'B' dalam Hangeul?", listOf("ㅂ", "ㄷ", "ㅅ", "ㅈ"), "ㅂ"),
        Question("Apa nama huruf 'C' dalam Hangeul?", listOf("ㅊ", "ㄱ", "ㅎ", "ㅁ"), "ㅊ"),
        Question("Apa nama huruf 'D' dalam Hangeul?", listOf("ㄴ", "ㄹ", "ㅋ", "ㅇ"), "ㄴ"),
        Question("Apa nama huruf 'E' dalam Hangeul?", listOf("ㅔ", "ㅑ", "ㅠ", "ㅕ"), "ㅔ"),
        Question("Apa nama huruf 'F' dalam Hangeul?", listOf("ㄹ", "ㅁ", "ㅎ", "ㄴ"), "ㄹ"),
        Question("Apa nama huruf 'G' dalam Hangeul?", listOf("ㅊ", "ㅇ", "ㅁ", "ㄷ"), "ㅇ"),
        Question("Apa nama huruf 'H' dalam Hangeul?", listOf("ㅎ", "ㅈ", "ㅂ", "ㅋ"), "ㅎ"),
        Question("Apa nama huruf 'I' dalam Hangeul?", listOf("ㅣ", "ㅏ", "ㅓ", "ㅗ"), "ㅣ"),
        Question("Apa nama huruf 'J' dalam Hangeul?", listOf("ㅈ", "ㅊ", "ㄱ", "ㅅ"), "ㅈ")
    )

    private val randomQuestions = questions.shuffled()
    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)


        questionTextView = findViewById(R.id.questionTextView)
        answerOptions = findViewById(R.id.answerOptions)
        option1 = findViewById(R.id.option1)
        option2 = findViewById(R.id.option2)
        option3 = findViewById(R.id.option3)
        option4 = findViewById(R.id.option4)
        submitButton = findViewById(R.id.submitButton)

        showNextQuestion()

        submitButton.setOnClickListener {
            // Cek apakah salah satu opsi jawaban terpilih
            if (answerOptions.checkedRadioButtonId == -1) {
                // Jika belum terpilih, tampilkan pesan toast
                Toast.makeText(this, "Jawaban Tidak Boleh Sosong", Toast.LENGTH_SHORT).show()
            } else {
                // Jika terpilih, proses jawaban seperti sebelumnya
                checkAnswer()
            }
        }
    }

    private fun showNextQuestion() {
        if (currentQuestionIndex < randomQuestions.size) {
            val currentQuestion = randomQuestions[currentQuestionIndex]
            questionTextView.text = currentQuestion.question

            // Shuffle daftar opsi jawaban sebelum menampilkannya
            val shuffledOptions = currentQuestion.options.shuffled()
            option1.text = shuffledOptions[0]
            option2.text = shuffledOptions[1]
            option3.text = shuffledOptions[2]
            option4.text = shuffledOptions[3]

            answerOptions.clearCheck()
        } else {
            // Setelah kuis selesai dan skor dihitung, buat Intent untuk activity selanjutnya
            val intent = Intent(this, ScoreActivity::class.java)

            // Tambahkan skor ke dalam Intent
            intent.putExtra("SCORE", score)

            // Jalankan activity selanjutnya
            startActivity(intent)
        }
    }

    private fun checkAnswer() {
        val currentQuestion = randomQuestions[currentQuestionIndex]
        val selectedOption = findViewById<RadioButton>(answerOptions.checkedRadioButtonId)

        if (selectedOption.text == currentQuestion.correctAnswer) {
            score += 10
        }

        currentQuestionIndex++
        showNextQuestion()
    }
}

data class Question(
    val question: String,
    val options: List<String>, // Menggunakan List untuk menyimpan opsi jawaban
    val correctAnswer: String
)