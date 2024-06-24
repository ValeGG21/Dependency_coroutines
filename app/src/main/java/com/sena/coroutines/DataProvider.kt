package com.sena.coroutines

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import android.util.Log

object DataProvider {
    @Composable
    fun Texto() {
        Text(text = "Holis")
    }

    fun doHeavyTask(): Int {
        Log.d("DataProvider", "doHeavyTask called")
        Thread.sleep(200)
        return 100
    }
}
