package com.example.graduationproject.domain.auth

import com.example.graduationproject.model.UserModel

interface AuthRepository {
    suspend fun  loginUser(userName: String, userPassword: String)

    suspend fun showUserCreds(): UserModel

    suspend fun doesUserExist(): Boolean

    suspend fun userLogout()
}