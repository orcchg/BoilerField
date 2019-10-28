package com.orcchg.base.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.base.livedata.ActiveMutableLiveData

abstract class BaseViewModel(app: Application) : AutoDisposeViewModel(app) {

    protected val viewState: MutableLiveData<ViewState> by lazy { ActiveMutableLiveData<ViewState>() }
    fun viewState(): LiveData<ViewState> = viewState

    /* Lifecycle */
    // --------------------------------------------------------------------------------------------
    open fun onFreshStart() {
        // override in subclasses
    }
}
