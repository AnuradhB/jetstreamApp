package com.jetstream.app


import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class LoginValidatorTest {

    private lateinit var validator: LoginValidator

    @Before
    fun setup() {
        validator = LoginValidator()
    }

    @Test
    fun validInput_returnsTrue() {
        val result = validator.isValid("test@gmail.com", "123456")
        assertTrue(result)
    }

    @Test
    fun invalidEmail_returnsFalse() {
        val result = validator.isValid("testgmail.com", "123456")
        assertFalse(result)
    }

    @Test
    fun shortPassword_returnsFalse() {
        val result = validator.isValid("test@gmail.com", "123")
        assertFalse(result)
    }

    @Test
    fun emptyEmail_returnsFalse() {
        val result = validator.isValid("", "123456")
        assertFalse(result)
    }

    @Test
    fun emptyPassword_returnsFalse() {
        val result = validator.isValid("test@gmail.com", "")
        assertFalse(result)
    }
}