package com.markusw.templateapp.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.markusw.templateapp.home.domain.model.GithubRepository

@Composable
fun RepositoriesList(
    repositories: List<GithubRepository>,
    modifier: Modifier = Modifier,
    onItemClick: (GithubRepository) -> Unit
) {

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(repositories) { repository ->
            RepositoryItem(repository, onClick = onItemClick)
        }
    }

}