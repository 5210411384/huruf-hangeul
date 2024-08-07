package com.kusherawati.hurufhangul

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class VokalKombinasi : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var tts: TextToSpeech
    private lateinit var bunyiYasik: ImageView
    private lateinit var bunyiGaim: ImageView
    private lateinit var bunyiYeoja: ImageView
    private lateinit var bunyiGae: ImageView
    private lateinit var bunyiYurjong: ImageView
    private lateinit var bunyiYorisa: ImageView
    private lateinit var bunyiWain: ImageView
    private lateinit var bunyiGwemul: ImageView
    private lateinit var bunyiDwaeji: ImageView
    private lateinit var bunyiWon: ImageView
    private lateinit var bunyiThwigim: ImageView
    private lateinit var bunyiEuisa: ImageView


    // Handler untuk mengatur logo kembali ke semula setelah selesai berbicara
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vokal_kombinasi)

        // Inisialisasi TextToSpeech
        tts = TextToSpeech(this, this)

        // Mendapatkan referensi ke ImageView untuk logo_play dan logo_bareum
        bunyiYasik = findViewById(R.id.bunyiyasik)
        bunyiGaim = findViewById(R.id.bunyigaim)
        bunyiYeoja = findViewById(R.id.bunyiyeoja)
        bunyiGae = findViewById(R.id.bunyigae)
        bunyiYurjong = findViewById(R.id.bunyiyurjong)
        bunyiYorisa = findViewById(R.id.bunyiyorisa)
        bunyiWain = findViewById(R.id.bunyiwain)
        bunyiGwemul = findViewById(R.id.bunyigwemul)
        bunyiDwaeji = findViewById(R.id.bunyidwaeji)
        bunyiWon = findViewById(R.id.bunyiwon)
        bunyiThwigim = findViewById(R.id.bunyithwigim)
        bunyiEuisa = findViewById(R.id.bunyieuisa)

        // Menambahkan OnClickListener untuk logo_play (갈비)
        bunyiYasik.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("야식")
            // Mengganti logo menjadi logo pause
            bunyiYasik.setImageResource(R.drawable.logo_pause)
        }

        // Menambahkan OnClickListener untuk logo_bareum (바름)
        bunyiGaim.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("게임")
            // Mengganti logo menjadi logo pause
            bunyiGaim.setImageResource(R.drawable.logo_pause)
        }
        bunyiYeoja.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("여자")
            // Mengganti logo menjadi logo pause
            bunyiYeoja.setImageResource(R.drawable.logo_pause)
        }
        bunyiGae.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("개")
            // Mengganti logo menjadi logo pause
            bunyiGae.setImageResource(R.drawable.logo_pause)
        }
        bunyiYurjong.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("유령")
            // Mengganti logo menjadi logo pause
            bunyiYurjong.setImageResource(R.drawable.logo_pause)
        }
        bunyiYorisa.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("요리사")
            // Mengganti logo menjadi logo pause
            bunyiYorisa.setImageResource(R.drawable.logo_pause)
        }
        bunyiWain.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("와인")
            // Mengganti logo menjadi logo pause
            bunyiWain.setImageResource(R.drawable.logo_pause)
        }
        bunyiGwemul.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("괴물")
            // Mengganti logo menjadi logo pause
            bunyiGwemul.setImageResource(R.drawable.logo_pause)
        }
        bunyiDwaeji.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("돼지")
            // Mengganti logo menjadi logo pause
            bunyiDwaeji.setImageResource(R.drawable.logo_pause)
        }
        bunyiWon.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("원")
            // Mengganti logo menjadi logo pause
            bunyiWon.setImageResource(R.drawable.logo_pause)
        }
        bunyiThwigim.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("튀김")
            // Mengganti logo menjadi logo pause
            bunyiThwigim.setImageResource(R.drawable.logo_pause)
        }
        bunyiEuisa.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("의사")
            // Mengganti logo menjadi logo pause
            bunyiEuisa.setImageResource(R.drawable.logo_pause)
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

            bunyiYasik.setImageResource(R.drawable.logo_play)
            bunyiGaim.setImageResource(R.drawable.logo_play)
            bunyiYeoja.setImageResource(R.drawable.logo_play)
            bunyiGae.setImageResource(R.drawable.logo_play)
            bunyiYurjong.setImageResource(R.drawable.logo_play)
            bunyiYorisa.setImageResource(R.drawable.logo_play)
            bunyiGwemul.setImageResource(R.drawable.logo_play)
            bunyiWain.setImageResource(R.drawable.logo_play)
            bunyiDwaeji.setImageResource(R.drawable.logo_play)
            bunyiWon.setImageResource(R.drawable.logo_play)
            bunyiThwigim.setImageResource(R.drawable.logo_play)
            bunyiEuisa.setImageResource(R.drawable.logo_play)

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