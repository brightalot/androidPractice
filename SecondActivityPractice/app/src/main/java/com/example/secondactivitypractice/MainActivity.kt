package com.example.secondactivitypractice
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.secondactivitypractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            // 버튼을 눌렀을 때 실행될 코드
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        }

    }

}

