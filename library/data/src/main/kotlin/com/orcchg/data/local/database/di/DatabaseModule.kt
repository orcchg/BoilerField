package com.orcchg.data.local.database.di

import android.content.Context
import androidx.room.Room
import com.orcchg.data.local.database.github.GithubDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Provides database instances.
 */
@Module
class DatabaseModule {

    @Provides @Singleton
    fun provideGithubDatabase(appContext: Context): GithubDatabase =
        Room.databaseBuilder(appContext, GithubDatabase::class.java, GithubDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
}
