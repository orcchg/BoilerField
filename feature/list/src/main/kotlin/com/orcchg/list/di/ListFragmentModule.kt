package com.orcchg.list.di

import com.orcchg.list.ListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ListFragmentModule {

    @ContributesAndroidInjector
    abstract fun provideListFragmentInjector(): ListFragment
}
