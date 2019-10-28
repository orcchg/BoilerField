package com.orcchg.data.remote.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class CloudModule(private val appVersion: Int) {

    @Provides @Singleton
    fun provideJsonParser(): Converter.Factory =
        GsonConverterFactory.create(Gson().newBuilder().create())

    @Provides @Singleton
    fun provideRemoteClient() =
        OkHttpClient.Builder()
            .callTimeout(12, TimeUnit.MILLISECONDS)
            .readTimeout(12, TimeUnit.MILLISECONDS)
            .writeTimeout(12, TimeUnit.MILLISECONDS)
            .build()

    @Provides @Singleton
    fun provideRetrofit(client: OkHttpClient, jsonParser: Converter.Factory): Retrofit.Builder =
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(jsonParser)
            .client(client)
}
