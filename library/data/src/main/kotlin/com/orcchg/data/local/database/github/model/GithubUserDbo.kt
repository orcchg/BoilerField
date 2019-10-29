package com.orcchg.data.local.database.github.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.orcchg.data.local.database.github.model.GithubUserDbo.Companion.TABLE_NAME
import com.orcchg.domain.model.Mappable
import com.orcchg.domain.model.github.GithubUser

@Entity(tableName = TABLE_NAME)
data class GithubUserDbo(
    @PrimaryKey @ColumnInfo(name = COLUMN_ID) val id: Int,
    @ColumnInfo(name = COLUMN_LOGIN) val login: String,
    @ColumnInfo(name = COLUMN_URL) val url: String?,
    @ColumnInfo(name = COLUMN_URL_AVATAR) val avatarUrl: String?,
    @ColumnInfo(name = COLUMN_URL_REPOS) val reposUrl: String?) : Mappable<GithubUser> {

    companion object {
        const val COLUMN_ID = "id"
        const val COLUMN_LOGIN = "login"
        const val COLUMN_URL = "url"
        const val COLUMN_URL_AVATAR = "avatarUrl"
        const val COLUMN_URL_REPOS = "reposUrl"

        const val TABLE_NAME = "GithubUsers"
    }

    override fun map(): GithubUser = GithubUser(login = login, url = url, avatarUrl = avatarUrl)
}
