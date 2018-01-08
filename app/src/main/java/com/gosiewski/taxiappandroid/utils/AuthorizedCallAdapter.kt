package com.gosiewski.taxiappandroid.utils

import okhttp3.Request
import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type


internal class AuthorizedCallAdapter<T, R>(private val wrappedAdapter: CallAdapter<T, R>, private val authorizedRequestsRepository: MutableSet<Int>) : CallAdapter<T, R> {

    override fun responseType(): Type {
        return wrappedAdapter.responseType()
    }

    override fun adapt(call: Call<T>?): R {
        val request = call?.request()

        authorizedRequestsRepository.add(identify(request!!))

        return wrappedAdapter.adapt(call)
    }

    companion object {

        fun identify(request: Request): Int {
            return (request.url().toString() + request.method()).hashCode()
        }
    }
}