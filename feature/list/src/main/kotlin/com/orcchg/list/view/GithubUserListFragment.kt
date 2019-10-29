package com.orcchg.list.view

import android.os.Bundle
import android.view.View
import com.orcchg.base.livedata.observe
import com.orcchg.base.view.BaseFragment
import com.orcchg.list.adapter.GithubUserListAdapter
import kotlinx.android.synthetic.main.fragment_github_user_list.*

class GithubUserListFragment : BaseFragment<GithubUserListViewModel>() {

    private val listAdapter = GithubUserListAdapter()

    override fun getLayoutId(): Int = 0

    override fun getVmClass(): Class<GithubUserListViewModel> = GithubUserListViewModel::class.java

    /* Lifecycle */
    // --------------------------------------------------------------------------------------------
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with (rv_items) {
            adapter = listAdapter
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observe(vm.users(), listAdapter::appendMap)
    }
}
