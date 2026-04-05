package com.example.loginscreen.ui.theme.login

import androidx.compose.foundation.text.input.TextFieldState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel: ViewModel() {

    data class UiState (
        val userNameFieldState: TextFieldState = TextFieldState(),
        val passwordFieldState: TextFieldState = TextFieldState(),
        val cardRotated: Boolean = false,
    )

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState

    fun rotate () {
        _uiState.update { it.copy( cardRotated = !it.cardRotated) }
    }

}