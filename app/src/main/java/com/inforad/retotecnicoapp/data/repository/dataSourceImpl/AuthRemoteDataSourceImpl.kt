package com.inforad.retotecnicoapp.data.repository.dataSourceImpl

import com.inforad.retotecnicoapp.data.repository.dataSource.AuthRemoteDataSource
import com.inforad.retotecnicoapp.data.service.AuthService
import com.inforad.retotecnicoapp.domain.model.User
import com.inforad.retotecnicoapp.domain.model.UsersResponse
import retrofit2.Response

class AuthRemoteDataSourceImpl(private val authService: AuthService): AuthRemoteDataSource {
    override suspend fun getUsers(): Response<UsersResponse> = authService.getUsers()
    override suspend fun login(email: String, password: String) = authService.login(email, password)
    override suspend fun register(user: User): Response<User> = authService.register(user)
}