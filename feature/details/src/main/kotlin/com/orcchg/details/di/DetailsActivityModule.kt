package com.orcchg.details.di

import com.orcchg.details.DetailsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DetailsActivityModule {

    @ContributesAndroidInjector
    abstract fun provideDetailsActivityInjector(): DetailsActivity
}
