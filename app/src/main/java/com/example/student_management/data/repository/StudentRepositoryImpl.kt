package com.example.student_management.data.repository

import com.example.student_management.domain.local.StudentDAO
import com.example.student_management.domain.model.Student
import com.example.student_management.domain.repository.StudentRepository

class StudentRepositoryImpl(
    private val studentDAO: StudentDAO
): StudentRepository {
    override suspend fun getStudents(): List<Student> {
        return studentDAO.getStudents()
    }

    override suspend fun insertStudent(student: Student) {
        studentDAO.insert(student = student)
    }

    override suspend fun deleteStudent(student: Student) {
        studentDAO.delete(student = student)
    }

    override suspend fun getStudentById(id: Int): Student? {
        return studentDAO.getStudentById(id = id)
    }
}