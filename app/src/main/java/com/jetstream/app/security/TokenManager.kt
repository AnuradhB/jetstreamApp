package com.jetstream.app.security

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject
private val Context.dataStore by preferencesDataStore(name = "auth_prefs")

class TokenManager @Inject constructor(
    @ApplicationContext private val context: Context
) {

    companion object {
        private val TOKEN_KEY = stringPreferencesKey("token")
    }

    // ✅ SAVE TOKEN
    suspend fun saveToken(token: String) {
        context.dataStore.edit { prefs ->
            prefs[TOKEN_KEY] = token
        }
    }

    // ✅ READ TOKEN (Flow)
    val tokenFlow: Flow<String?> = context.dataStore.data
        .map { prefs ->
            prefs[TOKEN_KEY]
        }

    // ✅ GET TOKEN ONCE (suspend)
    suspend fun getToken(): String? {
        return context.dataStore.data.first()[TOKEN_KEY]
    }

    // ❌ CLEAR TOKEN (logout)
    suspend fun clearToken() {
        context.dataStore.edit { prefs ->
            prefs.remove(TOKEN_KEY)
        }
    }
}