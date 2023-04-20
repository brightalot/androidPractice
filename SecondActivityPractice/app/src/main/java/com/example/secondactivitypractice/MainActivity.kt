package com.example.secondactivitypractice

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts

import com.example.secondactivitypractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val secondActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val message = data?.getStringExtra("message")
            binding.tvMain.text = message
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etGo.setOnClickListener {
            //메세지 변수로 넣기
            val message = binding.sampleEdittext.text.toString()
            //경로 잡기
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            //메시지를 putExtra에 넣기
            intent.putExtra("message", message)
            secondActivityLauncher.launch(intent)

        }

    }

}

