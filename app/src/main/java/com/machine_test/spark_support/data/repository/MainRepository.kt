package com.machine_test.spark_support.data.repository

import com.machine_test.spark_support.data.datastore.RemoteDataSource
import com.machine_test.spark_support.model.LoginBody
import com.machine_test.spark_support.model.SignUpBody

class MainRepository (private val remoteDataSource: RemoteDataSource){
    fun login(loginBody: LoginBody) = remoteDataSource.register(loginBody   )
    fun signUp(signUpBody: SignUpBody) = remoteDataSource.signUp(signUpBody )
}