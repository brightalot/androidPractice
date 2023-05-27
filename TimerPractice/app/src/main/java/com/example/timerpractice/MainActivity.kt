package com.example.timerpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import com.example.timerpractice.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //타이머가 진행 중임을 알려주는 변수
    var started = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonStart.setOnClickListener { start() }
        binding.buttonPause.setOnClickListener { pause() }
        binding.buttonStop.setOnClickListener { stop() }

    }

    val SET_TIME = 51
    val RESET = 52

    val handler = object: Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            when(msg.what) {
                SET_TIME -> {
                    binding.textTimer.text = formatTime(msg.arg1)
                }
                RESET -> {
                    binding.textTimer.text = "00 : 00"
                }
            }
        }
    }

    fun start() {

        started = true

        //sub thread
        //start != started
        thread(start=true) {
            //현재/전체시간을 저장하는 변수
            var total = 0
            while (true) {
                Thread.sleep(1000)
                if(!started) break
                total = total + 1
                val msg = Message()
                msg.what = SET_TIME
                msg.arg1 = total
                handler.sendMessage(msg)
            }
        }
    }

    fun pause() {
        started = false
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