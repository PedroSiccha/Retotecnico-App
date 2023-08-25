package com.inforad.retotecnicoapp.data.repository

import com.inforad.retotecnicoapp.data.repository.dataSource.AuthRemoteDataSource
import com.inforad.retotecnicoapp.domain.model.User
import com.inforad.retotecnicoapp.domain.model.UsersResponse
import com.inforad.retotecnicoapp.domain.repository.AuthRepository
import com.inforad.retotecnicoapp.domain.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class AuthRepositoryImpl(private val authRemoteDataSource: AuthRemoteDataSource): AuthRepository {
    override suspend fun login(email: String, password: String): Response<User> {
        return try {
            val result = authRemoteDataSource.login(email, password)
            Response.Success(result.body()!!)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override suspend fun register(user: User): Response<User> {
        return try {
            val result = authRemoteDataSource.register(user)
            Response.Success(result.body()!!)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override fun getUser(): Flow<Response<UsersResponse>> = callbackFlow {
        try {
            val result = authRemoteDataSource.getUsers()
            trySend(Response.Success(result.body()!!)).isSuccess
            close()
        } catch (e: Exception) {
            e.printStackTrace()
            trySend(Response.Failure(e)).isSuccess
            close(e)
        }
    }


}