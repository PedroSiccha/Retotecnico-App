package com.inforad.retotecnicoapp.presentation.screens.auth.register


import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.inforad.retotecnicoapp.presentation.screens.auth.register.components.RegisterContent
import com.inforad.retotecnicoapp.presentation.theme.RetotecnicoAppTheme

@Composable
fun RegisterScreen(navController: NavHostController) {
    Scaffold(
    ) { paddingValues ->
        RegisterContent(navController = navController, paddingValues = paddingValues)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PasswordScreenPreview() {
    RetotecnicoAppTheme {
        RegisterScreen(rememberNavController())
    }
}