package com.markusw.templateapp.home.presentation

import com.markusw.templateapp.home.domain.model.GithubRepository

data class HomeState(
    val repositoriesList: List<GithubRepository> = emptyList(),
    val isLoading: Boolean = false,
    val isLoadingMoreRepositories: Boolean = false
)
