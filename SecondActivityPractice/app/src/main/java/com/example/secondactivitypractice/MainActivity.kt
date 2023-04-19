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

        binding.editTextButton.setOnClickListener {
            //메세지 변수로 넣기
            val message = binding.sampleEdittext.text.toString()
            //경로 잡기
            val intent = Intent(this@MainActivity, SecondActivity::class.java)

            //메시지를 putExtra에 넣기
            intent.putExtra("message", message)
            startActivity(intent)

        }

    }

}

