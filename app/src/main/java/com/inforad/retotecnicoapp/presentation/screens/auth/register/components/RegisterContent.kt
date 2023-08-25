package com.inforad.retotecnicoapp.presentation.screens.auth.register.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
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
import com.inforad.retotecnicoapp.presentation.screens.auth.register.RegisterViewModel
import com.inforad.retotecnicoapp.presentation.theme.ColorCard
import com.inforad.retotecnicoapp.presentation.theme.ColorText
import com.inforad.retotecnicoapp.presentation.theme.ColorTextAction

@Composable
fun RegisterContent(navController: NavHostController, paddingValues: PaddingValues, vm: RegisterViewModel = hiltViewModel()) {
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
                stringResource(R.string.sign_up),
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

                        CustomText(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 3.dp),
                            text = "Looks like you don't have an account. \n" +
                                    "Let's create a new account for" +
                                    "\n${vm.readMyString(context)}",
                            textCustom = "${vm.readMyString(context)}",
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Start,
                            color = ColorText,
                            colorCustom = ColorText,
                            fontWeightCustom = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        DefaultTextField(
                            modifier = Modifier.alpha(1f),
                            value = state.name,
                            onValueChange = {text ->
                                vm.onNameInput(text)
                            },
                            placeholder = stringResource(R.string.name),
                            keyboardType = KeyboardType.Text
                        )
                        Spacer(modifier = Modifier.height(8.dp))
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
                        CustomText(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 3.dp),
                            text = stringResource(R.string.by_selecting_agree_and_continue_below_i_agree_to_terms_of_service_and_privacy_policy),
                            textCustom = stringResource(R.string.terms_of_service_and_privacy_policy),
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Start,
                            color = ColorText,
                            colorCustom = ColorTextAction,
                            fontWeightCustom = FontWeight.Normal
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        PrincipalButton(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 3.dp)
                                .height(48.dp),
                            onClick = {
                                      vm.register(context)
                            },
                            text = stringResource(R.string.agree_and_continue)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}