package com.jeison.mvvmapp.data.model

import com.google.gson.annotations.SerializedName

data class UserModel(

    @SerializedName("name") val name:String,
    @SerializedName("last_Name") val LastName:String,

)
