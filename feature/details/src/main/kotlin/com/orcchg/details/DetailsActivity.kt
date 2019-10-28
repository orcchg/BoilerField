package com.orcchg.details

import com.orcchg.base.view.BaseActivity

class DetailsActivity : BaseActivity<DetailsViewModel>() {

    override fun getVmClass(): Class<DetailsViewModel> = DetailsViewModel::class.java
}
