package com.orcchg.datainterface.local.github

import com.orcchg.domain.model.github.GithubUser
import io.reactivex.Single

interface IGithubUserDbFacade {

    fun users(): Single<List<GithubUser>>
}
