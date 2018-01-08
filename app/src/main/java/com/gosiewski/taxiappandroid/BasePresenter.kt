package com.gosiewski.taxiappandroid

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<T> {
    protected val disposables = CompositeDisposable()
    protected var view: T? = null

    fun bindView(view: T) {
        this.view = view
    }

    fun detachView() {
        this.view = null
        disposables.clear()
    }
}