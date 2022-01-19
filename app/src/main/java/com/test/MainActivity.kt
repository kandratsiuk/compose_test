package com.test

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.test.ui.theme.ComposeParallaxScrollTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeParallaxScrollTheme {
                Text(
                    color = MaterialTheme.colors.primary,
                    text = "Sample item",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )

            }
        }
    }

    private fun Float.toDp(): Dp {
        return (this / Resources.getSystem().displayMetrics.density).dp
    }

}