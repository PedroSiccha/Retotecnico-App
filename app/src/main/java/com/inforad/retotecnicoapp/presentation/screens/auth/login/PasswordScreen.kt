package com.inforad.retotecnicoapp.presentation.screens.auth.login

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.inforad.retotecnicoapp.presentation.screens.auth.login.components.PasswordContent
import com.inforad.retotecnicoapp.presentation.screens.auth.login.components.Login
import com.inforad.retotecnicoapp.presentation.theme.RetotecnicoAppTheme

@Composable
fun PasswordScreen(navController: NavHostController) {
    Scaffold(
    ) { paddingValues ->
        PasswordContent(navController = navController, paddingValues = paddingValues)
    }
    Login(navController = navController)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PasswordScreenPreview() {
    RetotecnicoAppTheme {
        PasswordScreen(rememberNavController())
    }
}