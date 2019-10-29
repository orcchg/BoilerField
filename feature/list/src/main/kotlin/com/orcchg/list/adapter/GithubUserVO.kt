package com.orcchg.list.adapter

import com.orcchg.base.adapter.IListModel
import com.orcchg.domain.model.github.GithubUser
import com.orcchg.utility.goodHashCode

data class GithubUserVO(val login: String, val avatarUrl: String?): IListModel {

    override val id: Long = login.goodHashCode()

    companion object {
        fun from(user: GithubUser): GithubUserVO =
            GithubUserVO(login = user.login, avatarUrl = user.avatarUrl)
    }
}
