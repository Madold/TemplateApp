package com.markusw.templateapp.network.data.remote.services

import com.markusw.templateapp.network.data.remote.api.GithubApi
import com.markusw.templateapp.network.data.remote.responses.RepositoriesResponse
import com.markusw.templateapp.network.data.remote.responses.RepositoryResponse

class GithubService(
    private val githubApi: GithubApi
) {

    suspend fun getRepositories(
        language: String,
        pageSize: Int,
        pageIndex: Int
    ): RepositoriesResponse {
        val response = githubApi.getRepositories(
            language,
            pageSize,
            pageIndex
        )
        return response
    }

    suspend fun getRepositoryById(id: String): RepositoryResponse {
        val response = githubApi.getRepositoryById(id)
        return response
    }

}