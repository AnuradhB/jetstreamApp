package com.jetstream.app.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jetstream.app.core.LoginUseCase
import com.jetstream.app.presentation.auth.data.User
import com.jetstream.app.presentation.auth.data.api.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<UiState<User>>(UiState.Idle)
    val state: StateFlow<UiState<User>> = _state

    fun login(email: String, password: String) {

        viewModelScope.launch {

            _state.value = UiState.Loading

            val result = loginUseCase(email, password) // 👈 repository call chain

            _state.value = result.fold(
                onSuccess = { UiState.Success(it) },
                onFailure = { UiState.Error(it.message ?: "Error") }
            )
        }
    }
}