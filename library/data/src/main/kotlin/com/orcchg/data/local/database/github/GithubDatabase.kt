package com.orcchg.data.local.database.github

import androidx.room.Database
import androidx.room.RoomDatabase
import com.orcchg.data.local.database.github.model.GithubUserDbo

@Database(version = 1, entities = [GithubUserDbo::class])
abstract class GithubDatabase : RoomDatabase() {

    companion object {
        internal const val DATABASE_NAME = "Github.db"
    }

    abstract fun users(): GithubUserDao
}
