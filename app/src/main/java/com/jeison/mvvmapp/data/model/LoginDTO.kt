package com.jeison.mvvmapp.data.model

import com.google.gson.annotations.SerializedName

data class LoginDTO(
    @SerializedName("username") val username: String,
    @SerializedName("password") val password: String
)
