package com.orcchg.boilerfield.di

import android.app.Application
import android.content.Context
import com.orcchg.boilerfield.App
import com.orcchg.data.remote.cloud.di.CloudModule
import com.orcchg.data.remote.cloud.github.di.GithubCloudModule
import com.orcchg.details.di.DetailsActivityModule
import com.orcchg.list.di.ListFragmentModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class,
                     /** feature modules */
                     DetailsActivityModule::class, ListFragmentModule::class])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>() {
        @BindsInstance abstract fun application(app: Application): Builder
        @BindsInstance abstract fun applicationContext(context: Context): Builder
        abstract fun cloudModule(cloudModule: CloudModule): Builder
        abstract fun githubCloudModule(githubCloudModule: GithubCloudModule): Builder
    }
}
