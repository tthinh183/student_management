package com.example.student_management.domain.local

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.student_management.domain.model.Student
import com.example.student_management.helper.Constant

@Database(entities = [Student::class], version = Constant.DATABASE_VERSION2)
abstract class StudentDatabase : RoomDatabase(){
    abstract val studentDAO: StudentDAO
}

//@Database(
//    entities = [Student::class],
//    version = Constant.DATABASE_VERSION,
//    autoMigrations = [
//        AutoMigration (
//            from = Constant.DATABASE_VERSION,
//            to = Constant.DATABASE_VERSION2
//        )
//    ]
//)
//abstract class StudentDatabase2 : RoomDatabase(){
//    abstract val studentDAO: StudentDAO
//}