package com.example.student_management.presentation.list_student

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.student_management.presentation.list_student.components.ItemStudent

@Composable
fun ListStudentScreen(
    viewModel: ListStudentViewModel = hiltViewModel(),
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val listStudent by viewModel.students.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 30.dp)
    ) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)
        ) {
            items(
                count = listStudent.size
            ) {
                listStudent[it].let { student ->
                    ItemStudent(student = student)
                }
            }
        }
    }
}