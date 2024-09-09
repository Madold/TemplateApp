package com.markusw.templateapp.home.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.markusw.templateapp.home.domain.model.GithubRepository

@Composable
fun RepositoryItem(
    repository: GithubRepository,
    onClick: (GithubRepository) -> Unit
) {
    Row (
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .fillMaxWidth()
            .clickable { onClick(repository) }
            .padding(horizontal = 16.dp)
        ,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(repository.avatarUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(repository.name, fontWeight = FontWeight.Bold)
            Text("By: ${repository.ownerName}")
        }
    }

}