package com.markusw.templateapp.home.data.repository

import android.content.Context
import com.markusw.templateapp.core.data.local.dao.RepositoriesDao
import com.markusw.templateapp.core.data.local.db.RepositoriesDatabase
import com.markusw.templateapp.core.utils.Result
import com.markusw.templateapp.core.utils.ext.isDeviceOnline
import com.markusw.templateapp.home.domain.model.GithubRepository
import com.markusw.templateapp.home.domain.repository.Repository
import com.markusw.templateapp.home.domain.model.toDomainModel
import com.markusw.templateapp.home.domain.model.toEntity
import com.markusw.templateapp.network.data.remote.services.GithubService

class AndroidRepositoryImpl(
    private val githubService: GithubService,
    private val repositoriesDao: RepositoriesDao,
    private val context: Context
): Repository {

    override suspend fun getRepositories(
        language: String,
        pageSize: Int,
        pageIndex: Int
    ): Result<List<GithubRepository>> {
        return try {
            if (context.isDeviceOnline()) {
                val repositories =  githubService
                    .getRepositories(language, pageSize, pageIndex)
                    .repositories
                    .map { it.toDomainModel() }

                repositoriesDao.deleteAllRepositories()
                repositoriesDao.insertRepositories(repositories.map { it.toEntity() })
                Result.Success(repositories)
            } else {
                Result.Success(repositoriesDao.getAllRepositories().map { it.toDomainModel() })
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Error(e.message.toString())
        }
    }

    override suspend fun getRepositoryById(id: String): Result<GithubRepository> {
        return try {
             val repository = githubService.getRepositoryById(id).toDomainModel()
            Result.Success(repository)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Error(e.message.toString())
        }
    }
}