package com.markusw.templateapp.network.data.remote.responses

import com.google.gson.annotations.SerializedName

data class RepositoriesResponse(
    @SerializedName("total_count") val totalCount: Int,
    @SerializedName("items") val repositories: List<RepositoryResponse>
)
