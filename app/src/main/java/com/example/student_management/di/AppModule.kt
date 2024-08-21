package com.example.student_management.di

import android.app.Application
import androidx.room.Room
import com.example.student_management.data.repository.StudentRepositoryImpl
import com.example.student_management.domain.local.StudentDAO
import com.example.student_management.domain.local.StudentDatabase
import com.example.student_management.domain.repository.StudentRepository
import com.example.student_management.helper.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideStudentDatabase(
        application: Application
    ): StudentDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = StudentDatabase::class.java,
            name = Constant.DATABASE_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideStudentDao(
        studentDatabase: StudentDatabase
    ): StudentDAO = studentDatabase.studentDAO

    @Provides
    @Singleton
    fun provideStudentRepository(
        studentDAO: StudentDAO
    ): StudentRepository {
        return StudentRepositoryImpl(studentDAO = studentDAO)
    }
}