package com.machine_test.spark_support.model


import com.google.gson.annotations.SerializedName

data class SignUpBody(



    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("password2")
    val password2: String
)