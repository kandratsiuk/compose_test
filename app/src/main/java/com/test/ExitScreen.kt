package com.test

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Preview(showBackground = true)
@Composable
fun ExitScreenPreview() {
    ExitScreen(MainViewModel())
}

@Composable
fun ExitScreen(viewModel: MainViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Welcome",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "to the THIRD screen",
            fontSize = 26.sp,
        )
        Spacer(modifier = Modifier.height(26.dp))
        Button(
            text = "Go Back",
            onClick = { viewModel.onThirdScreenButtonClick() }
        )
    }
}