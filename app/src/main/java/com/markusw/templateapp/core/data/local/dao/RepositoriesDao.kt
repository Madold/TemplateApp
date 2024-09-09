package com.markusw.templateapp.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.markusw.templateapp.core.data.local.entity.GithubRepositoryEntity


@Dao
interface RepositoriesDao {

    @Query("SELECT * FROM repositories")
    fun getAllRepositories(): List<GithubRepositoryEntity>

    @Query("DELETE FROM repositories")
    fun deleteAllRepositories()

    @Insert
    fun insertRepositories(repositories: List<GithubRepositoryEntity>)

    @Query("SELECT * FROM repositories WHERE id = :id")
    fun getRepositoryById(id: Int): GithubRepositoryEntity

}