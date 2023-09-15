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
import com.machine_test.spark_support.model.SignUpBody
import com.machine_test.spark_support.model.SignUpResponse
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpViewModel(private val repository: MainRepository): ViewModel() {
    private val _toastMessage = MutableLiveData<String>()
    val toastMessage: LiveData<String>
        get() = _toastMessage
    fun signUp(signUpBody: SignUpBody) = viewModelScope.launch {
        Log.d("hasillog", signUpBody.toString())
        repository.signUp(signUpBody).collect {
            it.enqueue(object : Callback<SignUpResponse> {
                override fun onResponse(
                    call: Call<SignUpResponse>,
                    response: Response<SignUpResponse>
                ) {

                    _toastMessage.postValue(response.message())
                }

                override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                    _toastMessage.postValue("Network Error")
                }
            })
        }
    }
    // Function to show a toast message
    private fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}