package com.orcchg.data.remote.cloud.github

import com.orcchg.data.remote.cloud.github.model.GithubUserEntity
import io.reactivex.Single
import retrofit2.http.GET

interface GithubApi {

    @GET("users")
    fun users(): Single<List<GithubUserEntity>>
}
