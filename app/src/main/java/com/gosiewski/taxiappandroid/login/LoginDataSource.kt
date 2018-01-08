package com.gosiewski.taxiappandroid.login

import io.reactivex.Single
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.Retrofit


class LoginDataSource(retrofit: Retrofit) {

    private val service: RetrofitLoginService = retrofit.create(RetrofitLoginService::class.java)

    fun login(username: String, password: String): Single<AuthToken> {
        val grantTypeRb = RequestBody.create(MediaType.parse("text/plain"), "password")
        val usernameRb = RequestBody.create(MediaType.parse("text/plain"), username)
        val passwordRb = RequestBody.create(MediaType.parse("text/plain"), password)

        return service.login(grantTypeRb, usernameRb, passwordRb)
    }
}