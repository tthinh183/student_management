package com.example.student_management.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.student_management.presentation.home.HomeScreen
import com.example.student_management.presentation.list_student.ListStudentScreen

@Composable
fun NavGraph(
    destination: String
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = destination
    ) {
        composable(
            route = Route.HomeScreen.route
        ) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Route.ListStudentScreen.route
        ) {
            ListStudentScreen(navController = navController)
        }
    }
}