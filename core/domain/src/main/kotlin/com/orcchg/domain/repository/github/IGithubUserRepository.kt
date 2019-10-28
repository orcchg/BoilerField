package com.orcchg.domain.repository.github

import com.orcchg.domain.model.github.GithubUser
import io.reactivex.Single

interface IGithubUserRepository {

    fun users(): Single<List<GithubUser>>
}
