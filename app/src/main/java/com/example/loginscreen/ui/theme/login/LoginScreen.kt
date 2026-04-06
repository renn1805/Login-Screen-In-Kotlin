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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loginscreen.ui.theme.*

@Composable
fun LoginScreen(visualizer: LoginViewModel = viewModel()) {

    val globalState by visualizer.uiState.collectAsState()

    val rotation by animateFloatAsState(
        targetValue = if (globalState.cardRotated) 180f else 0f,
        animationSpec = tween(durationMillis = 2000)
    )


    LoginBackground(
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 20.dp)
            ) {

                LoginCard(
                    modifier = Modifier
                        .graphicsLayer {
                            rotationY = rotation
                            cameraDistance = 12f * density
                        }
                        .align(Alignment.TopCenter)
                        .heightIn(min = 300.dp),
                    content = @Composable {
                        if (rotation <= 90f)
                            FrontSideCard(
                                onClickSubscribe = { visualizer.rotate() }
                            );
                        else
                            BackSideCard(
                                onClickSubmit = { visualizer.rotate() },
                                userNameState = globalState.userNameFieldState,
                                passwordState = globalState.passwordFieldState,
                                modifier = Modifier
                                    .graphicsLayer {
                                        rotationY = if (rotation > 90f) 180f else 0f
                                    },
                            );
                    }
                )

            }
        }
    )
}
