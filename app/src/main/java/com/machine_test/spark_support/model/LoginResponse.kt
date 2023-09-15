package com.machine_test.spark_support.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@SerializedName("access")
	val access: String,
	@SerializedName("email")
	val email: String,
	@SerializedName("firstname")
	val firstname: String,
	@SerializedName("lastname")
	val lastname: String,
	@SerializedName("refresh")
	val refresh: String,
	@SerializedName("username")
	val username: String
)

