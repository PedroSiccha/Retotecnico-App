package com.inforad.retotecnicoapp.presentation.screens.auth.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.inforad.retotecnicoapp.presentation.components.DefaultTopBar
import com.inforad.retotecnicoapp.presentation.screens.auth.home.components.GetUsers

@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Lista de Usuarios",
                navController = navController,
                upAvailable = false
            )
        }
    ) { paddingValues ->
        GetUsers(navController, paddingValues)
    }

}