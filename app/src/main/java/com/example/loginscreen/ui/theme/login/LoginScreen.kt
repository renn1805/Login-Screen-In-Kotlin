package com.example.loginscreen.ui.theme.login

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.example.loginscreen.ui.theme.*

@Composable
fun LoginScreen() {

    var rotated by remember { mutableStateOf(false) }
    val rotation by animateFloatAsState(
        targetValue = if (rotated) 180f else 0f,
        animationSpec = tween(durationMillis = 2000)
    )

    val userNameFieldState = rememberTextFieldState()
    val passwordFieldState = rememberTextFieldState()

    val animatedStartColor by animateColorAsState(
        targetValue = if (!rotated) primaryLightPurple else primaryLightBlue,
        animationSpec = tween(durationMillis = 2000)
    )
    val animatedEndColor by animateColorAsState(
        targetValue = if (!rotated) primaryPurple else primaryBlue,
        animationSpec = tween(durationMillis = 2000)
    )

    LoginBackground( colors = listOf( animatedStartColor, animatedEndColor ) )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 40.dp, horizontal = 20.dp)
    ) {

        val cardColor by animateColorAsState(
            targetValue = if (!rotated) frontSideCardColor else backSideCardColor,
            animationSpec = tween(durationMillis = 2000)
        )
        LoginCard(
            modifierContainer = Modifier
                .graphicsLayer {
                    rotationY = rotation
                    cameraDistance = 12f * density
                }
                .align(Alignment.Center)
                .heightIn(min = 300.dp),
            modifierContent = Modifier
                .graphicsLayer {
                    rotationY = if (rotation > 90f) 180f else 0f
                }
                .padding(horizontal = 23.dp, vertical = 40.dp),
            onClickSubscribe = { rotated = !rotated },
            onClickSubmit = { rotated = !rotated },
            rotation = { rotation },
            containerColor = { cardColor },
            userNameState = userNameFieldState,
            passwordState = passwordFieldState
        )

    }
}