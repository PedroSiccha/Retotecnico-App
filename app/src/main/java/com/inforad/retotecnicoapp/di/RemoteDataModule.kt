package com.inforad.retotecnicoapp.di

import com.inforad.retotecnicoapp.data.repository.dataSource.AuthRemoteDataSource
import com.inforad.retotecnicoapp.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.inforad.retotecnicoapp.data.service.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {
    @Provides
    fun  provideAuthRemoteDataSource(authService: AuthService): AuthRemoteDataSource = AuthRemoteDataSourceImpl(authService)
}