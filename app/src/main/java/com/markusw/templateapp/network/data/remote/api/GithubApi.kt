package com.markusw.templateapp.network.data.remote.api

import com.markusw.templateapp.network.data.remote.responses.RepositoriesResponse
import com.markusw.templateapp.network.data.remote.responses.RepositoryResponse

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {

    @GET("search/repositories")
    suspend fun getRepositories(
        @Query("q") language: String,
        @Query("per_page") pageSize: Int,
        @Query("page") pageIndex: Int
    ): RepositoriesResponse

    @GET("repositories/{id}")
    suspend fun getRepositoryById(
        @Path("id") id: String
    ): RepositoryResponse

}