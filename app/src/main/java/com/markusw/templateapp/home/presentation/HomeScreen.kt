package com.markusw.templateapp.home.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.markusw.templateapp.core.presentation.Screens
import com.markusw.templateapp.home.presentation.components.RepositoriesList

@Composable
fun HomeScreen(
    state: HomeState,
    navController: NavHostController,
) {
    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
            ,
            contentAlignment = Alignment.Center
        ) {
            if (state.isLoading) {
                CircularProgressIndicator()
            } else {
                RepositoriesList(
                    modifier = Modifier
                        .fillMaxSize(),
                    repositories = state.repositoriesList,
                    onItemClick = { repository ->
                        navController.navigate("${Screens.Details.route}/${repository.id}")
                    }
                )
            }
        }
    }
}