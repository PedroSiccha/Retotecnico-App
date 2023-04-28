package com.inforad.retotecnicoapp.domain.useCase.auth

import com.inforad.retotecnicoapp.domain.model.User
import com.inforad.retotecnicoapp.domain.repository.AuthRepository

class RegisterUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(user: User) = repository.register(user)
}