package com.example.simplememo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simplememo.databinding.ActivitySavedMemosBinding

class SavedMemosActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySavedMemosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val savedmemos = intent.getStringExtra("Memo")
        binding.tvSecond.text = savedmemos


    }
}