package com.orcchg.details.view

import com.orcchg.base.view.BaseActivity

class DetailsActivity : BaseActivity<DetailsViewModel>() {

    override fun getVmClass(): Class<DetailsViewModel> = DetailsViewModel::class.java
}
