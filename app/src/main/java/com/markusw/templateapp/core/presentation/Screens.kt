package com.markusw.templateapp.core.presentation

sealed class Screens(
    val route: String
) {
    data object Home: Screens("home")
    data object Details: Screens(route = "details")
}