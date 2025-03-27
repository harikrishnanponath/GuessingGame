package com.harikrish.guessnumber

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.harikrish.guessnumber.model.GameStage
import com.harikrish.guessnumber.model.GameState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class MainViewModel : ViewModel() {

    private val _state = MutableStateFlow(GameState())
    val state = _state.asStateFlow()

    fun updateTextField(userNo: String) {
        _state.update { it.copy(userNumber = userNo) }
    }

    fun resetGame(){
       _state.value = GameState()
    }

    fun onUserInput(
        userNumber: String,
        context: Context
    ) {
        val userNumberInInt = try {
            userNumber.toInt()
        } catch (e: Exception) {
            0
        }

        if (userNumberInInt !in 1..99) {
            Toast.makeText(
                context,
                "Please enter a value between 0 and 100",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        val currentState = _state.value
        val newGuessLeft = currentState.noOfGuessLeft - 1
        val newGuessList = currentState.guessNumberList.plus(userNumberInInt)

        val newHintText = when {
            userNumberInInt > currentState.mysteryNumber -> {
                "Hint\nYou are guessing bigger number than the mystery number."
            }
            userNumberInInt < currentState.mysteryNumber -> {
                "Hint\nYou are guessing smaller number than the mystery number."
            }
            else -> ""
        }

        val newGameStage = when {
            userNumberInInt == currentState.mysteryNumber -> GameStage.WON
            newGuessLeft == 0 -> GameStage.LOSE
            else -> GameStage.PLAYING
        }

        _state.update {
            it.copy(
                userNumber = "",
                noOfGuessLeft = newGuessLeft,
                guessNumberList = newGuessList,
                hintText = newHintText,
                gameStage = newGameStage
            )
        }
    }
}