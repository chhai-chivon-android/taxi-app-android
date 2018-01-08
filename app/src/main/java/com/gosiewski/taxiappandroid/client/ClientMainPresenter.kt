package com.gosiewski.taxiappandroid.client

import com.gosiewski.taxiappandroid.BasePresenter
import com.gosiewski.taxiappandroid.utils.AuthInfoStorage
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class ClientMainPresenter @Inject constructor(private val ordersDataSource: OrdersDataSource,
                                               private val authInfoStorage: AuthInfoStorage)
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
}