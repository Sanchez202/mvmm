package com.jeison.mvvmapp.data.model

import com.jeison.mvvmapp.core.RetrofitHelper
import com.jeison.mvvmapp.data.network.LoginApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginService {

    private val retrofitTwo= RetrofitHelper.getRetrofitTWO()

    suspend fun login(loginDTO: LoginDTO):DataResponse<UserModel>{


        return withContext(Dispatchers.IO){
            val response= retrofitTwo.create(LoginApiClient::class.java).login(loginDTO)
            response.body() ?:
            DataResponse(UserModel(""," ")," error","error")
        }
    }
}