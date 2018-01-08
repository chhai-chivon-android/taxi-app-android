package com.gosiewski.taxiappandroid.dagger

import com.gosiewski.taxiappandroid.client.ClientMainActivity
import com.gosiewski.taxiappandroid.driver.DriverMainActivity
import com.gosiewski.taxiappandroid.login.LoginActivity
import com.gosiewski.taxiappandroid.register.RegisterActivity
import dagger.Component

@Component(modules = [(AppModule::class), (DataSourceModule::class)])
interface AppComponent {

    fun inject(activity: RegisterActivity)
    fun inject(activity: LoginActivity)
    fun inject(activity: ClientMainActivity)
    fun inject(activity: DriverMainActivity)
}