package com.jetstream.app.core


import com.jetstream.app.presentation.auth.data.LoginRequest
import com.jetstream.app.presentation.auth.data.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("Users/Login")
    suspend fun login(
        @Body request: LoginRequest
    ): Response<User>
}