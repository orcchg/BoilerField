package com.orcchg.data.remote.github.model

import com.google.gson.annotations.SerializedName

data class UserEntity(
    @SerializedName(COLUMN_ID) val id: Int,
    @SerializedName(COLUMN_LOGIN) val login: String,
    @SerializedName(COLUMN_URL) val url: String?,
    @SerializedName(COLUMN_URL_AVATAR) val avatarUrl: String?,
    @SerializedName(COLUMN_URL_REPOS) val reposUrl: String?) {

    companion object {
        const val COLUMN_ID = "id"
        const val COLUMN_LOGIN = "login"
        const val COLUMN_URL = "url"
        const val COLUMN_URL_AVATAR = "avatar_url"
        const val COLUMN_URL_REPOS = "repos_url"
    }
}
