package com.inforad.retotecnicoapp.presentation.screens.auth.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inforad.retotecnicoapp.domain.model.UsersResponse
import com.inforad.retotecnicoapp.domain.useCase.auth.AuthUseCase
import com.inforad.retotecnicoapp.domain.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val  userCaseUse: AuthUseCase): ViewModel() {
    var userResponse by mutableStateOf<Response<UsersResponse>?>(null)
        private set
    init {
        getUsers()
    }
    fun getUsers() = viewModelScope.launch {
        userResponse = Response.Loading
        userCaseUse.getUser().collect { data ->
            userResponse = data
        }
    }
}