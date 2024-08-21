package com.example.student_management.presentation.navgraph

sealed class Route(
    val route: String
) {
    data object HomeScreen : Route("HomeScreen")
    data object ListStudentScreen : Route("ListStudentScreen")
}