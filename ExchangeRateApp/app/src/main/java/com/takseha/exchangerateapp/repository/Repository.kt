package com.takseha.exchangerateapp.repository

import com.takseha.exchangerateapp.api.MyApi
import com.takseha.exchangerateapp.api.RetrofitInstance

class Repository {

    private val client = RetrofitInstance.getInstance().create(MyApi::class.java)

    suspend fun getAllData() = client.getAllData()
}