package com.orcchg.data.local.database.github

import androidx.room.Dao
import androidx.room.Query
import com.orcchg.data.local.database.github.model.GithubUserDbo
import io.reactivex.Single

@Dao
interface GithubUserDao {

    @Query("SELECT * FROM ${GithubUserDbo.TABLE_NAME}")
    fun users(): Single<List<GithubUserDbo>>
}
