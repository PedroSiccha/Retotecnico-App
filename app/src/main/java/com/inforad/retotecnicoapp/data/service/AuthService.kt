package com.inforad.retotecnicoapp.data.service

import com.inforad.retotecnicoapp.domain.model.User
import com.inforad.retotecnicoapp.domain.model.UsersResponse
import retrofit2.Response
import retrofit2.http.*

interface AuthService {

    @GET("api/users?page=2")
    suspend fun getUsers(): Response<UsersResponse>

    @FormUrlEncoded
    @POST("api/login")
    suspend fun login(
        @Field("email")
        email: String,

        @Field("password")
        password: String
    ): Response<User>

    @POST("api/register")
    suspend fun register(
        @Body()
        user: User
    ): Response<User>


}