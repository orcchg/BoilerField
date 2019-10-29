package com.orcchg.list.adapter

import android.view.View
import com.orcchg.base.adapter.BaseViewHolder
import kotlinx.android.synthetic.main.rv_item_github_user.view.*

class GithubUserViewHolder(view: View) : BaseViewHolder<GithubUserVO>(view) {

    override fun bind(model: GithubUserVO) {
        itemView.tv_name.text = model.login
    }
}
