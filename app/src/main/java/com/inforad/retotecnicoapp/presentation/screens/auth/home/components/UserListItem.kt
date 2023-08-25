package com.inforad.retotecnicoapp.presentation.screens.auth.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.inforad.retotecnicoapp.domain.model.User
import com.inforad.retotecnicoapp.R
import com.inforad.retotecnicoapp.presentation.navigation.Graph

@Composable
fun UserListItem(user: User, navController: NavHostController) {
    Column (
        Modifier
            .padding(
                start = 20.dp,
                end = 20.dp,
                top = 15.dp
            )
            .clickable {
                navController.navigate(route = "${Graph.PROFILE}/${user?.toJson()}")
            }

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .padding(5.dp),
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
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.next),
                modifier = Modifier
                    .size(20.dp),
                contentDescription = ""
            )
        }
        Divider(
            color = Color.LightGray,
            startIndent = 30.dp
        )
    }

}