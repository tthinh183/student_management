package com.example.student_management.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "students"
)
data class Student(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val age: Int,
    val address: String
)