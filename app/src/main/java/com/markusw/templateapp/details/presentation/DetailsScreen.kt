package com.markusw.templateapp.details.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DetailsScreen(
    state: DetailsState
) {
    Text(state.toString())
}