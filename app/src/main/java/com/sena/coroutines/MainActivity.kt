package com.sena.coroutines

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.sena.coroutines.DataProvider.Texto
import com.sena.coroutines.ui.theme.CoroutinesTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoroutinesTheme {
                lifecycleScope.launch {
                    var result = withContext(Dispatchers.IO) { DataProvider.doHeavyTask(); }
                    println(result)
                }
                Texto()
            }
        }
    }
}
