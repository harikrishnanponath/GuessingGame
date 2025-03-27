package com.harikrish.guessnumber.model

data class GameState(
    val userNumber: String = "",
    val noOfGuessLeft: Int = 5,
    val guessNumberList: List<Int> = emptyList(),
    val mysteryNumber: Int = (1..99).random(),
    val hintText: String = "Guess\nthe mystery number between \n0 and 100.",
    val gameStage: GameStage = GameStage.PLAYING

)

enum class GameStage{
    WON,
    LOSE,
    PLAYING
}
