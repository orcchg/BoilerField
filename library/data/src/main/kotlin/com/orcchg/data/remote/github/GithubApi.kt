package com.orcchg.data.remote.github

import com.orcchg.data.remote.github.model.UserEntity
import io.reactivex.Single
import retrofit2.http.GET

interface GithubApi {

    @GET("users")
    fun users(): Single<List<UserEntity>>
}
