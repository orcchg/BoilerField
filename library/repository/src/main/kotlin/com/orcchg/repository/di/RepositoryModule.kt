package com.orcchg.repository.di

import com.orcchg.data.local.database.di.DbFacadeModule
import com.orcchg.data.remote.di.CloudFacadeModule
import dagger.Module

@Module(includes = [CloudFacadeModule::class, DbFacadeModule::class])
class RepositoryModule
