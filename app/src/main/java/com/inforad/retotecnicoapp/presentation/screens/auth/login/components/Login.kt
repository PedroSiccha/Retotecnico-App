package com.inforad.retotecnicoapp.presentation.screens.auth.login.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.inforad.retotecnicoapp.R
import com.inforad.retotecnicoapp.domain.util.Response
import com.inforad.retotecnicoapp.presentation.navigation.screen.AuthScreen
import com.inforad.retotecnicoapp.presentation.screens.auth.login.LoginViewModel

@Composable
fun Login(navController: NavHostController, vm: LoginViewModel = hiltViewModel()) {
    when(val response = vm.loginResponse) {
        Response.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is Response.Success -> {
            LaunchedEffect(Unit) {
                navController.navigate(route = AuthScreen.Home.route)
            }
        }
        is Response.Failure -> {
            Toast.makeText(LocalContext.current, response.exception?.message?: stringResource(R.string.error_desconocido), Toast.LENGTH_SHORT).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, stringResource(R.string.hubo_un_error_desconocido), Toast.LENGTH_SHORT).show()
            }
        }
    }
}