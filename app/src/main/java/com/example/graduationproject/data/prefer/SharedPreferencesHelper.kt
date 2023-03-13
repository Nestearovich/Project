package com.example.graduationproject.data.prefer

import android.content.SharedPreferences
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
}