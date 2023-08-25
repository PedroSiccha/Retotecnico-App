package com.inforad.retotecnicoapp.di

import com.inforad.retotecnicoapp.data.repository.AuthRepositoryImpl
import com.inforad.retotecnicoapp.data.repository.dataSource.AuthRemoteDataSource
import com.inforad.retotecnicoapp.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun  provideAuthRepository(authRemoteDataSource: AuthRemoteDataSource): AuthRepository = AuthRepositoryImpl(authRemoteDataSource)
}