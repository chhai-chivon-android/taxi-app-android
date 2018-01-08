package com.gosiewski.taxiappandroid.client

import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.Retrofit

class OrdersDataSource(retrofit: Retrofit) {
    private val service: RetrofitOrdersService = retrofit.create(RetrofitOrdersService::class.java)

    fun login(): Single<List<Order>> {
        return service.getUserOrders()
    }

    fun cancelOrder(id: Long): Completable {
        return service.cancelOrder(id)
    }

    fun finishOrder(id: Long): Completable {
        return service.finishOrder(id)
    }

    fun addOrder(order: OrderDto): Completable {
        return service.addOrder(order)
    }
}