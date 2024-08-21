package com.example.student_management.presentation.home

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.student_management.presentation.home.components.InputText
import com.example.student_management.presentation.navgraph.Route

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val name by viewModel.name
    val age by viewModel.age
    val address by viewModel.address

    val context = LocalContext.current
    Column(
        modifier = modifier
            .statusBarsPadding()
            .navigationBarsPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        InputText(
            text = name,
            onValueChange = { viewModel.onNameChange(it) },
            placeHolder = "Nhap ten sinh vien",
            modifier = Modifier.padding(horizontal = 25.dp),
            isAge = false
        )
        Spacer(modifier = Modifier.height(7.dp))
        InputText(
            text = age.toString(),
            onValueChange = { viewModel.onAgeChange(it) },
            placeHolder = "Nhap tuoi sinh vien",
            modifier = Modifier.padding(horizontal = 25.dp),
            isAge = true
        )
        Spacer(modifier = Modifier.height(7.dp))
        InputText(
            text = address,
            onValueChange = { viewModel.onAddressChange(it) },
            placeHolder = "Nhap dia chi",
            modifier = Modifier.padding(horizontal = 25.dp),
            isAge = false
        )
        Spacer(modifier = Modifier.height(15.dp))
        TextButton(
            onClick = {
                viewModel.insertStudent()
                Toast.makeText(context,"Da them thanh cong", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
        ) {
            Text(text = "Thêm sinh vien")
        }
        TextButton(
            onClick = { navController.navigate(Route.ListStudentScreen.route) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
        ) {
            Text(text = "Tất cả sinh vien")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
//    HomeScreen()
}