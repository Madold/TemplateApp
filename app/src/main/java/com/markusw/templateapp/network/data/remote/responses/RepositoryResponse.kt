package com.markusw.templateapp.network.data.remote.responses

import com.google.gson.annotations.SerializedName

data class RepositoryResponse(
    val id: String,
    val name: String,
    val owner: OwnerResponse,
    val description: String,
    val watchersCount: Int,
    val forksCount: Int,
    val topics: List<String>,
    @SerializedName("open_issues") val issuesCount: Int,
    val homepage: String?
)
