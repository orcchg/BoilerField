package com.orcchg.data.remote.cloud.github

import com.orcchg.data.remote.cloud.github.model.GithubUserEntity
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GithubCloud @Inject constructor(private val api: GithubApi) {

    fun users(): Single<List<GithubUserEntity>> = api.users()
}
