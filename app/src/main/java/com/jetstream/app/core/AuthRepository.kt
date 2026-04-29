package com.jetstream.app.core

import com.jetstream.app.presentation.auth.data.User


interface AuthRepository {
    suspend fun login(email: String, password: String): Result<User>
}