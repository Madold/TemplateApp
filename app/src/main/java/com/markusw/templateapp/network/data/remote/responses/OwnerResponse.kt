package com.markusw.templateapp.network.data.remote.responses

import com.google.gson.annotations.SerializedName

data class OwnerResponse(
    @SerializedName("login") val name: String,
    @SerializedName("avatar_url") val avatarUrl: String
)
