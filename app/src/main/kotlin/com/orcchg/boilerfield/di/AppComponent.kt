package com.orcchg.boilerfield.di

import com.orcchg.boilerfield.App
import com.orcchg.data.remote.di.CloudModule
import com.orcchg.data.remote.github.di.GithubCloudModule
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>() {
        abstract fun cloudModule(cloudModule: CloudModule): Builder
        abstract fun githubCloudModule(githubCloudModule: GithubCloudModule): Builder
    }
}
