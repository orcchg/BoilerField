package com.orcchg.domain.executor

import io.reactivex.Scheduler

interface UseCasePostExecutor {

    fun scheduler(): Scheduler
}
