package com.orcchg.data.remote.cloud.github.model

import com.google.gson.annotations.SerializedName
import com.orcchg.domain.model.Mappable
import com.orcchg.domain.model.github.GithubUser

data class GithubUserEntity(
    @SerializedName(COLUMN_ID) val id: Int,
    @SerializedName(COLUMN_LOGIN) val login: String,
    @SerializedName(COLUMN_URL) val url: String?,
    @SerializedName(COLUMN_URL_AVATAR) val avatarUrl: String?,
    @SerializedName(COLUMN_URL_REPOS) val reposUrl: String?) : Mappable<GithubUser> {

    companion object {
        const val COLUMN_ID = "id"
        const val COLUMN_LOGIN = "login"
        const val COLUMN_URL = "url"
        const val COLUMN_URL_AVATAR = "avatar_url"
        const val COLUMN_URL_REPOS = "repos_url"
    }

    override fun map(): GithubUser = GithubUser(login = login, url = url, avatarUrl = avatarUrl)
}
