package com.gosiewski.taxiappandroid.dagger

import com.gosiewski.taxiappandroid.client.ClientMainActivity
import com.gosiewski.taxiappandroid.login.LoginActivity
import com.gosiewski.taxiappandroid.register.RegisterActivity
import com.gosiewski.taxiappandroid.splash.SplashActivity
import dagger.Component

@Component(modules = [(AppModule::class), (DataSourceModule::class)])
interface AppComponent {

    fun inject(activity: SplashActivity)
    fun inject(activity: RegisterActivity)
    fun inject(activity: LoginActivity)
    fun inject(activity: ClientMainActivity)
}