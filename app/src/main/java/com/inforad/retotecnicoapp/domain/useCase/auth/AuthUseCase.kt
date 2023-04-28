package com.inforad.retotecnicoapp.domain.useCase.auth

data class AuthUseCase(
    val login: LoginUseCase,
    val register: RegisterUseCase,
    val getUser: GetUserCaseUse
)
