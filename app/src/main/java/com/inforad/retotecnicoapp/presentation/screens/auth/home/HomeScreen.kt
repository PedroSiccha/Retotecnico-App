package com.inforad.retotecnicoapp.presentation.screens.auth.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.inforad.retotecnicoapp.presentation.screens.auth.home.components.GetUsers

@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold() { paddingValues ->
        GetUsers(paddingValues)
    }

}