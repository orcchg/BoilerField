package com.orcchg.data.remote.facade.github

import com.orcchg.data.remote.cloud.github.GithubCloud
import com.orcchg.datainterface.remote.github.IGithubCloudFacade
import com.orcchg.domain.model.github.GithubUser
import com.orcchg.domain.model.mapList
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GithubCloudFacadeImpl @Inject constructor(private val cloud: GithubCloud) : IGithubCloudFacade {

    override fun users(): Single<List<GithubUser>> = cloud.users().map { it.mapList() }
}
