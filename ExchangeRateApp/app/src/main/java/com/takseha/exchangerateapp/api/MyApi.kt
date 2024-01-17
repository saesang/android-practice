package com.takseha.exchangerateapp.api

import com.takseha.exchangerateapp.datamodel.ExRates
import retrofit2.http.GET

interface MyApi {

    @GET("v6/latest")
    suspend fun getAllData() : ExRates
}