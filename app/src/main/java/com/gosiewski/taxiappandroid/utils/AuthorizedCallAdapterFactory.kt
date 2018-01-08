package com.gosiewski.taxiappandroid.utils

import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.Type


class AuthorizedCallAdapterFactory(private val authorizedRequestsRepository: MutableSet<Int>) : CallAdapter.Factory() {

    override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit): CallAdapter<*, *>? {
        val authorizedAnnotation: Authorized? = annotations
                .firstOrNull { Authorized::class.java == it.annotationClass }
                ?.let { it as Authorized }

        retrofit.callAdapterFactories()
                .filter { it.javaClass != javaClass }
                .mapNotNull { it.get(returnType, annotations, retrofit) }
                .forEach {
                    return if (authorizedAnnotation != null)
                        AuthorizedCallAdapter(it, authorizedRequestsRepository)
                    else
                        it
                }

        return null
    }
}