package com.example.loginscreen.ui.theme.login

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt

@Composable
fun LoginScreen() {

    var rotated by remember { mutableStateOf(false) }
    val rotation by animateFloatAsState(
        targetValue = if (rotated) 180f else 0f,
        animationSpec = tween(durationMillis = 2000)
    )


    val primaryStartColor = Color("#d9c6ff".toColorInt())
    val primaryEndColor = Color("#b89cff".toColorInt())

    val secondStartColor = Color("#c6dcff".toColorInt())
    val secondEndColor = Color("#9cc2ff".toColorInt())

    val animatedStartColor by animateColorAsState(
        targetValue = if (!rotated){
            primaryStartColor
        }else{
            secondStartColor
        },
        animationSpec = tween(durationMillis = 2000)
    )

    val animatedEndColor by animateColorAsState(
        targetValue = if (!rotated){
            primaryEndColor
        }else{
            secondEndColor
        },
        animationSpec = tween(durationMillis = 2000)
    )

    val cardColor by animateColorAsState(
        targetValue = if (!rotated){
            Color(0xFF9871FF)
        }else{
            Color(0xFF629FFF)
        },
        animationSpec = tween(durationMillis = 2000)
    )

    LoginBackground(
        listOf(
            animatedStartColor,
            animatedEndColor
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 40.dp, horizontal = 35.dp)
    ) {

        LoginCard(
            modifierContainer = Modifier
                .graphicsLayer {
                    rotationY = rotation
                    cameraDistance = 12f * density
                }
                .align(Alignment.Center),
            modifierContent = Modifier
                .graphicsLayer {
                    rotationY = if (rotation > 90f) 180f else 0f
                },
            onClickSubscribe = {
                rotated = !rotated
            },
            onClickSubmit = {
                rotated = !rotated
            },
            rotation = { rotation },
            containerColor = {cardColor}
        )

    }
}