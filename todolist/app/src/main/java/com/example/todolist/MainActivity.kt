package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val todos = listOf(
        Todo("김현수 화이팅 1", false),
        Todo("김현수 화이팅 2", false),
        Todo("김현수 화이팅 3", false),
        Todo("김현수 화이팅 4", false),
        Todo("김현수 화이팅 5", false),
        Todo("김현수 화이팅 6", false),
        Todo("김현수 화이팅 7", false),
        Todo("김현수 화이팅 8", false),
        Todo("김현수 화이팅 9", false),
        Todo("김현수 화이팅 10", false),
        Todo("김현수 화이팅 11", false),
        Todo("김현수 화이팅 12", false),
        Todo("김현수 화이팅 13", false),
        Todo("김현수 화이팅 14", false),

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeViews()
    }


    private fun initializeViews() {
        binding.todoList.layoutManager = LinearLayoutManager(this)
        //GridLayoutManager 를 사용해도 됨
        binding.todoList.adapter = TodoAdapter(todos)

    }
}