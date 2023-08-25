package com.inforad.retotecnicoapp.presentation.screens.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.inforad.retotecnicoapp.domain.model.User
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    var state by mutableStateOf(ProfileState())
        private set

    val data = savedStateHandle.get<String>("user")
    var user = User.fromJson(data!!)

    init {
        state = state.copy(
            email = user.email!!,
            first_name = user.first_name,
            last_name = user.last_name!!,
            avatar = user.avatar.toString()!!
        )
    }

}