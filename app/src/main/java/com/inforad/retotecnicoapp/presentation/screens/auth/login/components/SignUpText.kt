package com.inforad.retotecnicoapp.presentation.screens.auth.login.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.inforad.retotecnicoapp.presentation.components.ActionText
import com.inforad.retotecnicoapp.presentation.components.SimpleText
import com.inforad.retotecnicoapp.presentation.navigation.screen.AuthScreen
import com.inforad.retotecnicoapp.presentation.theme.ColorText

@Composable
fun SignUpText(navController: NavHostController, donthavText: String, signUpText: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        SimpleText(
            modifier = Modifier.padding(bottom = 3.dp),
            text = donthavText,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            color = ColorText
        )
        ActionText(
            modifier = Modifier.padding(bottom = 3.dp, start = 5.dp),
            text = signUpText,
            fontWeight = FontWeight.Bold,
            navController = navController,
            route = AuthScreen.Register.route
        )
    }
}