package com.example.loginscreen.ui.theme.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.core.graphics.toColorInt

@Composable
fun LoginBackground(
    colors: List<Color>
) {
    val brush = Brush.radialGradient(colors = colors)
    Box(
        Modifier.fillMaxSize().background(brush = brush),
    )
}