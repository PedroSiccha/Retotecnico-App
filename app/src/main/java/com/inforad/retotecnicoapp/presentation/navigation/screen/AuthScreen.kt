package com.inforad.retotecnicoapp.presentation.navigation.screen

sealed class AuthScreen(val route: String, param: String = "") {
    object Login: AuthScreen("login")
    object Password: AuthScreen("password")
    object Register: AuthScreen("register")
    object Home: AuthScreen("home")
}
