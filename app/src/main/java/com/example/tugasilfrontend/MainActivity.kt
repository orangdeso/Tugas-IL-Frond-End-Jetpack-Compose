package com.example.tugasilfrontend

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.tugasilfrontend.navigation.Navigation
import com.example.tugasilfrontend.ui.theme.TugasInfiniteLearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TugasInfiniteLearningTheme {
                Navigation()
            }
        }
    }
}
