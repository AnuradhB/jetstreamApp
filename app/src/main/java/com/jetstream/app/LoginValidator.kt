package com.jetstream.app


class LoginValidator {

    fun isValid(email: String, password: String): Boolean {
        return email.contains("@") && password.length >= 6
    }
}