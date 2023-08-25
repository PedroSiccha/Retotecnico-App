package com.inforad.retotecnicoapp.presentation.navigation.screen.profile

sealed class ProfileScreen(val route: String) {
    object ProfileDetalle: ProfileScreen("profile/detalle")
}