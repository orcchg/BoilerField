package com.orcchg.boilerfield

import com.orcchg.boilerfield.di.DaggerAppComponent
import com.orcchg.boilerfield.origin.BaseApp
import com.orcchg.data.remote.di.CloudModule
import com.orcchg.data.remote.github.di.GithubCloudModule
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : BaseApp() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder()
            .application(this)
            .applicationContext(applicationContext)
            .cloudModule(CloudModule(BuildConfig.VERSION_CODE))
            .githubCloudModule(GithubCloudModule("https://api.github.com/"))
            .build()

    override fun onCreate() {
        super.onCreate()
    }
}
