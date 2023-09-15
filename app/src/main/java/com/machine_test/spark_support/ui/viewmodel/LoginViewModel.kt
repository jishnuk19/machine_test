package com.machine_test.spark_support.ui.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.machine_test.spark_support.data.repository.MainRepository
import com.machine_test.spark_support.model.LoginBody
import com.machine_test.spark_support.model.LoginResponse
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel(private val repository: MainRepository):ViewModel() {
    private val _toastMessage = MutableLiveData<String>()
    val toastMessage: LiveData<String>
        get() = _toastMessage
    fun Login(loginBody: LoginBody) = viewModelScope.launch {

        repository.login(loginBody).collect{
            it.enqueue(object : Callback<LoginResponse> {
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    _toastMessage.postValue(response.message())
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    _toastMessage.postValue("Network Error")
                }
            })
        }
    }


}