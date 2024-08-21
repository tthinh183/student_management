package com.example.student_management.domain.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.student_management.domain.model.Student
import com.example.student_management.helper.Constant

@Database(entities = [Student::class], version = Constant.DATABASE_VERSION)
abstract class StudentDatabase : RoomDatabase(){
    abstract val studentDAO: StudentDAO
}