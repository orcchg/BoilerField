package com.orcchg.list.adapter

import com.orcchg.base.adapter.BaseDiffCallback

class GithubUserDiffCallback : BaseDiffCallback<GithubUserVO>() {

    override fun areItemsTheSame(oldItem: GithubUserVO, newItem: GithubUserVO): Boolean =
        oldItem.login == newItem.login

    override fun areContentsTheSame(oldItem: GithubUserVO, newItem: GithubUserVO): Boolean =
        oldItem.avatarUrl == newItem.avatarUrl
}
