package com.orcchg.data.local.facade.github

import com.orcchg.data.local.database.github.GithubUserDao
import com.orcchg.datainterface.local.github.IGithubUserDbFacade
import com.orcchg.domain.model.github.GithubUser
import com.orcchg.domain.model.mapList
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GithubUserDbFacadeImpl @Inject constructor(private val local: GithubUserDao) : IGithubUserDbFacade {

    override fun users(): Single<List<GithubUser>> = local.users().map { it.mapList() }
}
