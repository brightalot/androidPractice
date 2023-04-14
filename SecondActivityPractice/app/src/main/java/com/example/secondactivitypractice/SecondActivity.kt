package com.example.secondactivitypractice

import android.content.Intent
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
        val message = intent.getStringExtra("message")
        binding.userText.text = message

        binding.secondButton.setOnClickListener {
            // 버튼을 눌렀을 때 실행될 코드

            val second_intent = Intent(this@SecondActivity, MainActivity::class.java)
            startActivity(second_intent)
            finish()
        }
    }
}
