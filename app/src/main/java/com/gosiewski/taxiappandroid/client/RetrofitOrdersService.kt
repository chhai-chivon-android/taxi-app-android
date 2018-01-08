package com.gosiewski.taxiappandroid.client

import com.gosiewski.taxiappandroid.utils.Authorized
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

internal interface RetrofitOrdersService {

    @GET("/orders")
    @Headers("Authorization: Basic dGF4aWFwcGNsaWVudGlkOlhZN2ttem9OemwxMDA=")
    @Authorized
    fun getUserOrders(): Single<List<Order>>
}