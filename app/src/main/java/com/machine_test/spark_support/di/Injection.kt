package com.machine_test.spark_support.di

import android.content.Context
import com.machine_test.spark_support.data.api.ApiConfig
import com.machine_test.spark_support.data.datastore.RemoteDataSource
import com.machine_test.spark_support.data.repository.MainRepository

object Injection {
    fun provideRepository(context: Context): MainRepository {
        val apiServices = ApiConfig.getApiService()
        val remoteDataSource = RemoteDataSource(apiServices)
        return MainRepository(remoteDataSource)
    }
}