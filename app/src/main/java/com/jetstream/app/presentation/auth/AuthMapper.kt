package com.jetstream.app.presentation.auth

import com.jetstream.app.presentation.auth.data.LoginResponse
import com.jetstream.app.presentation.auth.data.User


fun LoginResponse.toDomain(): User {

    return User(

        Data,
        Message,
        StatusCode,
        true
    )
}