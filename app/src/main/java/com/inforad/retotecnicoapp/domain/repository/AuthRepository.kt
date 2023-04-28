package com.inforad.retotecnicoapp.domain.repository

import com.inforad.retotecnicoapp.domain.model.User
import com.inforad.retotecnicoapp.domain.model.UsersResponse
import com.inforad.retotecnicoapp.domain.util.Response
import kotlinx.coroutines.flow.Flow


interface AuthRepository {
    suspend fun login(email: String, password: String): Response<User>
    suspend fun register(user: User): Response<User>
    fun getUser(): Flow<Response<UsersResponse>>
}