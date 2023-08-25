package com.inforad.retotecnicoapp.domain.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class User(
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("email")
    val email: String,

    @SerializedName("first_name")
    val first_name: String,

    @SerializedName("last_name")
    val last_name: String? = null,

    @SerializedName("avatar")
    val avatar: String? = null,

    @SerializedName("token")
    val token: String? = null,

    @SerializedName("password")
    val password: String? = null
): Serializable {
//    fun toJSon(): String = Gson().toJson(this)
    fun toJson(): String = Gson().toJson(
        User(
            id,
            email,
            first_name,
            last_name,
            if (!avatar.isNullOrBlank()) URLEncoder.encode(avatar, StandardCharsets.UTF_8.toString()) else "",
            token,
            password
        )
    )
    companion object {
        fun fromJson(data: String): User = Gson().fromJson(data, User::class.java)
    }
}
