package com.example.student_management.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.student_management.helper.Constant

@Entity(
    tableName = "students"
)
data class Student(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val age: Int,
    val address: String,
    val gender: String
)

val MIGRATION_1_2 = object : Migration(Constant.DATABASE_VERSION, Constant.DATABASE_VERSION2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("ALTER TABLE students ADD COLUMN gender TEXT NOT NULL DEFAULT ''")
    }
}