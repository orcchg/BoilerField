package com.orcchg.data.local.database.di

import com.orcchg.data.local.database.github.GithubUserDao
import com.orcchg.data.local.facade.github.GithubUserDbFacadeImpl
import com.orcchg.datainterface.local.github.IGithubUserDbFacade
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Provides facades for databases.
 */
@Module(includes = [DaoModule::class])
class DbFacadeModule {

    @Provides @Singleton
    fun provideGithubUserDbFacade(dao: GithubUserDao): IGithubUserDbFacade = GithubUserDbFacadeImpl(dao)
}
