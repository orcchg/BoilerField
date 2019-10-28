package com.orcchg.repository.github

import com.orcchg.datainterface.local.github.IGithubUserDbFacade
import com.orcchg.datainterface.remote.github.IGithubCloudFacade
import com.orcchg.domain.model.github.GithubUser
import com.orcchg.domain.repository.github.IGithubUserRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GithubUserRepository @Inject constructor(
    private val cloud: IGithubCloudFacade,
    private val local: IGithubUserDbFacade) : IGithubUserRepository {

    override fun users(): Single<List<GithubUser>> =
        cloud.users()  // TODO: use cache
}
