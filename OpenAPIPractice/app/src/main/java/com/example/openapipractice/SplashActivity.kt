package com.example.openapipractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.example.openapipractice.databinding.ActivitySplashBinding
import kotlin.concurrent.timer

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        /* 프로그래스바의 progress */
        val barProgress = MutableLiveData<Int>()
        /* 프로그래스바 상단 진행률 텍스트 */
//        val progressTextView = MutableLiveData<String>()

        /* UI 업데이트 */
        fun setProgressView(progress: Int) {
            barProgress.value = progress
            binding.loadingProgressBar.progress = progress
//            progressTextView.value = if (progress >= 100) "100" else progress.toInt().toString()
        }

        fun startMapActivity() {
            startActivity(Intent(this@SplashActivity, MapsActivity::class.java))
            finish()
        }

        fun updateProgressBar() {
            var currentprogress: Int = 0
            timer(period = 20) {

                /* 조건 달성 시 지도 화면으로 이동 */
                if (barProgress.value == 100) {
                    startMapActivity()
                    this@timer.cancel()
                    finish()
                } else {
                    currentprogress += 1
                }
                runOnUiThread {
                    setProgressView(currentprogress)
                }
            }
        }
        updateProgressBar()
    }
}