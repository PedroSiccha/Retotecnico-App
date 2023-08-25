package com.inforad.retotecnicoapp.di

import com.inforad.retotecnicoapp.domain.repository.AuthRepository
import com.inforad.retotecnicoapp.domain.useCase.auth.AuthUseCase
import com.inforad.retotecnicoapp.domain.useCase.auth.GetUserCaseUse
import com.inforad.retotecnicoapp.domain.useCase.auth.LoginUseCase
import com.inforad.retotecnicoapp.domain.useCase.auth.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun  provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase( login = LoginUseCase(authRepository), register = RegisterUseCase(authRepository), getUser = GetUserCaseUse(authRepository))
}