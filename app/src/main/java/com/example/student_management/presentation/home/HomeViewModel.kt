package com.example.student_management.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.student_management.domain.model.Student
import com.example.student_management.domain.repository.StudentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val studentRepository: StudentRepository
): ViewModel() {

    private val _name = mutableStateOf("")
    val name: State<String> = _name

    private val _age = mutableIntStateOf(0)
    val age: State<Int> = _age

    private val _address = mutableStateOf("")
    val address: State<String> = _address

    private val _gender = mutableStateOf("")
    val gender: State<String> = _gender

    fun onNameChange(name: String) {
        _name.value = name
    }

    fun onAgeChange(age: String) {
        _age.value = age.toInt()
    }

    fun onAddressChange(address: String) {
        _address.value = address
    }

    fun onGenderChange(gender: String) {
        _gender.value = gender
    }

    fun insertStudent() {
        viewModelScope.launch {
            studentRepository.insertStudent(
                Student(
                    name = _name.value,
                    age = _age.value,
//                    address = _address.value,
                    gender = _gender.value
                )
            )
        }
        _name.value = ""
        _age.value = 0
        _address.value = ""
        _gender.value = ""
    }
}