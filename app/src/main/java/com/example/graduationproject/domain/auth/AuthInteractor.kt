package com.example.graduationproject.domain.auth

import com.example.graduationproject.model.UserModel
import javax.inject.Inject

class AuthInteractor @Inject constructor (
    private val authRepository: AuthRepository
    ) {
    suspend fun loginUser(userName: String, userPassword: String){
        authRepository.loginUser(userName,userPassword)

    }

    suspend fun getUserCreds(): UserModel {
        return authRepository.showUserCreds()
    }

    suspend fun checkUserExists(): Boolean{
        return authRepository.doesUserExist()
    }

    suspend fun logoutUser(){}
}