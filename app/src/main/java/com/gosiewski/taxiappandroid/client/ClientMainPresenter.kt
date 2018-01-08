package com.gosiewski.taxiappandroid.client

import com.gosiewski.taxiappandroid.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class ClientMainPresenter @Inject constructor(private val ordersDataSource: OrdersDataSource)
    : BasePresenter<ClientMainView>() {

    fun start() {
        ordersDataSource.login()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ orders ->
                    view?.showOrders(orders)
                }, { error ->
                    error.printStackTrace()
                })
    }

    fun finishOrder(orderId: Long) {
        ordersDataSource.finishOrder(orderId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    start()
                }, {error ->
                    error.printStackTrace()})
    }

    fun deleteOrder(orderId: Long) {
        ordersDataSource.cancelOrder(orderId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    start()
                }, {error ->
                    error.printStackTrace()})
    }

    fun addOrder(lattitude: Double, longtitude: Double) {
        ordersDataSource.addOrder(OrderDto(lattitude, longtitude))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    start()
                }, {error ->
                    error.printStackTrace()})
    }
}