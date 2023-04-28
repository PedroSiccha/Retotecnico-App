package com.inforad.retotecnicoapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.inforad.retotecnicoapp.presentation.navigation.screen.AuthScreen
import com.inforad.retotecnicoapp.presentation.theme.ColorTextAction

@Composable
fun ActionText(
    modifier: Modifier,
    text: String,
    fontWeight: FontWeight,
    color: Color = ColorTextAction,
    navController: NavHostController,
    route: String
) {
    Text(
        modifier = modifier.clickable { navController.navigate(route = route) },
        text = text,
        fontWeight = fontWeight,
        color = color
    )
}