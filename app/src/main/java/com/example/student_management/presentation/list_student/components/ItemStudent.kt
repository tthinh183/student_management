package com.example.student_management.presentation.list_student.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.student_management.domain.model.Student

@Composable
fun ItemStudent(
    student: Student,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 2.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(5.dp)
            ).padding(horizontal = 20.dp)
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
        ) {
            Text(
                text = student.name, style = TextStyle(
                    color = Color.Red
                )
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "${student.age}", style = TextStyle(
                    color = Color.Blue
                )
            )
        }
        Text(
            text = student.address, style = TextStyle(
                color = Color.Green
            )
        )
    }
}