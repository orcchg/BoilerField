package com.orcchg.boilerfield.di

import com.orcchg.repository.di.RepositoryModule
import dagger.Module

@Module(includes = [RepositoryModule::class])
class AppModule
