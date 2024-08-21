package com.example.student_management.domain.repository

import com.example.student_management.domain.model.Student
import kotlinx.coroutines.flow.Flow

interface StudentRepository {

    suspend fun getStudents(): List<Student>
    suspend fun insertStudent(student: Student)
    suspend fun deleteStudent(student: Student)
    suspend fun getStudentById(id: Int): Student?
}