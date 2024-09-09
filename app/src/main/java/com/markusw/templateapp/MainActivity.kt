package com.markusw.templateapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.markusw.templateapp.core.presentation.Screens
import com.markusw.templateapp.details.presentation.DetailsScreen
import com.markusw.templateapp.details.presentation.DetailsViewModel
import com.markusw.templateapp.home.presentation.HomeScreen
import com.markusw.templateapp.home.presentation.HomeViewModel
import com.markusw.templateapp.ui.theme.TemplateAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TemplateAppTheme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = Screens.Home.route) {
                    composable(route = Screens.Home.route) {
                        val viewModel = hiltViewModel<HomeViewModel>()
                        val state by viewModel.state.collectAsStateWithLifecycle()
                        HomeScreen(state, navController)
                    }

                    composable(
                        route = "${Screens.Details.route}/{repositoryId}",
                        arguments = listOf(
                            navArgument("repositoryId") {
                                type = NavType.StringType
                            }
                        )
                    ) {

                        val viewModel = hiltViewModel<DetailsViewModel>()
                        val state by viewModel.state.collectAsStateWithLifecycle()

                        DetailsScreen(
                            state = state
                        )


                    }
                }
            }
        }
    }
}
