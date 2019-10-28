package com.orcchg.datainterface.remote.github

import com.orcchg.domain.model.github.GithubUser
import io.reactivex.Single

interface IGithubCloudFacade {

    fun users(): Single<List<GithubUser>>
}
