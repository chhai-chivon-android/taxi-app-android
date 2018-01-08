package com.gosiewski.taxiappandroid.client

import io.reactivex.Single
import retrofit2.Retrofit

class OrdersDataSource(retrofit: Retrofit) {
    private val service: RetrofitOrdersService = retrofit.create(RetrofitOrdersService::class.java)

    fun login(): Single<List<Order>> {

        return service.getUserOrders()
    }
}