package com.orcchg.base.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.orcchg.base.livedata.observe
import com.orcchg.base.livedata.viewModel
import com.orcchg.base.print
import com.orcchg.base.viewmodel.BaseViewModel
import com.orcchg.base.viewmodel.DaggerViewModelFactory
import com.orcchg.base.viewmodel.ViewState
import com.orcchg.utility.checkForNull
import com.orcchg.utility.manager.LocaleManager
import dagger.android.AndroidInjection
import leakcanary.AppWatcher
import timber.log.Timber
import javax.inject.Inject

abstract class BaseActivity<T : BaseViewModel> : AppCompatActivity() {

    protected lateinit var vm: T
    @Inject protected lateinit var vmFactory: DaggerViewModelFactory<T>

    private var isOnFreshStart = true
    protected var isStopped = false
        private set
    var isDestroying = false
        private set
    protected var isViewModelInitialized = false
        private set

    // ------------------------------------------
    protected abstract fun getVmClass(): Class<T>  // cannot infer type of T in runtime due to Type Erasure

    @LayoutRes
    protected open fun getLayoutId(): Int? = null  // null means no layout

    // ------------------------------------------
    protected open fun onViewStateChange(newState: ViewState) {
        Timber.tag("${javaClass.simpleName}[${hashCode()}]")
        Timber.d("View State transition to: $newState")
        // override in subclasses
    }

    /* Lifecycle */
    // --------------------------------------------------------------------------------------------
    override fun attachBaseContext(newBase: Context) {
        val context = LocaleManager.initLocale(newBase)  // initialize locale
        super.attachBaseContext(context)
    }

    protected open fun onBeforeCreate() {
        Timber.tag("${javaClass.simpleName}[${hashCode()}]")
        Timber.d("onBeforeCreate")
        LocaleManager.resetActivityTitle(this)
        // override in subclasses
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.tag("${javaClass.simpleName}[${hashCode()}]")
        Timber.d("onCreate(${checkForNull(savedInstanceState)}), intent: ${intent.print()}")
        isDestroying = false
        AndroidInjection.inject(this)
        onBeforeCreate()
        super.onCreate(savedInstanceState)
        getLayoutId()?.let { setContentView(it) }
        vm = viewModel(klass = getVmClass(), factory = vmFactory) {
            observe(viewState(), ::onViewStateChange)
        }
        isViewModelInitialized = true
        isOnFreshStart = savedInstanceState == null
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        Timber.tag("${javaClass.simpleName}[${hashCode()}]")
        Timber.d("onNewIntent(${intent.print()})")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Timber.tag("${javaClass.simpleName}[${hashCode()}]")
        Timber.v("onActivityResult(rc=$requestCode,result=$resultCode,data=$data)")
    }

    override fun onStart() {
        super.onStart()
        Timber.tag("${javaClass.simpleName}[${hashCode()}]")
        Timber.d("onStart")
        isStopped = false
        if (isOnFreshStart) {
            vm.onFreshStart()
            isOnFreshStart = false
        }
    }

    override fun onResume() {
        super.onResume()
        Timber.tag("${javaClass.simpleName}[${hashCode()}]")
        Timber.d("onResume")
    }

    override fun onPause() {
        super.onPause()
        Timber.tag("${javaClass.simpleName}[${hashCode()}]")
        Timber.d("onPause")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Timber.tag("${javaClass.simpleName}[${hashCode()}]")
        Timber.d("onSaveInstanceState")
    }

    override fun onStop() {
        super.onStop()
        Timber.tag("${javaClass.simpleName}[${hashCode()}]")
        Timber.d("onStop")
        isStopped = true
    }

    override fun onDestroy() {
        isDestroying = true
        super.onDestroy()
        Timber.tag("${javaClass.simpleName}[${hashCode()}]")
        Timber.d("onDestroy")
        AppWatcher.objectWatcher.watch(this)
    }
}
