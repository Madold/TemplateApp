package com.markusw.templateapp.home.domain.model

import com.markusw.templateapp.core.data.local.entity.GithubRepositoryEntity
import com.markusw.templateapp.network.data.remote.responses.RepositoryResponse

data class GithubRepository(
    val id: String,
    val name: String,
    val ownerName: String,
    val avatarUrl: String,
    val description: String,
    val watchersCount: Int,
    val forksCount: Int,
    val topics: List<String>,
    val issuesCount: Int,
    val homepage: String?
)


fun RepositoryResponse.toDomainModel(): GithubRepository {
    return GithubRepository(
        id = this.id,
        name = this.name,
        ownerName = this.owner.name,
        description = this.description,
        watchersCount = this.watchersCount,
        forksCount = this.forksCount,
        topics = this.topics,
        issuesCount = this.issuesCount,
        homepage = this.homepage,
        avatarUrl = this.owner.avatarUrl
    )
}

fun GithubRepositoryEntity.toDomainModel(): GithubRepository {
    return GithubRepository(
        id = this.id,
        name = this.name,
        ownerName = this.ownerName,
        description = this.description,
        watchersCount = this.watchersCount,
        forksCount = this.forksCount,
        issuesCount = this.issuesCount,
        homepage = this.homepage,
        avatarUrl = this.avatarUrl,
        topics = emptyList()
    )
}

fun GithubRepository.toEntity(): GithubRepositoryEntity {
    return GithubRepositoryEntity(
        id = this.id,
        name = this.name,
        ownerName = this.ownerName,
        description = this.description,
        watchersCount = this.watchersCount,
        forksCount = this.forksCount,
        issuesCount = this.issuesCount,
        homepage = this.homepage,
        avatarUrl = this.avatarUrl
    )
}