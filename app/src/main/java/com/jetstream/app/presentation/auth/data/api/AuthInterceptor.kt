package com.jetstream.app.presentation.auth.data.api






import com.jetstream.app.security.SecureTokenManager
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val secureTokenManager: SecureTokenManager
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val token = secureTokenManager.getToken()

        val request = chain.request()
            .newBuilder()
            .apply {

                token?.let {
                    addHeader(
                        "Authorization",
                        "Bearer $it"
                    )
                }

                addHeader(
                    "Accept",
                    "application/json"
                )
            }
            .build()

        return chain.proceed(request)
    }
}