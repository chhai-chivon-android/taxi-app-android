package com.gosiewski.taxiappandroid.register

import io.reactivex.Completable
import retrofit2.http.Body
import retrofit2.http.POST

internal interface RetrofitRegisterService {

    @POST("/register")
    fun register(@Body registrationDto: RegistrationDto): Completable
}