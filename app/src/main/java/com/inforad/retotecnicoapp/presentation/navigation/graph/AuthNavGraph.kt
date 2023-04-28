package com.inforad.retotecnicoapp.presentation.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.inforad.retotecnicoapp.presentation.navigation.Graph
import com.inforad.retotecnicoapp.presentation.navigation.screen.AuthScreen
import com.inforad.retotecnicoapp.presentation.screens.auth.home.HomeScreen
import com.inforad.retotecnicoapp.presentation.screens.auth.login.LoginScreen
import com.inforad.retotecnicoapp.presentation.screens.auth.login.PasswordScreen
import com.inforad.retotecnicoapp.presentation.screens.auth.register.RegisterScreen

fun NavGraphBuilder.AuhtNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ) {
            composable(route = AuthScreen.Login.route) {
                LoginScreen(navController)
            }

            composable(route = AuthScreen.Password.route) {
                PasswordScreen(navController)
            }

            composable(route = AuthScreen.Register.route) {
                RegisterScreen(navController)
            }

            composable(route = AuthScreen.Home.route) {
                HomeScreen(navController)
            }
        }
}