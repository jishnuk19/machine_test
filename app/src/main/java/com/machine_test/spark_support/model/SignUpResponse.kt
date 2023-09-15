package com.machine_test.spark_support.model


import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("email")
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("username")
    val username: String
)