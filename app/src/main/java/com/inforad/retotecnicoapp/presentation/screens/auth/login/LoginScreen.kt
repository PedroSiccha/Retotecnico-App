package com.inforad.retotecnicoapp.presentation.screens.auth.login

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.inforad.retotecnicoapp.presentation.screens.auth.login.components.LoginContent
import com.inforad.retotecnicoapp.presentation.theme.RetotecnicoAppTheme

@Composable
fun LoginScreen(navController: NavHostController) {
    Scaffold() { paddingValues ->
        LoginContent(navController = navController, paddingValues)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    RetotecnicoAppTheme {
        LoginScreen(rememberNavController())
    }
}