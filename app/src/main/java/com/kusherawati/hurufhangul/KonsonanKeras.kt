package com.kusherawati.hurufhangul

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class KonsonanKeras : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var tts: TextToSpeech
    private lateinit var bunyiGakkapda: ImageView
    private lateinit var bunyiPpichyotda: ImageView
    private lateinit var bunyiTtalgi: ImageView
    private lateinit var bunyiJjajangmyon: ImageView
    private lateinit var bunyiSsangdungi: ImageView

    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_konsonan_keras)

        // Inisialisasi TextToSpeech
        tts = TextToSpeech(this, this)

        // Mendapatkan referensi ke ImageView untuk setiap logo bunyi
        bunyiGakkapda = findViewById(R.id.bunyigakkapda)
        bunyiPpichyotda = findViewById(R.id.bunyippichyotda)
        bunyiTtalgi = findViewById(R.id.bunyittalgi)
        bunyiJjajangmyon = findViewById(R.id.bunyijjajangmyon)
        bunyiSsangdungi = findViewById(R.id.bunyissangdungi)

        // Menambahkan OnClickListener untuk setiap logo bunyi
        bunyiGakkapda.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("가깝다")
            // Mengganti logo menjadi logo pause
            bunyiGakkapda.setImageResource(R.drawable.logo_pause)
        }

        bunyiPpichyotda.setOnClickListener {
            playKoreanSpeech("삐쳤다")
            bunyiPpichyotda.setImageResource(R.drawable.logo_pause)
        }

        bunyiTtalgi.setOnClickListener {
            playKoreanSpeech("딸기")
            bunyiTtalgi.setImageResource(R.drawable.logo_pause)
        }

        bunyiJjajangmyon.setOnClickListener {
            playKoreanSpeech("짜장면")
            bunyiJjajangmyon.setImageResource(R.drawable.logo_pause)
        }

        bunyiSsangdungi.setOnClickListener {
            playKoreanSpeech("쌍둥이")
            bunyiSsangdungi.setImageResource(R.drawable.logo_pause)
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts.setLanguage(Locale.KOREA)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                // TTS bahasa Korea tidak didukung, tambahkan penanganan sesuai kebutuhan
            }
        } else {
            // TTS inisialisasi gagal, tambahkan penanganan sesuai kebutuhan
        }
    }

    private fun playKoreanSpeech(text: String) {
        // Mengatur teks yang akan diputar di text-to-speech
        val speechText = "$text"
        tts.speak(speechText, TextToSpeech.QUEUE_FLUSH, null, null)

        // Menunda perubahan logo kembali ke semula setelah 2 detik (2000 milidetik)
        handler.postDelayed({
            bunyiGakkapda.setImageResource(R.drawable.logo_play)
            bunyiPpichyotda.setImageResource(R.drawable.logo_play)
            bunyiTtalgi.setImageResource(R.drawable.logo_play)
            bunyiJjajangmyon.setImageResource(R.drawable.logo_play)
            bunyiSsangdungi.setImageResource(R.drawable.logo_play)
        }, 1000) // Ganti angka 2000 sesuai dengan durasi teks yang akan terucap.
    }

    override fun onDestroy() {
        super.onDestroy()
        // Jangan lupa untuk melepaskan TextToSpeech saat activity dihancurkan
        tts.stop()
        tts.shutdown()
        // Hapus semua pesan tertunda yang terkait dengan Handler untuk menghindari memory leaks
        handler.removeCallbacksAndMessages(null)
    }
}
