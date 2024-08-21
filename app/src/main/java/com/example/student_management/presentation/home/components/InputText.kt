package com.example.student_management.presentation.home.components

import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun InputText(
    modifier: Modifier = Modifier,
    text: String,
    onClick: (() -> Unit)? = null,
    onValueChange: (String) -> Unit,
    placeHolder: String,
    isAge: Boolean
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }
    val isClicked = interactionSource.collectIsPressedAsState().value

    LaunchedEffect(key1 = isClicked) {
        if (isClicked) {
            onClick?.invoke()
        }
    }

    val backgroundBorder = Color(0xFF757575)

    Box(
        modifier = modifier
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = backgroundBorder,
                    shape = RoundedCornerShape(4.dp)
                ),
            value = text,
            onValueChange = { newText ->
                if (isAge) {
                    val age = newText.toIntOrNull()
                    if (age != null && age in 1..120) {
                        onValueChange(newText)
                    }
                } else {
                    onValueChange(newText)
                }
            },
            placeholder = {
                Text(
                    text = placeHolder, style = TextStyle(
                        color = Color(0xFF757575)
                    )
                )
            },
            singleLine = true,
            visualTransformation = VisualTransformation.None,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = if (isAge) KeyboardType.Number else KeyboardType.Text
            )
        )
    }
}