package com.example.openapipractice.activity

//import android.annotation.SuppressLint
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Toast
//import com.example.openapipractice.LibraryViewModel
//import com.example.openapipractice.SeoulOpenApi
//import com.example.openapipractice.SeoulOpenApi.Companion.API_KEY
//import com.example.openapipractice.SeoulOpenService
//import com.example.openapipractice.data.Library
//import com.example.openapipractice.databinding.ActivitySplashBinding
//import kotlinx.coroutines.*
//import okhttp3.OkHttpClient
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import java.util.concurrent.TimeUnit
//import kotlin.concurrent.timer
//
//
//class SplashActivity : AppCompatActivity() {
//    lateinit var binding: ActivitySplashBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivitySplashBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        GlobalScope.launch {
//
//            var getCentersCompleted = false
//            val getCentersJob = async {
//                for (x in 1..10) {
//                    LibraryViewModel.getLibraries(x)
//                }
//                // 진행률 딜레이 테스트 코드
//                //delay(4000)
//                getCentersCompleted = true
//            }
//
//            /* period = 1000 = 1초 마다 반복.
//            *  period = 10 = 0.01초 마다 반복.
//            *  0.01초를 200번 반복하면 2초.
//            *  즉, 200번 반복해서 진행률 100을 만드려면
//            *  한번 반복에 0.5씩 증가해야함 */
//            var progress = 0.0
//            timer(period = 10) {
//                // 진행률이 100%가 되면 지도 액티비티로 이동
//                if (binding.loadingProgressBar.progress == 100) {
//                    println("----- move to next activity")
//                    startActivity(Intent(this@SplashActivity, MapsActivity::class.java))
//                    cancel()
//                    finish()
//                } else {
//                    progress += 0.5
//                }
//
//
//                // 80% 진행되었을 때 진행상황 확인
//                if (binding.loadingProgressBar.progress == 80) {
//                    // 덜 끝났다면
//                    if (!getCentersCompleted) {
//                        // 끝날때까지 대기 후 다시 진행
//                        runBlocking {
//                            getCentersJob.join()
//                        }
//                    }
//                }
//
//                runOnUiThread {
//                    binding.loadingProgressBar.progress = progress.toInt()
////                    binding.textview.text = if (progress >= 100) "100" else progress.toInt().toString()
//                }
//            }
//
//        }
//    }
//}



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
                }
//                if (barProgress.value == 80) {
//
//                    sleep(2000)
//                    currentprogress += 1
//                }
                else {
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