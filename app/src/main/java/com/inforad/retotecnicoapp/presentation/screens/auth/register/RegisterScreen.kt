package com.inforad.retotecnicoapp.presentation.screens.auth.register


import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.inforad.retotecnicoapp.presentation.screens.auth.register.components.RegisterContent
import com.inforad.retotecnicoapp.presentation.theme.RetotecnicoAppTheme
import androidx.compose.ui.graphics.Color

@Composable
fun RegisterScreen(navController: NavHostController) {
    Scaffold(
        /*
        topBar = {
            TopAppBar(
                title = {},
                backgroundColor = Color.Transparent,
                contentColor = MaterialTheme.colors.onSurface,
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "",
                            tint = Color.White
                        )
                    }
                }
            )
        }

         */
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