package com.inforad.retotecnicoapp.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.inforad.retotecnicoapp.presentation.navigation.Graph
import com.inforad.retotecnicoapp.presentation.navigation.graph.Profile.ProfileNavGraph

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTH
    ) {
        AuhtNavGraph(
            navController = navController
        )

        ProfileNavGraph(navController)
    }
}