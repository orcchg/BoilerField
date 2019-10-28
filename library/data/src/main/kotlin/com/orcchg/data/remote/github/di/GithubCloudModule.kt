package com.orcchg.data.remote.github.di

import com.orcchg.data.remote.di.CloudModule
import com.orcchg.data.remote.github.GithubApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [CloudModule::class])
class GithubCloudModule(private val baseUrl: String) {

    @Provides @Singleton
    fun provideRestAdapter(retrofit: Retrofit.Builder): GithubApi =
        retrofit
            .baseUrl(baseUrl)
            .build()
            .create(GithubApi::class.java)
}
