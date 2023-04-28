package com.inforad.retotecnicoapp.presentation.screens.auth.login

import android.content.Context
import android.preference.PreferenceManager
import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inforad.retotecnicoapp.domain.model.User
import com.inforad.retotecnicoapp.domain.useCase.auth.AuthUseCase
import com.inforad.retotecnicoapp.domain.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    val myString = mutableStateOf("")

    var isValidForm by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf("")
        private set

    var loginResponse by mutableStateOf<Response<User>?>(null)
        private set

    fun login(context: Context) = viewModelScope.launch {
        loginResponse = Response.Loading
        val result = authUseCase.login(readMyString(context), state.password)
        loginResponse = result
        Log.e("LVM", "Response: ${loginResponse}")
    }

    fun onEmailInput(email: String, context: Context) {
        state = state.copy(email = email)
        writeMyString(context, state.email)
    }

    fun readMyString(context: Context): String {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        myString.value = prefs.getString("my_key", "") ?: ""
        return myString.value
    }

    fun writeMyString(context: Context, newValue: String) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.edit().putString("my_key", newValue).apply()
        myString.value = newValue
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }

    fun validateForm() = viewModelScope.launch {

        if (state.email == null || state.email == "") {
            errorMessage = "Por favor ingrese un correo"
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "El email no es valido"
        }

        delay(3000)
        errorMessage = ""
    }

}