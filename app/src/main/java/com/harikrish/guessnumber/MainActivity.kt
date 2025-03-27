package com.harikrish.guessnumber

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.harikrish.guessnumber.ui.theme.GuessNumberTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GuessNumberTheme {
                val viewModel = viewModel<MainViewModel>()
                GuessingGameScreen(viewModel)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GuessNumberTheme {
        val viewModel = viewModel<MainViewModel>()
        GuessingGameScreen(viewModel)
    }
}