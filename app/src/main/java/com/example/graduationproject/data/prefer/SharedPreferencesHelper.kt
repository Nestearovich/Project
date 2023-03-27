package com.example.graduationproject.data.prefer

import android.content.SharedPreferences
import com.example.graduationproject.model.UserModel
import javax.inject.Inject

class SharedPreferencesHelper @Inject constructor(
    private val sharedPreferences: SharedPreferences
){
    fun getLastDate():Long{
        return sharedPreferences.getLong("data_key",0)
    }
    fun updateLastDate(date:Long){
        return sharedPreferences.edit().putLong("data_key", date).apply()
    }

    fun saveUserName(name: String?){
        sharedPreferences.edit().putString(USER_NAME , name).apply()

    }
    fun saveUserPassword(name: String?){
        sharedPreferences.edit().putString(USER_PASSWORD , name).apply()

    }

    fun getUserCreds(): UserModel {
        val name = sharedPreferences.getString(USER_NAME,"") ?: "No user"
        val password = sharedPreferences.getString(USER_PASSWORD, "") ?: "No user"
        return UserModel(name, password)
    }

    fun checkUserExists(): Boolean{
        val name = sharedPreferences.getString(USER_NAME,"") ?: "No user"
        val password = sharedPreferences.getString(USER_PASSWORD, "") ?: "No user"

        return (!name.isNullOrEmpty() && !password.isNullOrEmpty())
    }

    fun removeUser(){
        saveUserName(null)
        saveUserPassword(null)
    }

    companion object{
        private const val USER_NAME = "USER_NAME"
        private const val  USER_PASSWORD = "USER_PASSWORD"
    }
}