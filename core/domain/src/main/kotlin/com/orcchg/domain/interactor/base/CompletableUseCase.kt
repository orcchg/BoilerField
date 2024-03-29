package com.orcchg.domain.interactor.base

import com.orcchg.domain.executor.UseCasePostExecutor
import com.orcchg.domain.executor.UseCaseThreadExecutor
import io.reactivex.Completable
import io.reactivex.CompletableTransformer
import io.reactivex.schedulers.Schedulers

abstract class CompletableUseCase(threadExecutor: UseCaseThreadExecutor, postExecutor: UseCasePostExecutor)
    : UseCase(threadExecutor, postExecutor) {

    protected abstract fun sourceImpl(params: Params = Params()): Completable

    fun source(params: Params = Params()): Completable =
        sourceImpl(params)
            .compose(transformer())

    private fun transformer(): CompletableTransformer =
        CompletableTransformer {
            it.subscribeOn(Schedulers.from(threadExecutor))
              .observeOn(postExecutor.scheduler())
        }
}
