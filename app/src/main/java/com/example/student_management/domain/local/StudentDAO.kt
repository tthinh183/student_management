package com.example.student_management.domain.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.student_management.domain.model.Student
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(student: Student)

    @Delete
    suspend fun delete(student: Student)

    @Query("SELECT * FROM students")
    suspend fun getStudents(): List<Student>

    @Query("SELECT * FROM students WHERE id = :id")
    suspend fun getStudentById(id: Int): Student?

}