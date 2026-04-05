package com.example.loginscreen.ui.theme.login

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.loginscreen.ui.theme.Typography

@Composable
fun FrontSideCard(
    onClickSubscribe: () -> Unit
) {
    Text(
        text = "Bem-vindo!",
        style = Typography.titleLarge.copy(
            color = Color.White
        )
    )

    Text(
        text = "Entre na nossa plataforma e descubra uma nova experiência.",
        style = Typography.bodyLarge.copy(
            color = Color.White,
            textAlign = TextAlign.Center
        )
    )

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 50.dp),
        onClick = onClickSubscribe,
        shape = shapes.medium,
        colors = ButtonColors(
            containerColor = Color.White,
            contentColor = Color(0xFFA939FA),
            disabledContainerColor = Color(0x83FFFFFF),
            disabledContentColor = Color(0xFFA939FA)
        )
    ) {
        Text(
            text = "Inscrever-se",
            style = Typography.titleLarge.copy(
                color = Color.Blue,
            )
        )
    }

}