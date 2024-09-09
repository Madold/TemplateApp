package com.markusw.templateapp.home.domain.repository

import com.markusw.templateapp.core.utils.Result
import com.markusw.templateapp.home.domain.model.GithubRepository

interface Repository {

    suspend fun getRepositories(
        language: String,
        pageSize: Int,
        pageIndex: Int
    ): Result<List<GithubRepository>>

    suspend fun getRepositoryById(id: String): Result<GithubRepository>

}