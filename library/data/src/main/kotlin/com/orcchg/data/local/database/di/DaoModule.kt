package com.orcchg.data.local.database.di

import com.orcchg.data.local.database.github.GithubDatabase
import com.orcchg.data.local.database.github.GithubUserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Provides DAO instances for databases.
 */
@Module(includes = [DatabaseModule::class])
class DaoModule {

    @Provides @Singleton
    fun provideGithubUserDao(db: GithubDatabase): GithubUserDao = db.users()
}
