package com.jetstream.app.security

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SecureTokenManager @Inject constructor(
    @ApplicationContext private val context: Context
) {

    private val masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val sharedPrefs = EncryptedSharedPreferences.create(
        context,
        "secure_auth_prefs",
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    companion object {
        private const val TOKEN_KEY = "auth_token"
    }

    // 🔐 SAVE TOKEN
    fun saveToken(token: String) {
        sharedPrefs.edit()
            .putString(TOKEN_KEY, token)
            .apply()
    }

    // 🔐 GET TOKEN
    fun getToken(): String? {
        return sharedPrefs.getString(TOKEN_KEY, null)
    }

    // 🔐 CLEAR TOKEN (logout)
    fun clearToken() {
        sharedPrefs.edit()
            .remove(TOKEN_KEY)
            .apply()
    }
    fun isLoggedIn(): Boolean {
        return !getToken().isNullOrEmpty()

    }
}