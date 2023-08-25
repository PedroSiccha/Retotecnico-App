package com.inforad.retotecnicoapp.presentation.screens.auth.login.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.inforad.retotecnicoapp.R
import com.inforad.retotecnicoapp.presentation.components.*
import com.inforad.retotecnicoapp.presentation.navigation.screen.AuthScreen
import com.inforad.retotecnicoapp.presentation.screens.auth.login.LoginViewModel
import com.inforad.retotecnicoapp.presentation.theme.*

@Composable
fun LoginContent(navController: NavHostController, paddingValues: PaddingValues, vm: LoginViewModel = hiltViewModel()){

    val state = vm.state
    val context = LocalContext.current
    LaunchedEffect(key1 = vm.errorMessage) {
        if (vm.errorMessage != "") {
            Toast.makeText(context, vm.errorMessage, Toast.LENGTH_LONG).show()
        }
    }

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
                "Hi!",
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
                        Spacer(modifier = Modifier.height(16.dp))
                        DefaultTextField(
                            modifier = Modifier.alpha(1f),
                            value = state.email,
                            onValueChange = {text ->
                                vm.onEmailInput(text, context)
                            },
                            placeholder = stringResource(R.string.email),
                            keyboardType = KeyboardType.Email
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        PrincipalButton(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 3.dp)
                                .height(48.dp),
                            onClick = {
                                vm.validateForm()
                                navController.navigate(route = AuthScreen.Password.route)
                            },
                            text = stringResource(R.string.continuar)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        SimpleText(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 3.dp),
                            text = stringResource(R.string.or),
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Center,
                            color = ColorText
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        SecundaryButton(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp)
                                .padding(bottom = 3.dp),
                            onClick = {

                            },
                            text = stringResource(R.string.continue_with_facebook),
                            color = ColorButtonSecundary,
                            imagen = R.drawable.facebook
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        SecundaryButton(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp)
                                .padding(bottom = 3.dp),
                            onClick = {},
                            text = stringResource(R.string.continue_with_google),
                            color = ColorButtonSecundary,
                            imagen = R.drawable.google
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        SecundaryButton(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp)
                                .padding(bottom = 3.dp),
                            onClick = {},
                            text = stringResource(R.string.continue_with_apple),
                            color = ColorButtonSecundary,
                            imagen = R.drawable.apple
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        SignUpText(
                            navController = navController,
                            donthavText = stringResource(R.string.don_t_have_an_account),
                            signUpText = stringResource(R.string.sign_up)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        ActionText(
                            modifier = Modifier.padding(bottom = 16.dp),
                            text = stringResource(R.string.forgot_your_password),
                            fontWeight = FontWeight.Bold,
                            navController = navController,
                            route = AuthScreen.Register.route
                        )
                    }
                }
            }
        }
    }
}