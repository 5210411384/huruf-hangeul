package com.kusherawati.hurufhangul
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class VokalDasar : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var tts: TextToSpeech
    private lateinit var bunyiAboji: ImageView
    private lateinit var bunyiOoi: ImageView
    private lateinit var bunyiAi: ImageView
    private lateinit var bunyiUyu: ImageView
    private lateinit var bunyiEuija: ImageView
    private lateinit var bunyiOmoni: ImageView

    // Handler untuk mengatur logo kembali ke semula setelah selesai berbicara
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vokal_dasar)

        // Inisialisasi TextToSpeech
        tts = TextToSpeech(this, this)

        // Mendapatkan referensi ke ImageView untuk setiap gambar bunyi
        bunyiAboji = findViewById(R.id.bunyiaboji)
        bunyiOoi = findViewById(R.id.bunyioi)
        bunyiAi = findViewById(R.id.bunyiai)
        bunyiUyu = findViewById(R.id.bunyiuyu)
        bunyiEuija = findViewById(R.id.bunyieuija)
        bunyiOmoni = findViewById(R.id.bunyiomoni)

        // Menambahkan OnClickListener untuk setiap gambar bunyi
        bunyiAboji.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("아버지")
            // Mengganti logo menjadi logo pause
            bunyiAboji.setImageResource(R.drawable.logo_pause)
        }

        bunyiOoi.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("오이")
            // Mengganti logo menjadi logo pause
            bunyiOoi.setImageResource(R.drawable.logo_pause)
        }

        bunyiAi.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("아이")
            // Mengganti logo menjadi logo pause
            bunyiAi.setImageResource(R.drawable.logo_pause)
        }

        bunyiUyu.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("우유")
            // Mengganti logo menjadi logo pause
            bunyiUyu.setImageResource(R.drawable.logo_pause)
        }

        bunyiEuija.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("의자")
            // Mengganti logo menjadi logo pause
            bunyiEuija.setImageResource(R.drawable.logo_pause)
        }

        bunyiOmoni.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("어머니")
            // Mengganti logo menjadi logo pause
            bunyiOmoni.setImageResource(R.drawable.logo_pause)
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
        val speechText = text
        tts.speak(speechText, TextToSpeech.QUEUE_FLUSH, null, null)

        // Menunda perubahan logo kembali ke semula setelah 2 detik (2000 milidetik)
        handler.postDelayed({
            bunyiAboji.setImageResource(R.drawable.logo_play)
            bunyiOoi.setImageResource(R.drawable.logo_play)
            bunyiAi.setImageResource(R.drawable.logo_play)
            bunyiUyu.setImageResource(R.drawable.logo_play)
            bunyiEuija.setImageResource(R.drawable.logo_play)
            bunyiOmoni.setImageResource(R.drawable.logo_play)
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
