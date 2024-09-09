package com.markusw.templateapp.core.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.markusw.templateapp.core.data.local.dao.RepositoriesDao
import com.markusw.templateapp.core.data.local.entity.GithubRepositoryEntity
import com.markusw.templateapp.home.domain.model.GithubRepository

@Database(entities = [GithubRepositoryEntity::class], version = 1)
abstract class RepositoriesDatabase: RoomDatabase() {
    abstract val dao: RepositoriesDao
}