package com.markusw.templateapp.details.presentation

import com.markusw.templateapp.home.domain.model.GithubRepository

data class DetailsState(
    val repository: GithubRepository = GithubRepository(
        id = "",
        name = "",
        ownerName = "",
        avatarUrl = "",
        description = "",
        watchersCount = 0,
        forksCount = 0,
        topics = listOf(),
        issuesCount = 0,
        homepage = ""
    ),
    val isLoading: Boolean = false
)
