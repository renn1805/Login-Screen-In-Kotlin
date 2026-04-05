package com.example.loginscreen.ui.theme.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
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
    modifierContainer: Modifier = Modifier,
    modifierContent: Modifier = Modifier,
    rotation: () -> Float,
    onClickSubscribe: () -> Unit,
    onClickSubmit: () -> Unit,
    containerColor: () -> Color,
    userNameState: TextFieldState,
    passwordState: TextFieldState,
) {

    Box(
        modifier = modifierContainer
            .background(
                color = containerColor(),
                shape = shapes.large
            )
            .fillMaxWidth()
            .heightIn(min = 400.dp)
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
                FrontSideCard(
                    onClickSubscribe = onClickSubscribe
                )
            } else {
                BackSideCard(
                    onClickSubmit = onClickSubmit,
                    userNameState = userNameState,
                    passwordState = passwordState,
                )
            }
        }
    }
}