package com.test.items

sealed class UiItem {
    data class FirstTypeUiItem(val text: String) : UiItem()
    object SecondTypeUiItem : UiItem()
    data class ThirdTypeUiItem(val number: Int) : UiItem()
}
