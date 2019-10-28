package com.orcchg.domain.interactor.base

import com.orcchg.domain.executor.UseCasePostExecutor
import com.orcchg.domain.executor.UseCaseThreadExecutor

abstract class UseCase(protected val threadExecutor: UseCaseThreadExecutor,
                       protected val postExecutor: UseCasePostExecutor)
