package com.gosiewski.taxiappandroid.client

import com.gosiewski.taxiappandroid.utils.Authorized
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.*

internal interface RetrofitOrdersService {

    @GET("/orders")
    @Headers("Authorization: Basic dGF4aWFwcGNsaWVudGlkOlhZN2ttem9OemwxMDA=")
    @Authorized
    fun getUserOrders(): Single<List<Order>>

    @POST("/orders")
    @Authorized
    fun addOrder(@Body order: OrderDto): Completable

    @DELETE("/orders/{id}")
    @Authorized
    fun cancelOrder(@Path("id") id: Long): Completable

    @POST("/orders/{id}")
    @Authorized
    fun finishOrder(@Path("id") id: Long): Completable
}