package com.test

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

//@Preview(showBackground = true)
//@Composable
//fun EntryScreenPreview() {
//    EntryScreen(MainViewModel())
//}

@Composable
fun EntryScreen(
    viewModel: MainViewModel,
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    onEvent: (String) -> Unit, // Send the 'started' analytics event
) {
    val currentOnEvent by rememberUpdatedState(onEvent)

    DisposableEffect(lifecycleOwner) {
        // Create an observer that triggers our remembered callbacks
        // for sending analytics events
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_START -> {
                    currentOnEvent("ON_START")
                }
                Lifecycle.Event.ON_STOP -> {
                    currentOnEvent("ON_STOP")
                }
                Lifecycle.Event.ON_CREATE -> {
                    currentOnEvent("ON_CREATE")
                }
                Lifecycle.Event.ON_RESUME -> {
                    currentOnEvent("ON_RESUME")
                }
                Lifecycle.Event.ON_PAUSE -> {
                    currentOnEvent("ON_PAUSE")
                }
            }
        }

        // Add the observer to the lifecycle
        lifecycleOwner.lifecycle.addObserver(observer)

        // When the effect leaves the Composition, remove the observer
        onDispose {
            currentOnEvent("ON_DESTROY")
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

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
            text = "to the FIRST screen",
            fontSize = 26.sp,
        )
        Spacer(modifier = Modifier.height(26.dp))
        Button(
            text = "Go Next",
            onClick = { viewModel.onFirstScreenButtonClick() }
        )
    }
}

@Composable
fun Button(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            color = Color.White,
        )
    }
}