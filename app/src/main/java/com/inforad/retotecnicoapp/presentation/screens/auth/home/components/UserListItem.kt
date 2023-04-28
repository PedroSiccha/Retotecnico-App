package com.inforad.retotecnicoapp.presentation.screens.auth.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.inforad.retotecnicoapp.domain.model.User
import com.inforad.retotecnicoapp.presentation.theme.ColorTextAction

@Composable
fun UserListItem(user: User) {
    Column (
        Modifier.padding(start = 20.dp, end = 20.dp, top = 15.dp)
            ) {
        Row() {
            AsyncImage(
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(20.dp)),
                model = user.avatar,
                contentDescription = ""
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column() {
                Text(
                    text = "${ user.first_name } ${ user.last_name }",
                    color = Color.Gray,
                    fontSize = 17.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "${ user.email }",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
        }
        Divider(
            color = Color.LightGray,
            startIndent = 30.dp
        )
    }

}