package com.inforad.retotecnicoapp.data.repository.dataSource

import com.inforad.retotecnicoapp.domain.model.User
import com.inforad.retotecnicoapp.domain.model.UsersResponse
import retrofit2.Response

interface AuthRemoteDataSource {
    suspend fun getUsers(): Response<UsersResponse>
    suspend fun login(email: String, password: String): Response<User>
    suspend fun register(user: User): Response<User>
}