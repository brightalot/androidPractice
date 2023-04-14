package com.example.secondactivitypractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.secondactivitypractice.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // MainActivity에서 전달한 메시지를 받아와서 TextView에 표시
        val message = intent.getStringExtra("MESSAGE")
        binding.textView.text = message
    }
}
