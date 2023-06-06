package com.example.roompractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.roompractice.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()

        db.TodoDao().getAll().observe(this, Observer {todos ->
            binding.resultText.text= todos.toString()
        })


        binding.addButton.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                db.TodoDao().insertAll(Todo(binding.todoEdit.text.toString()))
            }

        }
    }
}