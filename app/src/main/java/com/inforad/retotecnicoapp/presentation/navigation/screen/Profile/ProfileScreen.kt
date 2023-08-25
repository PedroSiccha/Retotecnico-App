package com.inforad.retotecnicoapp.presentation.navigation.screen.Profile

sealed class ProfileScreen(val route: String) {
    object ProfileDetalle: ProfileScreen("profile/detalle")
}