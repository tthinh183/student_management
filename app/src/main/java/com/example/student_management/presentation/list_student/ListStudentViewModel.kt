package com.example.student_management.presentation.list_student

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.student_management.domain.model.Student
import com.example.student_management.domain.repository.StudentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListStudentViewModel @Inject constructor(
    private val studentRepository: StudentRepository
): ViewModel() {

    private val _listStudent = MutableStateFlow<List<Student>>(emptyList())
    val students: StateFlow<List<Student>> = _listStudent.asStateFlow()

    init {
        getStudents()
    }

    private fun getStudents() {
        viewModelScope.launch {
            _listStudent.value = studentRepository.getStudents()
        }
    }

}