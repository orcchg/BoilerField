package com.orcchg.repository.di

import com.orcchg.data.executor.di.UseCaseExecutorModule
import com.orcchg.data.local.database.di.DbFacadeModule
import com.orcchg.data.remote.cloud.di.CloudFacadeModule
import com.orcchg.domain.repository.github.IGithubUserRepository
import com.orcchg.repository.github.GithubUserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [CloudFacadeModule::class, DbFacadeModule::class,
                    UseCaseExecutorModule::class])
class RepositoryModule {

    @Provides @Singleton
    fun provideGithubUserRepository(repo: GithubUserRepository): IGithubUserRepository = repo
}
