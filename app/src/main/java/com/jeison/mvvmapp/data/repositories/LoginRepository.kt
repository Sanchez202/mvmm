package com.jeison.mvvmapp.data.repositories

import com.jeison.mvvmapp.data.model.DataResponse
import com.jeison.mvvmapp.data.model.LoginDTO
import com.jeison.mvvmapp.data.model.LoginService
import com.jeison.mvvmapp.data.model.UserModel
import com.jeison.mvvmapp.data.model.UserProvider

class LoginRepository {

    private val loginService = LoginService()

    suspend fun login(loginDTO: LoginDTO): DataResponse<UserModel> {

        val response = loginService.login(loginDTO)

        if (response.status == "success") {
            UserProvider.user = response.data
        }

        return response
    }
}
