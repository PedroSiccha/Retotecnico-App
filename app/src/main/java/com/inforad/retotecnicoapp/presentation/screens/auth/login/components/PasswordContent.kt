package com.inforad.retotecnicoapp.presentation.screens.auth.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.inforad.retotecnicoapp.R
import com.inforad.retotecnicoapp.presentation.components.*
import com.inforad.retotecnicoapp.presentation.navigation.screen.AuthScreen
import com.inforad.retotecnicoapp.presentation.screens.auth.login.LoginViewModel
import com.inforad.retotecnicoapp.presentation.theme.ColorCard

@Composable
fun PasswordContent(navController: NavHostController, paddingValues: PaddingValues, vm: LoginViewModel = hiltViewModel()) {

    val state = vm.state
    val context = LocalContext.current

    Box(modifier = Modifier
        .padding(paddingValues = paddingValues)
        .fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.fondoreto),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TitleText(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 10.dp),
                text =
                stringResource(R.string.log_in),
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .height(450.dp)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentHeight()
                        .align(Alignment.BottomCenter),
                    shape = RoundedCornerShape(
                        10.dp
                    ),
                    backgroundColor = ColorCard.copy(alpha = 0.7f)
                ) {
                    Column(
                        modifier = Modifier.padding(horizontal = 20.dp)
                    ) {
                        UserView(
                            modifier = Modifier.fillMaxWidth().padding(8.dp),
                            imgUser = R.drawable.usuario,
                            nameUser = stringResource(R.string.jane_dow),
                            email = vm.readMyString(context)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        DefaultTextField(
                            modifier = Modifier.alpha(1f),
                            value = state.password,
                            onValueChange = { text ->
                                vm.onPasswordInput(text)
                            },
                            placeholder = stringResource(R.string.password),
                            keyboardType = KeyboardType.Password,
                            hideText = true
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        PrincipalButton(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 3.dp)
                                .height(48.dp),
                            onClick = {
                                      vm.login(context)
                            },
                            text = stringResource(R.string.continuar)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        ActionText(
                            modifier = Modifier.padding(bottom = 16.dp),
                            text = stringResource(R.string.forgot_your_password),
                            fontWeight = FontWeight.Bold,
                            navController = navController,
                            route = AuthScreen.Register.route
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}