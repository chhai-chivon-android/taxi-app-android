package com.gosiewski.taxiappandroid.login

import io.reactivex.Single
import okhttp3.RequestBody
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part


internal interface RetrofitLoginService {

    @Multipart
    @Headers("Authorization: Basic dGF4aWFwcGNsaWVudGlkOlhZN2ttem9OemwxMDA=")
    @POST("/oauth/token")
    fun login(@Part("grant_type") grantType: RequestBody,
              @Part("username") username: RequestBody,
              @Part("password") password: RequestBody): Single<AuthToken>
}