package com.machine_test.spark_support.model

import com.google.gson.annotations.SerializedName

data class LoginBody(
	@SerializedName("username")
	val username: String,
	@SerializedName("password")
	val password: String,
)
