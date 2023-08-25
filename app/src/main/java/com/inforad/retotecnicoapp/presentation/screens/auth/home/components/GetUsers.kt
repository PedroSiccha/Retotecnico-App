package com.inforad.retotecnicoapp.presentation.screens.auth.home.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.inforad.retotecnicoapp.domain.util.Response
import com.inforad.retotecnicoapp.presentation.screens.auth.home.HomeViewModel

@Composable
fun GetUsers(navController: NavHostController, paddingValues: PaddingValues, vm: HomeViewModel = hiltViewModel()) {
    when(val response = vm.userResponse) {
        Response.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is Response.Success -> {
            UserListContent(paddingValues = paddingValues, user = response.data.data, navController)
        }
        is Response.Failure -> {
            Toast.makeText(LocalContext.current, response.exception.message, Toast.LENGTH_SHORT).show()
        }
        else -> {

        }
    }
}