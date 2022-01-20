package com.test

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupGraph(
    navController: NavHostController,
    viewModel: MainViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Destinations.EntryScreen.route
    ) {
        composable(Destinations.EntryScreen.route) {
            EntryScreen(viewModel)
        }
        composable(Destinations.MiddleScreen.route) {
            MiddleScreen(viewModel)
        }
        composable(Destinations.ExitScreen.route) {
            ExitScreen(viewModel)
        }
    }
}


sealed class Destinations(val route: String) {
    object EntryScreen : Destinations("route_entry_screen")
    object MiddleScreen : Destinations("route_middle_screen")
    object ExitScreen : Destinations("route_exit_screen")
}