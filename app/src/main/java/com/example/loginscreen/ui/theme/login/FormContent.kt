package com.example.loginscreen.ui.theme.login

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.loginscreen.ui.theme.Typography

@Composable
fun FormContent(
    onClickSubmit: () -> Unit
) {
    Text(
        text = "Outro Lado do Card!!!",
        style = Typography.titleLarge.copy(
            color = Color.White
        )
    )

    Button(
        modifier = Modifier
            .size(
                width = 250.dp,
                height = 50.dp
            ),
        onClick = onClickSubmit,
        shape = shapes.extraLarge,
        colors = ButtonColors(
            containerColor = Color.White,
            contentColor = Color(0xFFA939FA),
            disabledContainerColor = Color(0x83FFFFFF),
            disabledContentColor = Color(0xFFA939FA)
        )
    ) {
        Text(
            text = "Bater Palmas!",
            style = Typography.titleLarge.copy(
                color = Color.Blue,
            )
        )
    }

}