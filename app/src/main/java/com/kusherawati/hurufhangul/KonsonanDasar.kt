package com.kusherawati.hurufhangul

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class KonsonanDasar : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var tts: TextToSpeech
    private lateinit var bunyiGalbi: ImageView
    private lateinit var bunyiBareum: ImageView
    private lateinit var bunyiDanggeun: ImageView
    private lateinit var bunyiJapda: ImageView
    private lateinit var bunyiSagwa: ImageView
    private lateinit var bunyiHarin: ImageView
    private lateinit var bunyiNamu: ImageView
    private lateinit var bunyiLadio: ImageView
    private lateinit var bunyiMori: ImageView
    private lateinit var bunyiGangnam: ImageView
    private lateinit var bunyiKhukhi: ImageView
    private lateinit var bunyiYangpa: ImageView
    private lateinit var bunyiChitcha: ImageView
    private lateinit var bunyiChonsa: ImageView


    // Handler untuk mengatur logo kembali ke semula setelah selesai berbicara
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_konsonan_dasar)

        // Inisialisasi TextToSpeech
        tts = TextToSpeech(this, this)

        // Mendapatkan referensi ke ImageView untuk logo_play dan logo_bareum
        bunyiGalbi = findViewById(R.id.bunyigalbi)
        bunyiBareum = findViewById(R.id.bunyibareum)
        bunyiDanggeun = findViewById(R.id.bunyidanggeun)
        bunyiJapda = findViewById(R.id.bunyijapda)
        bunyiSagwa = findViewById(R.id.bunyisagwa)
        bunyiHarin = findViewById(R.id.bunyiharin)
        bunyiNamu = findViewById(R.id.bunyinamu)
        bunyiLadio = findViewById(R.id.bunyiladio)
        bunyiMori = findViewById(R.id.bunyimori)
        bunyiGangnam = findViewById(R.id.bunyigangnam)
        bunyiKhukhi = findViewById(R.id.bunyikhuki)
        bunyiYangpa = findViewById(R.id.bunyiyangpa)
        bunyiChitcha = findViewById(R.id.bunyichitha)
        bunyiChonsa = findViewById(R.id.bunyichonsa)

        // Menambahkan OnClickListener untuk logo_play (갈비)
        bunyiGalbi.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("갈비")
            // Mengganti logo menjadi logo pause
            bunyiGalbi.setImageResource(R.drawable.logo_pause)
        }

        // Menambahkan OnClickListener untuk logo_bareum (바름)
        bunyiBareum.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("바름")
            // Mengganti logo menjadi logo pause
            bunyiBareum.setImageResource(R.drawable.logo_pause)
        }
        bunyiDanggeun.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("당근")
            // Mengganti logo menjadi logo pause
            bunyiDanggeun.setImageResource(R.drawable.logo_pause)
        }
        bunyiJapda.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("잡다")
            // Mengganti logo menjadi logo pause
            bunyiJapda.setImageResource(R.drawable.logo_pause)
        }
        bunyiSagwa.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("사과")
            // Mengganti logo menjadi logo pause
            bunyiSagwa.setImageResource(R.drawable.logo_pause)
        }
        bunyiHarin.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("하린")
            // Mengganti logo menjadi logo pause
            bunyiHarin.setImageResource(R.drawable.logo_pause)
        }
        bunyiNamu.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("나무")
            // Mengganti logo menjadi logo pause
            bunyiNamu.setImageResource(R.drawable.logo_pause)
        }
        bunyiLadio.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("라디오")
            // Mengganti logo menjadi logo pause
            bunyiLadio.setImageResource(R.drawable.logo_pause)
        }
        bunyiMori.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("머리")
            // Mengganti logo menjadi logo pause
            bunyiMori.setImageResource(R.drawable.logo_pause)
        }
        bunyiGangnam.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("강남")
            // Mengganti logo menjadi logo pause
            bunyiGangnam.setImageResource(R.drawable.logo_pause)
        }
        bunyiKhukhi.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("쿠키")
            // Mengganti logo menjadi logo pause
            bunyiKhukhi.setImageResource(R.drawable.logo_pause)
        }
        bunyiYangpa.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("양파")
            // Mengganti logo menjadi logo pause
            bunyiYangpa.setImageResource(R.drawable.logo_pause)
        }
        bunyiChitcha.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("치타")
            // Mengganti logo menjadi logo pause
            bunyiChitcha.setImageResource(R.drawable.logo_pause)
        }
        bunyiChonsa.setOnClickListener {
            // Memanggil fungsi untuk mengubah logo dan memainkan teks ke suara Bahasa Korea
            playKoreanSpeech("천사")
            // Mengganti logo menjadi logo pause
            bunyiChonsa.setImageResource(R.drawable.logo_pause)
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
            bunyiGalbi.setImageResource(R.drawable.logo_play)
            bunyiBareum.setImageResource(R.drawable.logo_play)
            bunyiDanggeun.setImageResource(R.drawable.logo_play)
            bunyiJapda.setImageResource(R.drawable.logo_play)
            bunyiSagwa.setImageResource(R.drawable.logo_play)
            bunyiHarin.setImageResource(R.drawable.logo_play)
            bunyiNamu.setImageResource(R.drawable.logo_play)
            bunyiLadio.setImageResource(R.drawable.logo_play)
            bunyiMori.setImageResource(R.drawable.logo_play)
            bunyiGangnam.setImageResource(R.drawable.logo_play)
            bunyiKhukhi.setImageResource(R.drawable.logo_play)
            bunyiYangpa.setImageResource(R.drawable.logo_play)
            bunyiChitcha.setImageResource(R.drawable.logo_play)
            bunyiChonsa.setImageResource(R.drawable.logo_play)

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
