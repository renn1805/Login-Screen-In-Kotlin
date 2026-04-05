package com.example.loginscreen.ui.theme.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LoginCard(
    modifier: Modifier = Modifier,
    modifierContent: Modifier = Modifier,
    containerColor: () -> Color,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .background(
                color = containerColor(),
                shape = shapes.large
            )
            .sizeIn(minHeight = 300.dp, minWidth = 300.dp)
            .padding(all = 20.dp),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}