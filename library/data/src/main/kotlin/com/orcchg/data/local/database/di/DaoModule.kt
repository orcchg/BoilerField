package com.orcchg.data.local.database.di

import dagger.Module

/**
 * Provides DAO instances for databases.
 */
@Module(includes = [DatabaseModule::class])
class DaoModule
