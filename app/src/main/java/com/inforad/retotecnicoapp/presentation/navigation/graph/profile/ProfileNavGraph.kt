package com.inforad.retotecnicoapp.presentation.navigation.graph.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.inforad.retotecnicoapp.presentation.navigation.Graph
import com.inforad.retotecnicoapp.presentation.navigation.screen.profile.ProfileScreen
import com.inforad.retotecnicoapp.presentation.screens.profile.ProfileView

fun NavGraphBuilder.ProfileNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.PROFILE + "/{user}",
        startDestination = ProfileScreen.ProfileDetalle.route
    ) {
        composable(
            route = ProfileScreen.ProfileDetalle.route,
            arguments = listOf(navArgument("user") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("user")?.let {data ->
                ProfileView(navController, userParam = data)
            }
        }
    }
}