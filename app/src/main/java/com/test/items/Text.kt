package com.test.items

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun ExampleText(number: Int) {
    Text(text = "The number is $number", modifier = Modifier.fillMaxWidth(), fontSize = 20.sp)
}