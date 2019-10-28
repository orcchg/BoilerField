package com.orcchg.data.local.database.di

import dagger.Module

/**
 * Provides facades for databases.
 */
@Module(includes = [DaoModule::class])
class DbFacadeModule
