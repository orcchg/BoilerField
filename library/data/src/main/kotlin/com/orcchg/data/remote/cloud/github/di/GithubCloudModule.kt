package com.orcchg.data.remote.cloud.github.di

import com.orcchg.data.remote.cloud.di.CloudModule
import com.orcchg.data.remote.cloud.github.GithubApi
import com.orcchg.data.remote.cloud.github.GithubCloud
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [CloudModule::class])
class GithubCloudModule(private val baseUrl: String) {

    @Provides @Singleton
    fun provideApi(retrofit: Retrofit.Builder): GithubApi =
        retrofit
            .baseUrl(baseUrl)
            .build()
            .create(GithubApi::class.java)
}
