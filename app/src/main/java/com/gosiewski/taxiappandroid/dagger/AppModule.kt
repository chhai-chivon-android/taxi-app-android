package com.gosiewski.taxiappandroid.dagger

import android.app.Application
import android.content.Context
import com.google.gson.GsonBuilder
import com.gosiewski.taxiappandroid.Configuration
import com.gosiewski.taxiappandroid.utils.AuthInfo
import com.gosiewski.taxiappandroid.utils.AuthInfoStorage
import com.gosiewski.taxiappandroid.utils.AuthorizedCallAdapterFactory
import com.gosiewski.taxiappandroid.utils.AuthorizedInterceptor
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module
class AppModule(private val app: Application) {

    @Provides
    internal fun provideApplication(): Application {
        return app
    }

    @Provides
    internal fun provideContext(): Context {
        return app
    }

    @Provides
    internal fun provideAuthInfoStorage(context: Context): AuthInfoStorage {
        return AuthInfo(context)
    }

    @Provides
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    internal fun provideAuthorizedInterceptor(authInfoStorage: AuthInfoStorage): AuthorizedInterceptor {
        return AuthorizedInterceptor(authInfoStorage)
    }

    @Provides
    internal fun provideRetrofitInstance(authorizedInterceptor: AuthorizedInterceptor,
                                         httpLoggingInterceptor: HttpLoggingInterceptor): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(authorizedInterceptor)
                .build()

        return Retrofit.Builder()
                .baseUrl(Configuration.API_URL)
                .addCallAdapterFactory(AuthorizedCallAdapterFactory(authorizedInterceptor.repository))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .client(okHttpClient)
                .build()
    }
}