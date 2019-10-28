package com.orcchg.data.remote.di

import com.orcchg.data.remote.github.di.GithubCloudModule
import dagger.Module

/**
 * Provides cloud facade instances.
 */
@Module(includes = [GithubCloudModule::class])
class CloudFacadeModule
