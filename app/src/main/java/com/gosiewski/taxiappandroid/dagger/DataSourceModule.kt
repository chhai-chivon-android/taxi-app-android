package com.gosiewski.taxiappandroid.dagger

import com.gosiewski.taxiappandroid.login.LoginDataSource
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class DataSourceModule {

    @Provides
    fun provideLoginDataSource(retrofit: Retrofit): LoginDataSource {
        return LoginDataSource(retrofit)
    }
}
