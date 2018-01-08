package com.gosiewski.taxiappandroid.dagger

import com.gosiewski.taxiappandroid.client.OrdersDataSource
import com.gosiewski.taxiappandroid.login.LoginDataSource
import com.gosiewski.taxiappandroid.register.RegisterDataSource
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class DataSourceModule {

    @Provides
    fun provideLoginDataSource(retrofit: Retrofit): LoginDataSource {
        return LoginDataSource(retrofit)
    }

    @Provides
    fun provideRegisterDataSource(retrofit: Retrofit): RegisterDataSource {
        return RegisterDataSource(retrofit)
    }

    @Provides
    fun provideOrdersDataSource(retrofit: Retrofit): OrdersDataSource {
        return OrdersDataSource(retrofit)
    }
}
