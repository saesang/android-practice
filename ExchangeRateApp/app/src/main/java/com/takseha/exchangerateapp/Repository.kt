package com.takseha.exchangerateapp

import androidx.lifecycle.viewModelScope
import com.takseha.exchangerateapp.datamodel.ExRates
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.http.Path

class Repository {

    private val client = RetrofitInstance.getInstance().create(MyApi::class.java)

    suspend fun getAllData() = client.getAllData()
}