package com.test

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.test.items.ExampleButton
import com.test.items.ExampleText
import com.test.items.UiItem
import com.test.ui.theme.ComposeParallaxScrollTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeParallaxScrollTheme {
                Column {
                    LazyColumn {
                        items(getMultiTypeList().size) { index ->
                            when(val item = getMultiTypeList()[index]) {
                                is UiItem.FirstTypeUiItem -> {
                                    ExampleButton(item.text)
                                }
                                is UiItem.SecondTypeUiItem -> {
                                    CircularProgressIndicator()
                                }
                                is UiItem.ThirdTypeUiItem -> {
                                    ExampleText(item.number)
                                }
                            }
                            Divider(modifier = Modifier.padding(start = 16.dp, end = 16.dp), thickness = 2.dp)
                        }
                    }
                    Text(
                        color = MaterialTheme.colors.primary,
                        text = "Not item of list",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                    Spacer(Modifier.size(dimensionResource(id = R.dimen.spacer_size)))
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
    }

    private fun getMultiTypeList() =
        listOf(
            UiItem.FirstTypeUiItem(text = "FirstTypeUiItem - Example 3"),
            UiItem.ThirdTypeUiItem(number = 1),
            UiItem.FirstTypeUiItem(text = "FirstTypeUiItem - Example 4"),
            UiItem.SecondTypeUiItem,
            UiItem.ThirdTypeUiItem(number = 2),
            UiItem.FirstTypeUiItem(text = "FirstTypeUiItem - Example 2"),
            UiItem.SecondTypeUiItem,
            UiItem.FirstTypeUiItem(text = "FirstTypeUiItem - Example 1"),
            UiItem.SecondTypeUiItem,
            UiItem.ThirdTypeUiItem(number = 3),
            UiItem.SecondTypeUiItem,
        )

    private fun Float.toDp(): Dp {
        return (this / Resources.getSystem().displayMetrics.density).dp
    }

}