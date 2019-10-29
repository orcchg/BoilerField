package com.orcchg.list.view

import android.os.Bundle
import com.orcchg.base.livedata.observe
import com.orcchg.base.view.BaseFragment
import com.orcchg.list.adapter.GithubUserListAdapter

class ListFragment : BaseFragment<ListViewModel>() {

    private val listAdapter = GithubUserListAdapter()

    override fun getLayoutId(): Int = 0

    override fun getVmClass(): Class<ListViewModel> = ListViewModel::class.java

    /* Lifecycle */
    // --------------------------------------------------------------------------------------------
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observe(vm.users(), listAdapter::appendMap)
    }
}
