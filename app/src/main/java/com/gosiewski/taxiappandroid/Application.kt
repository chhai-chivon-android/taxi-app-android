package com.gosiewski.taxiappandroid

import android.content.Context
import com.gosiewski.taxiappandroid.dagger.AppComponent
import com.gosiewski.taxiappandroid.dagger.AppModule
import com.gosiewski.taxiappandroid.dagger.DaggerAppComponent


class Application : android.app.Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    fun getComponent(context: Context): AppComponent {
        return (context.applicationContext as Application).appComponent
    }
}