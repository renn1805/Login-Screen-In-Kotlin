package com.example.loginscreen.ui.theme.login

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import com.example.loginscreen.ui.theme.Typography

@Composable
fun LoginCard(
    modifierContainer: Modifier = Modifier,
    modifierContent: Modifier = Modifier,
    rotation: () -> Float,
    onClickSubscribe: () -> Unit,
    onClickSubmit: () -> Unit,
    containerColor: () -> Color,
) {

    Box(
        modifier = modifierContainer
            .background(
                color = containerColor(),
                shape = RoundedCornerShape(40.dp)
            )
            .padding(20.dp)
            .fillMaxWidth()
            .heightIn(min = 300.dp)
    ) {
        Column(
            modifier = modifierContent
                .matchParentSize(),
                verticalArrangement = Arrangement.spacedBy(
                    space = 23.dp,
                    alignment = Alignment.CenterVertically
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (rotation() <= 90f) {
                WelcomeContent(
                    onClickSubscribe = onClickSubscribe
                )
            } else {
                FormContent(
                    onClickSubmit = onClickSubmit
                )
            }
        }
    }
}