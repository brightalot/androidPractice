package com.example.openapipractice.data

import androidx.room.Entity

@Entity(tableName = "LibraryData")
data class SeoulPublicLibraryInfo(
    val RESULT: RESULT,
    val list_total_count: Int,
    val row: List<Row> = emptyList()
)