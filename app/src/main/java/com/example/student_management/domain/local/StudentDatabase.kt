package com.example.student_management.domain.local

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.DeleteColumn
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import com.example.student_management.domain.model.Student
import com.example.student_management.helper.Constant

@Database(
    entities = [Student::class],
    version = Constant.DATABASE_VERSION3,
    autoMigrations = [
        AutoMigration(
            from = Constant.DATABASE_VERSION2,
            to = Constant.DATABASE_VERSION3,
            spec = StudentDatabase.AutoMigration2_3::class
        )
    ],
    exportSchema = true
)
abstract class StudentDatabase : RoomDatabase(){
    abstract val studentDAO: StudentDAO
    @DeleteColumn(tableName = "students", columnName = "address")
    class AutoMigration2_3 : AutoMigrationSpec
}