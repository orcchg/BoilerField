package com.orcchg.data.remote.cloud.di

import com.orcchg.data.remote.cloud.github.GithubCloud
import com.orcchg.data.remote.cloud.github.di.GithubCloudModule
import com.orcchg.data.remote.facade.github.GithubCloudFacadeImpl
import com.orcchg.datainterface.remote.github.IGithubCloudFacade
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Provides cloud facade instances.
 */
@Module(includes = [GithubCloudModule::class])
class CloudFacadeModule {

    @Provides @Singleton
    fun provideGithubCloudFacade(cloud: GithubCloud): IGithubCloudFacade = GithubCloudFacadeImpl(cloud)
}
