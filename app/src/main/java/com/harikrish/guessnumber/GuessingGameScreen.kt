package com.harikrish.guessnumber

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.harikrish.guessnumber.ui.theme.BlueDark
import com.harikrish.guessnumber.ui.theme.YellowDark


@Composable
fun GuessingGameScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BlueDark)
            .padding(16.dp)
    ) {
        Text(
            text = buildAnnotatedString {
                append("Guess left: ")
                withStyle(style = SpanStyle(color = Color.White)) {
                    append("5")
                }
            },
            color = YellowDark,
            fontSize = 18.sp
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            listOf(25, 36, 96, 46).forEach { number ->
                Text(
                    text = "$number",
                    color = YellowDark,
                    fontSize = 42.sp,
                    modifier = Modifier.padding(end = 16.dp)
                )
            }
        }
        Text(
            text = "Hint\nYou are guessing bigger than the mystery number!",
            color = Color.White,
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
            lineHeight = 30.sp,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(40.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            value = "",
            onValueChange = {},
            textStyle = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 48.sp
            ),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.Transparent
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 40.dp),
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = YellowDark,
                contentColor = Color.Black
            )
        ) {
            Text(text = "GUESS", fontSize = 18.sp)
        }
    }
}

@Preview
@Composable
fun GuessingGameScreenPreview() {
    GuessingGameScreen()
}