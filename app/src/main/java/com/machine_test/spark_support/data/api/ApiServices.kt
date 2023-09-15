package com.machine_test.spark_support.data.api

import com.machine_test.spark_support.model.LoginBody
import com.machine_test.spark_support.model.LoginResponse
import com.machine_test.spark_support.model.SignUpBody
import com.machine_test.spark_support.model.SignUpResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiServices {
    @Headers("Content-Type: application/json")
    @POST("login/")
    fun login2(
        @Body loginBody : LoginBody
    ): Call<LoginResponse>

    @Headers("Content-Type: application/json")
    @POST("register/")
    fun signUp(
        @Body signUpBody: SignUpBody
    ): Call<SignUpResponse>


}
