package com.test

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.runBlocking

class MainViewModel : ViewModel() {

    private val _events = MutableSharedFlow<MainEvent>()
    val events: SharedFlow<MainEvent> = _events

    fun onFirstScreenButtonClick() {
        runBlocking {
            _events.emit(MainEvent.OpenSecondScreen)
        }
    }

    fun onSecondScreenButtonClick() {
        runBlocking {
            _events.emit(MainEvent.OpenThirdScreen)
        }
    }

    fun onBackButtonClick() {
        runBlocking {
            _events.emit(MainEvent.GoBack)
        }
    }

    fun onThirdScreenButtonClick() {
        runBlocking {
            _events.emit(MainEvent.GoBack)
        }
    }

    sealed class MainEvent {
        object OpenSecondScreen : MainEvent()
        object OpenThirdScreen : MainEvent()
        object GoBack : MainEvent()
    }

}