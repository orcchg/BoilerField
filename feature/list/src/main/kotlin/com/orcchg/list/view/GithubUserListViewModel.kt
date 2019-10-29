package com.orcchg.list.view

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.base.viewmodel.BaseViewModel
import com.orcchg.domain.interactor.github.GetGithubUsersUseCase
import com.orcchg.domain.model.github.GithubUser
import com.uber.autodispose.lifecycle.autoDisposable
import timber.log.Timber
import javax.inject.Inject

/**
 * Handles business logic of List of github users screen.
 *
 * For fetching data:
 * @see https://proandroiddev.com/when-to-load-data-in-viewmodels-ad9616940da7
 */
class GithubUserListViewModel @Inject constructor(
    private val getGithubUsersUseCase: GetGithubUsersUseCase,
    app: Application) : BaseViewModel(app) {

    private val users by lazy {
        val data = MutableLiveData<List<GithubUser>>()
        getGithubUsersUseCase.source()
            .autoDisposable(this)
            .subscribe({ data.value = it }, Timber::e)
        data
    }

    internal fun users(): LiveData<List<GithubUser>> = users
}
