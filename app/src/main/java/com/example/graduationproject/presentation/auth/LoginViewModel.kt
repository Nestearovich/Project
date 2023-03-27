package com.example.androidproject.presentation.auths

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.graduationproject.R
import com.example.graduationproject.domain.auth.AuthInteractor
import com.example.graduationproject.utils.InternetConnection

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authInteractor: AuthInteractor,
    private val context: Context
): ViewModel() {


    private val _navigation = MutableLiveData<Int?>()
    val navigation: LiveData<Int?> = _navigation

    private val _error = MutableLiveData<Int>()
    val error: LiveData<Int> = _error

    private val _loginState = MutableLiveData<LoginState>()
    val loginState: LiveData<LoginState> = _loginState

    private lateinit var check: InternetConnection

    fun loginUser(userName: String, userPassword: String) {
        check = InternetConnection(context)

        val coroutineExceptionHandler = CoroutineExceptionHandler{_, exseption ->
            Log.w("exceptionHandler" , exseption.toString())
        }

        viewModelScope.launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler) {
            try {
                launch {
                    if (check.isOnline()){
                        authInteractor.loginUser(userName, userPassword)
                        _navigation.value = R.navigation.nav_graph
                    }else{
                        _error.value = R.string.errorInternet
                    }
                }
            } catch (e: Exception) {
                _error.value = R.string.error_login_user
            }
        }
    }
    fun validateCredentials(username: String, password: String) {
        if (!isValidUsername(username)) {
            _loginState.value = LoginState.Error(R.string.invalid_username)
        } else if (!isValidPassword(password)) {
            _loginState.value = LoginState.Error(R.string.invalid_password)
        } else {
            _loginState.value = LoginState.Success
        }
    }

    private fun isValidUsername(username: String): Boolean {
        return !(username.isEmpty() || username.length > 10 || username.length < 3)
    }

    private fun isValidPassword(password: String): Boolean {
        return !(password.isEmpty() || password.length > 10 || password.length < 6)
    }

    fun userNavigated(){
        _navigation.value = null
    }
}


sealed class LoginState {
    object Success : LoginState()
    data class Error(val messageResId: Int) : LoginState()
}
