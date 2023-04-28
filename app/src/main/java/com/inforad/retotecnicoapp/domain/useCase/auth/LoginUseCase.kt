package com.inforad.retotecnicoapp.domain.useCase.auth

import com.inforad.retotecnicoapp.domain.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String) = repository.login(email, password)
}