package com.orcchg.list

import com.orcchg.base.view.BaseFragment

class ListFragment : BaseFragment<ListViewModel>() {

    override fun getLayoutId(): Int = 0

    override fun getVmClass(): Class<ListViewModel> = ListViewModel::class.java
}
