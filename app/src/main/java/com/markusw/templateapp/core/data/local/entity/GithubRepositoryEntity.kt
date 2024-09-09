package com.markusw.templateapp.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repositories")
data class GithubRepositoryEntity(
    @PrimaryKey val id: String,
    val name: String,
    val ownerName: String,
    val avatarUrl: String,
    val description: String,
    val watchersCount: Int,
    val forksCount: Int,
    val issuesCount: Int,
    val homepage: String?
)
