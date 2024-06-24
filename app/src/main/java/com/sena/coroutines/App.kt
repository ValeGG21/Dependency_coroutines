package com.sena.coroutines

import android.app.Application
import android.util.Log
import kotlinx.coroutines.*

class App : Application() {
    private val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    override fun onCreate() {
        super.onCreate()
        Log.d("App", "onCreate called")
        applicationScope.launch {
            val result = withContext(Dispatchers.IO) { DataProvider.doHeavyTask() }
            println(result)
            Log.d("App", "Result: $result")
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        applicationScope.cancel()  // Cancel the scope to clean up coroutines
        Log.d("App", "onTerminate called and applicationScope cancelled")
    }
}
