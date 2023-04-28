package com.inforad.retotecnicoapp.presentation.screens.auth.register

import android.content.Context
import android.preference.PreferenceManager
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inforad.retotecnicoapp.domain.model.User
import com.inforad.retotecnicoapp.domain.useCase.auth.AuthUseCase
import com.inforad.retotecnicoapp.domain.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel() {
    var state by mutableStateOf(RegisterState())

    val myString = mutableStateOf("")

    var registerReponse by mutableStateOf<Response<User>?>(null)

    fun register(context: Context) = viewModelScope.launch {
        val user = User(
            email = readMyString(context),
            first_name = state.name,
            password = state.password

        )
        registerReponse = Response.Loading
        val result = authUseCase.register(user)
        registerReponse = result
    }

    fun onNameInput(input: String) {
        state = state.copy(name = input)
    }

    fun onEmailInput(input: String) {
        state = state.copy(email = input)
    }

    fun onPasswordInput(input: String) {
        state = state.copy(password = input)
    }

    fun readMyString(context: Context): String {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        myString.value = prefs.getString("my_key", "") ?: ""
        return myString.value
    }
}