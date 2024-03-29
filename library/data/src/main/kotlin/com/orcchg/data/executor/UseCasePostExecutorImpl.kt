package com.orcchg.data.executor

import com.orcchg.domain.executor.UseCasePostExecutor
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class UseCasePostExecutorImpl @Inject constructor(@Named("PostExecutor") private val scheduler: Scheduler)
    : UseCasePostExecutor {

    override fun scheduler(): Scheduler = scheduler
}
