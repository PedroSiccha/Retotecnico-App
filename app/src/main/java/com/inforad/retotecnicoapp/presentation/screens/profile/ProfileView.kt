package com.inforad.retotecnicoapp.presentation.screens.profile

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.inforad.retotecnicoapp.presentation.components.DefaultTopBar
import com.inforad.retotecnicoapp.presentation.screens.profile.components.ProfileContent

@Composable
fun ProfileView(navController: NavHostController, userParam: String) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Mi Perfil",
                navController = navController,
                upAvailable = true
            )

        }
    ) { paddingValues ->
        ProfileContent(paddingValues = paddingValues, navController)
    }
}