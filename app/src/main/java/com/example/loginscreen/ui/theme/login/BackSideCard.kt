package com.example.loginscreen.ui.theme.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.loginscreen.R
import com.example.loginscreen.ui.theme.Typography
import com.example.loginscreen.ui.theme.loginButtonColor
import com.example.loginscreen.ui.theme.mediumBlue
import com.example.loginscreen.ui.theme.transparentGray


@Composable
fun BackSideCard(
    onClickSubmit: () -> Unit,
    userNameState: TextFieldState,
    passwordState: TextFieldState,
    modifier: Modifier
) {

    Column(
        modifier = modifier.fillMaxWidth(),
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

        LoginTextField(
            textFieldState = userNameState,
            placeholder = "Nome de Usuário"
        )

        var showPassword by remember { mutableStateOf(false) }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            LoginTextField(
                textFieldState = passwordState,
                placeholder = "Senha",
                outputTransformation = {
                    if (!showPassword) {
                        val length = this.length
                        replace(0, length, "* ".repeat(length))
                    }
                },
                widthFraction = 0.8f
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
            colors = loginButtonColor,
        ) {
            Text(
                text = "ENTRAR",
                style = Typography.titleLarge.copy(color = Color.White)
            )
        }

    }
}