package com.machine_test.spark_support.data.datastore

import android.util.Log
import com.machine_test.spark_support.data.api.ApiServices
import com.machine_test.spark_support.model.LoginBody
import com.machine_test.spark_support.model.SignUpBody
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiServices: ApiServices) {
    fun register(loginBody: LoginBody) = flow {
        emit(apiServices.login2(loginBody))
    }.catch {
        Log.d("login", "login: failed = ${it.message}")
    }.flowOn(Dispatchers.IO)

    fun signUp(signUpBody: SignUpBody) = flow {
        emit(apiServices.signUp(signUpBody))
    }.catch {
        Log.d("login", "login: failed = ${it.message}")
    }.flowOn(Dispatchers.IO)


}