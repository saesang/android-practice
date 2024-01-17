package com.takseha.exchangerateapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.takseha.exchangerateapp.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = Repository()

    private var _mutableWord1 = MutableLiveData<String>()
    val liveWord1 : LiveData<String>
        get() = _mutableWord1

    private var _mutableWord2 = MutableLiveData<String>()
    val liveWord2 : LiveData<String>
        get() = _mutableWord2

    private var _mutableWord3 = MutableLiveData<String>()
    val liveWord3 : LiveData<String>
        get() = _mutableWord3

    private var _mutableWord4 = MutableLiveData<String>()
    val liveWord4 : LiveData<String>
        get() = _mutableWord4

    fun getRatesData() = viewModelScope.launch {
        val baseCode = repository.getAllData().base_code
        val updateDate = repository.getAllData().time_last_update_utc
        val KRW = repository.getAllData().rates.get("KRW").asString

        _mutableWord1.value = baseCode
        _mutableWord2.value = updateDate.substring(0, updateDate.length - 5)
        _mutableWord3.value = KRW
    }

    fun getCountryRate(code: String) = viewModelScope.launch {
        val countryRate = repository.getAllData().rates.get(code).asString

        _mutableWord4.value = countryRate
    }
}