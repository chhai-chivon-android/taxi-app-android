package com.gosiewski.taxiappandroid.register

import io.reactivex.Completable
import retrofit2.Retrofit

class RegisterDataSource(retrofit: Retrofit) {
    private val service: RetrofitRegisterService = retrofit.create(RetrofitRegisterService::class.java)

    fun register(username: String, password: String): Completable {
        return service.register(RegistrationDto(username, password))
    }
}