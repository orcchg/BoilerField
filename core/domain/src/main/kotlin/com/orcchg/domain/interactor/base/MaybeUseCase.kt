package com.orcchg.domain.interactor.base

import com.orcchg.domain.executor.UseCasePostExecutor
import com.orcchg.domain.executor.UseCaseThreadExecutor
import io.reactivex.Maybe
import io.reactivex.MaybeTransformer
import io.reactivex.schedulers.Schedulers

abstract class MaybeUseCase<T>(threadExecutor: UseCaseThreadExecutor, postExecutor: UseCasePostExecutor)
    : UseCase(threadExecutor, postExecutor) {

    protected abstract fun sourceImpl(params: Params = Params()): Maybe<T>

    fun source(params: Params = Params()): Maybe<T> =
        sourceImpl(params)
            .compose(transformer())

    private fun transformer(): MaybeTransformer<T, T> =
        MaybeTransformer {
            it.subscribeOn(Schedulers.from(threadExecutor))
              .observeOn(postExecutor.scheduler())
        }
}
