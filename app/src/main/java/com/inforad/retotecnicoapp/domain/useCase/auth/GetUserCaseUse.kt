package com.inforad.retotecnicoapp.domain.useCase.auth

import com.inforad.retotecnicoapp.domain.repository.AuthRepository

class GetUserCaseUse(private val repository: AuthRepository) {
    suspend operator fun invoke() = repository.getUser()
}