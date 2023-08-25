package com.inforad.retotecnicoapp.presentation.screens.auth.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.inforad.retotecnicoapp.presentation.components.SimpleText

@Composable
fun UserView(modifier: Modifier, imgUser: Int, nameUser: String, email: String) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .size(60.dp)
                .aspectRatio(1f)
                .clip(CircleShape)
                .padding(top = 8.dp),
            painter = painterResource(id = imgUser),
            contentDescription = ""
        )
        Column(
            modifier = Modifier.padding(5.dp)
        ) {
            SimpleText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 3.dp),
                text = nameUser,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start
            )
            SimpleText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 3.dp),
                text = email,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Start
            )
        }
    }
}