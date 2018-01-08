package com.gosiewski.taxiappandroid.utils

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class AuthorizedInterceptor(private val authInfoStorage: AuthInfoStorage) : Interceptor {
    private val authorizedRequestsRepository = HashSet<Int>()

    val repository: MutableSet<Int>
        get() = authorizedRequestsRepository

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        if (authorizedRequestsRepository.contains(AuthorizedCallAdapter.identify(request)))
            request = request.newBuilder()
                    .addHeader("Authorization", "Bearer " + authInfoStorage.token)
                    .build()

        return chain.proceed(request)
    }
}