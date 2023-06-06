package com.example.roompractice

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "database-name"
    ).build()

    fun getAll(): LiveData<List<Todo>> {
        return db.TodoDao().getAll()
    }

    suspend fun insert(todo: Todo) {
        db.TodoDao().insertAll(todo)
    }
}