package com.inforad.retotecnicoapp.presentation.screens.auth.home.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.inforad.retotecnicoapp.domain.model.User

@Composable
fun UserListContent(paddingValues: PaddingValues, user: List<User>, navController: NavHostController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(paddingValues = paddingValues)
    ) {
        items(
            items = user
        ) { user ->
            UserListItem(user = user, navController)
        }
    }
}