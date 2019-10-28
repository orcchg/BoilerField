package com.orcchg.domain.interactor.github

import com.orcchg.domain.executor.UseCasePostExecutor
import com.orcchg.domain.executor.UseCaseThreadExecutor
import com.orcchg.domain.interactor.base.Params
import com.orcchg.domain.interactor.base.SingleUseCase
import com.orcchg.domain.model.github.GithubUser
import com.orcchg.domain.repository.github.IGithubUserRepository
import dagger.Reusable
import io.reactivex.Single
import javax.inject.Inject

@Reusable
class GetGithubUsersUseCase @Inject constructor(
    private val repository: IGithubUserRepository,
    threadExecutor: UseCaseThreadExecutor, postExecutor: UseCasePostExecutor)
    : SingleUseCase<List<GithubUser>>(threadExecutor, postExecutor) {

    override fun sourceImpl(params: Params): Single<List<GithubUser>> =
        repository.users()
}
