package com.inforad.retotecnicoapp.presentation.screens.profile.components

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.inforad.retotecnicoapp.R
import com.inforad.retotecnicoapp.presentation.MainActivity
import com.inforad.retotecnicoapp.presentation.screens.profile.ProfileViewModel

@Composable
fun ProfileContent(paddingValues: PaddingValues, navController: NavHostController, vm: ProfileViewModel = hiltViewModel()) {
    val activity = LocalContext.current as? Activity
    val state = vm.state

    Box(modifier = Modifier
        .padding(paddingValues = paddingValues)
        .padding(bottom = 55.dp)) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.fondoreto),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToScale(0.5f, 0.5f, 0.5f, 1f) }
            )
        )

        Column(
            modifier = Modifier
                .background(color = Color.Gray)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                RoundedCornerShape(bottomEnd = 30.dp, bottomStart = 30.dp),
                backgroundColor = Color.White,
                elevation = 5.dp
            ) {
                ConstraintLayout(
                    modifier = Modifier
                        .padding(10.dp, bottom = 20.dp)
                        .background(color = Color.White)
                ) {
                    val (imgProfile, txtMyProfile, txtUserName, txtBio, rowNumbers) = createRefs()
                    Text(
                        text = "Mi Perfil",
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .constrainAs(txtMyProfile) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                            }
                            .padding(start = 15.dp, bottom = 20.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = Color.DarkGray
                    )

                    Image(
                        painter = painterResource(id = R.drawable.usuario),
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .height(120.dp)
                            .width(120.dp)
                            .constrainAs(imgProfile) {
                                top.linkTo(txtMyProfile.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            },
                        contentDescription = "Imagen", contentScale = ContentScale.Crop
                    )

                    Text(
                        text = "${vm.user?.email}",
                        modifier = Modifier
                            .constrainAs(txtUserName) {
                                top.linkTo(imgProfile.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                            .padding(top = 15.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.DarkGray
                    )

                    Text(
                        text = "${vm.user?.first_name} ${vm.user?.last_name}",
                        modifier = Modifier
                            .padding(start = 5.dp, end = 5.dp)
                            .constrainAs(txtBio) {
                                top.linkTo(txtUserName.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                            .alpha(0.7f)
                            .padding(top = 15.dp, start = 20.dp, end = 20.dp),
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
                        lineHeight = 23.sp,
                        letterSpacing = 1.sp,
                        color = Color.DarkGray
                    )
                }
            }
            IconButton(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 15.dp, top = 15.dp),
                onClick = {
                    activity?.finish()
                    activity?.startActivity(Intent(activity, MainActivity::class.java))
                }
            ) {
                Icon(
                    modifier = Modifier.size(35.dp),
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = "",
                    tint = Color.White
                )
            }
            AsyncImage(
                modifier = Modifier
                    .size(250.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally),
                model = vm.user.avatar,
                contentDescription = ""
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }


}