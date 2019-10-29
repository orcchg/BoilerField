package com.orcchg.list.adapter

import android.view.View
import com.orcchg.base.adapter.OriginBaseAdapter
import com.orcchg.domain.model.github.GithubUser
import com.orcchg.list.R

class GithubUserListAdapter : OriginBaseAdapter<GithubUserVO, GithubUserViewHolder>(GithubUserDiffCallback()) {

    override fun getLayoutId(): Int = R.layout.rv_item_github_user

    override fun instantiateViewHolder(view: View): GithubUserViewHolder =
        GithubUserViewHolder(view)

    fun appendMap(models: List<GithubUser>) {
        append(models.map { GithubUserVO.from(it) })
    }
}