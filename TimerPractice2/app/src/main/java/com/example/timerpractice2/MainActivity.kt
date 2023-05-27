package com.example.timerpractice2

import android.media.AudioAttributes
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.TextView
import com.example.timerpractice2.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var countdownTextView: TextView
    private lateinit var soundPool: SoundPool
    private lateinit var binding: ActivityMainBinding
    private var soundId: Int = 0

    //타이머가 진행 중임을 알려주는 변수
    var started = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        countdownTextView = binding.tvTime

        // SoundPool 초기화
        val audioAttributes = AudioAttributes.Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .setUsage(AudioAttributes.USAGE_MEDIA)
            .build()

        soundPool = SoundPool.Builder()
            .setMaxStreams(1)
            .setAudioAttributes(audioAttributes)
            .build()

        // 효과음 로드
//        soundId = soundPool.load(this, R.raw.alert_sound, 1)

        binding.btnStart.setOnClickListener { start() }
        binding.btnStop.setOnClickListener { stop() }
    }

    val SET_TIME = 51
    val RESET = 52
    val END = 53
    val handler = object: Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            when(msg.what) {
                SET_TIME -> {
                    binding.tvTime.text = formatTime(msg.arg1)
                }
                RESET -> {
                    binding.tvTime.text = "00 : 00"
                }
                END -> {
                    binding.tvTime.text = "00 : 00"

                    runOnUiThread {
                        Thread.sleep(2000)
                        binding.tvTime.text = "타이머 종료"

                        // 효과음 재생
                        soundPool.play(soundId, 1.0f, 1.0f, 1, 0, 1.0f)
                    }
                }
            }
        }
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        soundPool.release()
//    }

    fun start() {

        started = true
        thread(start=true) {
            //현재/전체시간을 저장하는 변수
            var total = 30
            while (true) {
                Thread.sleep(1000)
                if(!started) break
                total = total - 1
                if(total == -1) {
                    val msg_end = Message()
                    msg_end.what = END
                    handler.sendMessage(msg_end)
                    break
                }
                val msg = Message()
                msg.what = SET_TIME
                msg.arg1 = total
                handler.sendMessage(msg)
            }
        }
    }
    fun stop() {
        started = false
        val msg = Message()
        msg.what = RESET
        handler.sendMessage(msg)
    }

    fun formatTime(time: Int): String {
        //초를 분단위로 바꾸고 두자리로 나타냄
        val minute = String.format("%02d", time/60)
        val second = String.format("%02d", time%60)
        return "$minute : $second"
    }

}
