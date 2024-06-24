package com.sena.coroutines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import android.util.Log

class MainViewModel : ViewModel() {
    fun doSomething() {
        viewModelScope.launch {
            Log.d("MainViewModel", "doSomething called")
            val result = withContext(Dispatchers.IO) { DataProvider.doHeavyTask() }
            println(result)
            Log.d("MainViewModel", "Result: $result")
        }
    }
}
