package com.jetstream.app.core




import retrofit2.Response

open class BaseRepository {

    protected fun <T> handleResponse(response: Response<T>): T {
        if (response.isSuccessful) {
            return response.body() ?: throw Exception("Empty response body")
        } else {
            throw Exception("Error: ${response.code()} ${response.message()}")
        }
    }
}