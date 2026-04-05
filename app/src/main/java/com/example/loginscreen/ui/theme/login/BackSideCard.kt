package com.example.loginscreen.ui.theme.login

import android.R.id.mask
import androidx.annotation.FloatRange
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.KeyboardActionHandler
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.insert
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.loginscreen.R
import com.example.loginscreen.ui.theme.Typography
import com.example.loginscreen.ui.theme.transparentGray


@Composable
fun BackSideCard(
    onClickSubmit: () -> Unit,
    userNameState: TextFieldState,
    passwordState: TextFieldState,
) {
    val mediumBlue = Color(0xFF3686FF)

    val input: @Composable (
        textFieldState: TextFieldState,
        placeholder: String,
        outputTransformation: OutputTransformation?,
        widthFraction: Float
    ) -> Unit = { textFieldState, placeholder, outputTransformation, widthFraction ->
        BasicTextField(
            state = textFieldState,
            modifier = Modifier
                .fillMaxWidth(widthFraction)
                .height(height = 50.dp),
            enabled = true,
            readOnly = false,
            inputTransformation = null,
            textStyle = Typography.bodyLarge.copy(
                color = Color.White
            ),
            keyboardOptions = KeyboardOptions(),
            onKeyboardAction = null,
            lineLimits = TextFieldLineLimits.SingleLine,
            onTextLayout = null,
            interactionSource = null,
            cursorBrush = SolidColor(value = mediumBlue),
            outputTransformation = outputTransformation,
            decorator = { input ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Transparent, shape = shapes.medium)
                        .border(width = 1.dp, color = mediumBlue, shape = shapes.medium)
                        .padding(horizontal = 20.dp, vertical = 10.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (textFieldState.text.isEmpty()) Text(
                        text = placeholder,
                        style = Typography.bodyLarge.copy(
                            color = Color.LightGray
                        )
                    )

                    input()
                }
            },
            scrollState = rememberScrollState(),
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 15.dp,
            alignment = Alignment.CenterVertically
        )
    ) {
        Icon(
            painter = painterResource(R.drawable.icon_login),
            contentDescription = "Localized description",
            modifier = Modifier
                .size(size = 80.dp)
                .background(color = transparentGray, shape = shapes.extraLarge)
                .padding(all = 20.dp),
            tint = mediumBlue
        )

        Text(
            text = "Entrar na sua conta",
            style = Typography.titleLarge.copy(
                color = Color.White
            )
        )

        input(userNameState, "Nome de Usuário", null, 1f)

        var showPassword by remember { mutableStateOf(false) }
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {

            input(
                passwordState,
                "Senha",
                {
                    if (!showPassword) {
                        val length = this.length
                        replace(0, length, "* ".repeat(length))
                    }
                },
                0.8f
            )

            IconButton(
                onClick = { showPassword = !showPassword },
                modifier = Modifier.size(size = 50.dp)
            ) {
                Icon(
                    painter = painterResource(
                        if (showPassword) R.drawable.view_password else R.drawable.hidden_password
                    ),
                    contentDescription = "Localized description",
                    tint = mediumBlue
                )
            }

        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 50.dp),
            onClick = onClickSubmit,
            shape = shapes.medium,
            colors = ButtonColors(
                containerColor = mediumBlue,
                contentColor = Color(0xFFA939FA),
                disabledContainerColor = Color(0x83FFFFFF),
                disabledContentColor = Color(0xFFA939FA)
            )
        ) {
            Text(
                text = "ENTRAR",
                style = Typography.titleLarge.copy(color = Color.White)
            )
        }

    }
}